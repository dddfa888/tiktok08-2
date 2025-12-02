 

package com.auto.mall.task;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.auto.mall.api.req.PageReq;
import com.auto.mall.dto.LocalOrderResult;
import com.auto.mall.mapper.OrderRecordMapper;
import com.auto.mall.mapper.OrderTaskMapper;
import com.auto.mall.mapper.SellerGoodMapper;
import com.auto.mall.model.OrderRecord;
import com.auto.mall.model.OrderRecordDetail;
import com.auto.mall.model.OrderTask;
import com.auto.mall.model.SellerGoods;
import com.auto.mall.service.OrderRecordDetailService;
import com.auto.mall.service.OrderRecordService;
import com.auto.mall.utils.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PosOrderTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(PosOrderTask.class);
    @Resource
    private OrderTaskMapper orderTaskMapper;
    @Resource
    private OrderRecordService orderRecordService;
    @Resource
    private OrderRecordDetailService recordDetailService;
    @Resource
    private SellerGoodMapper sellerGoodMapper;
    @Value("${mall.order.api}")
    private String api;

    public PosOrderTask() {
    }

    // @Scheduled(
    //         cron = "0/9 * * * * ? "
    // )
    @Scheduled(cron = "0 0/3 * * * ?")//3分钟一次
    @Transactional
    public void posOrders() {
        try {
            PageReq<OrderTask> page = new PageReq();
            page.setPageNo(0);
            page.setPageSize(20);
            List<OrderTask> orderTasks = this.orderTaskMapper.findOrderTaskByDelayAndStatusPage(page, new Date(), 0);
            Iterator var3 = orderTasks.iterator();

            while(true) {
                while(var3.hasNext()) {
                    OrderTask orderTask = (OrderTask)var3.next();
                    String partyId = orderTask.getPartyId();
                    String uuid = orderTask.getGoodInfo();
                    String[] split1 = uuid.split(",");
                    String goodsId = split1[0];
                    SellerGoods sellerGoods = this.sellerGoodMapper.selectOne(
                            new LambdaQueryWrapper<SellerGoods>()
                                    .eq(SellerGoods::getId, goodsId)
                                    .eq(SellerGoods::getIsValid, 1)
                                    .eq(SellerGoods::getIsShelf, 1)
                    );

                    if (sellerGoods == null) {
                        LOGGER.info("商品已下架或已删除：goodsId {} ", goodsId);
                        orderTask.setStatus(2);
                        this.orderTaskMapper.updateById(orderTask);
                    } else {
                        int count = orderTask.getCount();
                        String orderId = orderTask.getOrderId();
                        BigDecimal amount = orderTask.getAmount();
                        String sellerId = orderTask.getSellerId();

                        try {
                            String value = HttpUtil.post(this.api + "?partyId=" + partyId + "&uuid=" + uuid + "&num=" + count, "", 60000);
                            LOGGER.info("execute batch order:[orderId=>{}, partyId=>{},uuid=>{}, count=>{}, amount=>{}], response:[{}]", new Object[]{orderId, partyId, uuid, count, amount, value});
                            JSONObject object = JSONUtil.parseObj(value);
                            JSONObject data = JSONUtil.parseObj(object.get("data"));
                            LOGGER.info("execute batch response: " + data.toString());
                            List<LocalOrderResult> orderList = data.getBeanList("orderList", LocalOrderResult.class);
                            Set<String> orderSuccess = (Set)orderList.stream().filter((o) -> {
                                return o != null && StringUtils.isNotEmpty(o.getOrderId());
                            }).map(LocalOrderResult::getOrderId).collect(Collectors.toSet());
                            String[] split = split1;
                            this.orderRecordService.updateItem(orderId, uuid, count, amount, orderSuccess);
                            if (CollectionUtil.isNotEmpty(orderSuccess)) {
                                Iterator var20 = orderSuccess.iterator();

                                while(var20.hasNext()) {
                                    String success = (String)var20.next();
                                    OrderRecordDetail detail = new OrderRecordDetail(orderId, success, partyId, amount, sellerId, split[0], split[1], count);
                                    this.recordDetailService.save(detail);
                                }

                                orderTask.setStatus(1);
                                this.orderTaskMapper.updateById(orderTask);
                            }
                        } catch (Exception var23) {
                            Exception e = var23;
                            LOGGER.error("pos下单失败", e);
                        }
                    }
                }

                return;
            }
        } catch (Exception var24) {
            Exception e = var24;
            LOGGER.error("pos下单异常", e);
        }
    }

    @Scheduled(
            cron = "0 0/1 * * * ? "
    )
    @Transactional
    public void updateOrderStatus() {
        try {
            Page<OrderRecord> page = new Page();
            page.setSize(20L);
            page.setCurrent(0L);
            IPage<OrderRecord> batch = this.orderRecordService.getBaseMapper().selectPage(
                    page,
                    new LambdaQueryWrapper<OrderRecord>()
                            .eq(OrderRecord::getStatus, 1)
                            .eq(OrderRecord::getType, "batch")
            );

            List<OrderRecord> records = batch.getRecords();
            Page<OrderTask> page2 = new Page();
            page.setSize(20L);
            page.setCurrent(0L);
            Iterator var5 = records.iterator();

            while(var5.hasNext()) {
                OrderRecord record = (OrderRecord)var5.next();
                IPage<OrderTask> orderTaskIPage = this.orderTaskMapper.selectPage(page2,
                        new LambdaQueryWrapper<OrderTask>().eq(OrderTask::getOrderId, record.getId()).eq(OrderTask::getStatus, 0));

                if (CollectionUtils.isEmpty(orderTaskIPage.getRecords())) {
                    record.setStatus(2);
                    ((OrderRecordMapper)this.orderRecordService.getBaseMapper()).updateById(record);
                }
            }
        } catch (Exception var8) {
            Exception e = var8;
            LOGGER.error("更新批量任务状态异常", e);
        }

    }

    @Scheduled(
            cron = "0 0 2 ? * Fri"
    )
    @Transactional
    public void deleteOrderTask() {
        try {
            LocalDateTime dateTime = LocalDateTime.now().minusWeeks(1L);
            this.orderTaskMapper.delete(
                    new LambdaQueryWrapper<OrderTask>()
                            .le(OrderTask::getDelay, dateTime)
                            .ne(OrderTask::getStatus, 0)
            );

        } catch (Exception var2) {
            Exception e = var2;
            LOGGER.error("批量删除任务状态异常", e);
        }

    }
}
