

package com.auto.mall.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.auto.mall.api.req.BatchOrderReq;
import com.auto.mall.api.req.ItemReq;
import com.auto.mall.api.req.OrderRecordReq;
import com.auto.mall.api.req.OrderReq;
import com.auto.mall.api.resp.GoodResp;
import com.auto.mall.api.resp.PageResp;
import com.auto.mall.api.resp.PartyResp;
import com.auto.mall.dto.LocalOrderResult;
import com.auto.mall.exception.MallToolGlobalException;
import com.auto.mall.mapper.GoodMapper;
import com.auto.mall.mapper.OrderRecordMapper;
import com.auto.mall.mapper.SellerGoodMapper;
import com.auto.mall.model.OrderRecord;
import com.auto.mall.model.OrderTask;
import com.auto.mall.model.SellerGoods;
import com.auto.mall.response.JsonResponse;
import com.auto.mall.service.support.OrderItemBuilder;
import com.auto.mall.service.support.wheel.OrderTimeWheelScheduler;
import com.auto.mall.utils.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Scope("prototype")
@Service
public class OrderRecordService extends ServiceImpl<OrderRecordMapper, OrderRecord> {
    private static final Logger logger = LoggerFactory.getLogger(OrderRecordService.class);
    public static final String SINGLE = "single";
    public static final String BATCH = "batch";
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Resource
    GoodService goodService;
    @Resource
    private SellerGoodService sellerGoodService;
    @Resource
    OrderRecordDetailService recordDetailService;
    @Resource
    private SysParamService sysParamService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private OrderTaskService orderTaskService;
    @Value("${mall.order.api}")
    private String api;
    OrderTimeWheelScheduler scheduler = OrderTimeWheelScheduler.getInstance();
    Random random = new Random();
    private final int MIN_TO_SEC = 60;
    private long start_time;
    private long end_time;
    private long current_time;
    private long max_time;
    private int time_limit_min;
    private int time_limit_max;
    private BigDecimal price_min;
    private BigDecimal price_max;
    private BigDecimal order_amount;
    private BigDecimal total_amount = new BigDecimal(0);
    private List<GoodResp> items;
    private List<String> skuIds;
    private List<String> partyIds;
    private Set<String> order_party;

    public OrderRecordService() {
    }

