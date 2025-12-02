 

package com.auto.mall.api;

import cn.hutool.core.bean.BeanUtil;
import com.auto.mall.api.req.OrderRecordReq;
import com.auto.mall.api.resp.MallOrdersPrizeResp;
import com.auto.mall.api.resp.PageResp;
import com.auto.mall.dto.OrderRecordDetailDto;
import com.auto.mall.model.MallOrdersPrize;
import com.auto.mall.model.OrderRecord;
import com.auto.mall.service.MallOrdersPrizeService;
import com.auto.mall.service.OrderRecordDetailService;
import com.auto.mall.service.OrderRecordService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping({"/api/orderRecord"})
public class OrderRecordController {
  @Autowired
  private OrderRecordService orderRecordService;
  @Autowired
  private MallOrdersPrizeService mallOrdersPrizeService;
  @Resource
  OrderRecordDetailService recordDetailService;

  public OrderRecordController() {
  }

  @PostMapping({"/list"})
  public PageResp<OrderRecord> findOrderRecordList(@RequestBody OrderRecordReq req) {
    return this.orderRecordService.findOrderRecordByPage(req);
  }

  @PostMapping({"/list/detail"})
  public PageResp<OrderRecordDetailDto> orderDetail(@RequestBody OrderRecordReq req) {
    return this.recordDetailService.selectOrderRecordDetailByPage(req);
  }

  @PostMapping({"/details/orderedList"})
  public PageResp<MallOrdersPrizeResp> findSellerGoodsList(@RequestBody OrderRecordReq req) {
    List<MallOrdersPrize> mallOrdersPrizes = this.recordDetailService.queryOrderList(req);
    long total = this.recordDetailService.queryOrderTotal(req);
    List<MallOrdersPrizeResp> mallOrdersPrizeResps = BeanUtil.copyToList(mallOrdersPrizes, MallOrdersPrizeResp.class);
    Page page = req.getPage();
    page.setTotal(total);
    return new PageResp(page, mallOrdersPrizeResps);
  }
}