    @Transactional
    public void order(BatchOrderReq req) {
        String[] datetime = req.getDatetime();
        BigDecimal[] price_limit = req.getPrice_limit();
        this.start_time = this.formatter(datetime[0]).getTime() / 1000L;
        this.end_time = this.formatter(datetime[1]).getTime() / 1000L;
        this.current_time = this.start_time - System.currentTimeMillis() / 1000L;
        this.max_time = this.end_time - System.currentTimeMillis() / 1000L;
        this.price_min = price_limit[0];
        this.price_max = price_limit[1];
        this.order_amount = new BigDecimal(0.0);
        this.partyIds = req.getPartyIds();
        this.skuIds = req.getSkuIds();
        this.items = this.goodService.selectGoodsByItemsAndSku(req.getItems(), req.getSkuIds());
        if (CollectionUtils.isEmpty(this.items)) {
            throw new MallToolGlobalException("没找到对应商品");
        } else {
            logger.info("进入");
            List<PartyResp> partyList = this.categoryService.findPartyList();
            if (CollectionUtils.isEmpty(partyList)) {
                throw new MallToolGlobalException("未找到虚拟用户");
            } else {
                int count = 0;
                int total_count = req.getTotal_count();
                List<OrderTask> orderTaskList = new ArrayList();
                logger.info("进入1");

                while (true) {
                    logger.info("进入2");
                    int p = this.random.nextInt(partyList.size());
                    PartyResp partyResp = (PartyResp) partyList.get(p);
                    String partyId = partyResp.getPartyId();
                    int i = this.random.nextInt(this.items.size());
                    GoodResp goodResp = (GoodResp) this.items.get(i);
                    if (count >= total_count) {
                        if (CollectionUtil.isNotEmpty(orderTaskList)) {
                            OrderRecord record = new OrderRecord();
                            record.setStart_time(new Date(this.start_time * 1000L));
                            record.setEnd_time(new Date(this.end_time * 1000L));
                            record.setOrder_spacing_start(this.time_limit_min);
                            record.setOrder_spacing_end(this.time_limit_max);
                            record.setBuy_amount_start(this.price_min);
                            record.setBuy_amount_end(this.price_max);
                            record.setLump_amount(this.total_amount);
                            record.setStatus(1);
                            record.setOrder_amount(this.order_amount);
                            record.setType("batch");
                            record.setCreateTime(new Date());
                            record.setCreateUser(req.getCreateUser());
                            record.setOrderNumAll(orderTaskList.size());
                            ((OrderRecordMapper) this.getBaseMapper()).insert(record);
                            String orderId = record.getId();
                            this.saveOrderTask(orderId, orderTaskList);
                        }

                        return;
                    }

                    BigDecimal sellingPrice = goodResp.getSellingPrice();
                    if (sellingPrice.compareTo(new BigDecimal(0)) > 0) {
                        int calculateOrder = this.calculate_order(sellingPrice);
                        BigDecimal currentAmount = sellingPrice.multiply(new BigDecimal(calculateOrder));
                        if (currentAmount.compareTo(new BigDecimal(0)) != 0) {
                            OrderTask orderTask = new OrderTask();
                            orderTask.setAmount(currentAmount);
                            orderTask.setCount(calculateOrder);
                            orderTask.setDelay(new Date(this.next_time() * 1000L));
                            orderTask.setPartyId(partyId);
                            orderTask.setSellerId(goodResp.getSellerId());
                            String skuId = goodResp.getSkuId();
                            String uuid = goodResp.getUuid() + "," + (StringUtils.isEmpty(skuId) ? "-1" : skuId);
                            orderTask.setGoodInfo(uuid);
                            orderTaskList.add(orderTask);
                            this.total_amount = this.total_amount.add(currentAmount);
                            ++count;
                            logger.info("进入3");
                        }
                    }
                }
            }
        }
    }

    private void saveOrderTask(String orderId, List<OrderTask> orderTaskList) {
        Iterator var3 = orderTaskList.iterator();

        while (var3.hasNext()) {
            OrderTask orderTask = (OrderTask) var3.next();
            orderTask.setOrderId(orderId);
            orderTask.setStatus(0);
            this.orderTaskService.save(orderTask);
        }

    }

    @Transactional
    public void updateItem(String key, String uuid, int count, BigDecimal amount, Set<String> orderIds) {
        OrderRecord record = (OrderRecord) ((OrderRecordMapper) this.getBaseMapper()).selectById(key);
        if (null != record) {
            logger.info("update order record:[orderId=>{}, itemId=>{}, count=>{}, amount=>{}]", key);
            BigDecimal order_amount = record.getOrder_amount();
            Integer order_num = record.getOrder_num();
            order_num = order_num + 1;
            order_amount = order_amount.add(amount);
            record.setOrder_amount(order_amount);
            record.setOrder_num(order_num);
            if (order_num.equals(record.getOrderNumAll())) {
                record.setStatus(2);
            }

            String orderIdsOrigin = record.getOrderIds();
            if (StringUtils.isEmpty(orderIdsOrigin)) {
                orderIdsOrigin = (String) orderIds.stream().collect(Collectors.joining(","));
                record.setOrderIds(orderIdsOrigin);
            } else {
                record.setOrderIds((String) orderIds.stream().collect(Collectors.joining(",")));
            }

            ((OrderRecordMapper) this.getBaseMapper()).updateById(record);
        }

        ((GoodMapper) this.goodService.getBaseMapper()).updateVieNumber(uuid, count * 2);
    }

    public OrderRecord recordSingleNew(OrderReq req) {
        OrderRecord record = new OrderRecord();
        record.setLump_amount(this.total_amount);
        record.setStatus(1);
        record.setOrder_amount(this.order_amount);
        record.setType("single");
        record.setCreateTime(new Date());
        List<String> itemIds = (List) req.getItems().stream().map(ItemReq::getItemId).collect(Collectors.toList());
        long sellersCount = ((SellerGoodMapper) this.sellerGoodService.getBaseMapper()).selectBatchIds(itemIds).stream().map(SellerGoods::getSellerId).distinct().count();
        record.setOrderNumAll((int) sellersCount);
        record.setCreateUser(req.getCreateUser());
        ((OrderRecordMapper) this.getBaseMapper()).insert(record);
        return record;
    }

    @Transactional
    public JsonResponse orderSingle(OrderReq req) {
        OrderRecord record = this.recordSingleNew(req);
        JsonResponse response = JsonResponse.success();
        List<ItemReq> items = req.getItems();
        if (CollectionUtil.isNotEmpty(items)) {
            String uuid = "";
            String num = "";

            ItemReq item;
            for (Iterator var7 = items.iterator(); var7.hasNext(); num = num + item.getCount() + ",") {
                item = (ItemReq) var7.next();
                uuid = uuid + item.getItemId() + "," + (StringUtils.isEmpty(item.getSkuId()) ? "-1" : item.getSkuId()) + ",";
            }

            if (StrUtil.isNotBlank(uuid)) {
                uuid = uuid.substring(0, uuid.length() - 1);
            }

            if (StrUtil.isNotBlank(num)) {
                num = num.substring(0, num.length() - 1);
            }

            String post = HttpUtil.post(this.api + "?partyId=" + req.getPartyId() + "&uuid=" + uuid + "&num=" + num, "", 5000);
            logger.info("execute batch order:[ partyId=>{},uuid=>{}, count=>{}, response:[{}]", new Object[]{req.getPartyId(), uuid, num, post});

            try {
                JSONObject object = JSONUtil.parseObj(post);
                String code = (String) object.get("code", String.class);
                response = JsonResponse.success(Integer.valueOf((String) object.get("code", String.class)), (String) object.get("msg", String.class), object.get("data", Object.class));
                if (!"0".equalsIgnoreCase(code)) {
                    this.updateStatus(record.getId(), 3);
                    return response;
                }

                JSONObject data = JSONUtil.parseObj(object.get("data"));
                List<LocalOrderResult> orderList = data.getBeanList("orderList", LocalOrderResult.class);
                Set<String> orderSuccess = (Set) orderList.stream().filter((o) -> {
                    return o != null && StringUtils.isNotEmpty(o.getOrderId());
                }).map(LocalOrderResult::getOrderId).collect(Collectors.toSet());
                String orderIds = (String) orderSuccess.stream().collect(Collectors.joining(","));
                this.updateSingleSuccess(record.getId(), orderIds);
            } catch (Exception var14) {
                JsonResponse.success(-1, "下单失败");
                this.updateStatus(record.getId(), 3);
            }
        }

        return response;
    }

    public void updateSingleSuccess(String orderRecordId, String orderIds) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("uuid", orderRecordId);
        updateWrapper.set("order_ids", orderIds);
        updateWrapper.set("status", 2);
        ((OrderRecordMapper) this.getBaseMapper()).update(new OrderRecord(), updateWrapper);
    }

    public void updateStatus(String orderRecordId, int status) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("uuid", orderRecordId);
        updateWrapper.set("status", status);
        ((OrderRecordMapper) this.getBaseMapper()).update(new OrderRecord(), updateWrapper);
    }

    private void create_order(String orderId, List<OrderItemBuilder> orderItemBuilders) {
        Iterator var3 = orderItemBuilders.iterator();

        while (var3.hasNext()) {
            OrderItemBuilder builder = (OrderItemBuilder) var3.next();
            builder.setOrderId(orderId);
            builder.setApi(this.api);
            builder.setOrderRecordService(this);
            builder.setRecordDetailService(this.recordDetailService);
            this.scheduler.schedule(orderId, builder, builder.getDelay(), TimeUnit.SECONDS);
            logger.info("register order:[orderId=>{}, partyId=>{}, uuid=>{}, count={}, amount=>{}, delay=>{}]", new Object[]{orderId, builder.getPartyId(), builder.getUuid(), builder.getCount(), builder.getAmount(), builder.getDelay()});
        }

    }

    private long next_time() {
        long nextLong = this.random.nextLong();
        nextLong = Math.abs(nextLong) % (this.start_time - this.end_time + 1L) + this.start_time;
        return nextLong == 0L ? this.start_time : nextLong;
    }

    private GoodResp poll_item() {
        int size = this.items.size();
        int nextInt = this.random.nextInt(size);
        return (GoodResp) this.items.get(nextInt);
    }

    private int calculate_order(BigDecimal price) {
        int min_count = this.price_min.divide(price, 3).intValue();
        int max_count = this.price_max.divide(price, 3).intValue();
        if (max_count == 0) {
            return 0;
        } else if (max_count - min_count == 0) {
            return 1;
        } else {
            int count = this.random.nextInt(max_count - min_count) + min_count;
            return count == 0 ? 1 : count;
        }
    }

    private String poll_party() {
        int size = this.partyIds.size();
        return (String) this.partyIds.get(this.random.nextInt(size));
    }

    private Date formatter(String varchar) {
        Date currentDate = new Date();

        try {
            Date date = this.format.parse(varchar);
            if (date.after(currentDate)) {
                currentDate = date;
            }
        } catch (ParseException var4) {
            ParseException e = var4;
            e.printStackTrace();
        }

        return currentDate;
    }

    @Transactional
    public void cancel(String orderId) {
        OrderRecord record = (OrderRecord) ((OrderRecordMapper) this.getBaseMapper()).selectById(orderId);
        if (null != record) {
            Date end_time = record.getEnd_time();
            if (end_time != null && end_time.after(new Date())) {
                LambdaUpdateWrapper<OrderTask> updateWrapper = new LambdaUpdateWrapper();
                updateWrapper.eq(OrderTask::getStatus, 0);
                updateWrapper.eq(OrderTask::getOrderId, record.getId());
                updateWrapper.set(OrderTask::getStatus, 1);
                this.orderTaskService.update(updateWrapper);
            }

            record.setStatus(5);
            ((OrderRecordMapper) this.getBaseMapper()).updateById(record);
        }

    }

    @Transactional(
            readOnly = true
    )
    public PageResp<OrderRecord> findOrderRecordByPage(OrderRecordReq req) {
        Page page = req.getPage();
        String status = req.getStatus();
        String id = req.getId();
        String startTime = req.getStartTime();
        String endTime = req.getEndTime();
        QueryWrapper<OrderRecord> queryWrapper = new QueryWrapper();
        queryWrapper.eq(StringUtils.isNotEmpty(id), "uuid", id);
        queryWrapper.eq(!"-2".equals(status), "status", status);
        queryWrapper.eq("type", "batch");
        queryWrapper.ge(StringUtils.isNotEmpty(startTime), "create_time", startTime);
        queryWrapper.le(StringUtils.isNotEmpty(endTime), "create_time", endTime);
        queryWrapper.orderByDesc("create_time");
        List records = ((OrderRecordMapper) this.getBaseMapper()).selectPage(page, queryWrapper).getRecords();
        for (Object record : records) {
            OrderRecord obj = (OrderRecord) record;
            obj.setSellerId(this.getBaseMapper().selectSellerId(obj.getId()));
        }
        return new PageResp(page, records);
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap();
        map.put("L1", 40);
        map.put("L2", 30);
        map.put("L3", 40);
        map.put("L4", 60);
        List<Map.Entry<String, Integer>> entrySet = new ArrayList(map.entrySet());

        for (int i = 0; i < entrySet.size(); ++i) {
            for (int j = i + 1; j < entrySet.size(); ++j) {
                if ((Integer) ((Map.Entry) entrySet.get(i)).getValue() >= (Integer) ((Map.Entry) entrySet.get(j)).getValue()) {
                    System.out.println("数据校验不合格，" + (String) ((Map.Entry) entrySet.get(i)).getKey() + " 大于等于 " + (String) ((Map.Entry) entrySet.get(j)).getKey());
                }
            }
        }

    }


}
