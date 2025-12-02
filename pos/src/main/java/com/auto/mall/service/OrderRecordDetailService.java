 

package com.auto.mall.service;

import com.auto.mall.api.req.OrderRecordReq;
import com.auto.mall.api.resp.PageResp;
import com.auto.mall.dto.OrderRecordDetailDto;
import com.auto.mall.mapper.OrderRecordDetailMapper;
import com.auto.mall.model.MallOrdersPrize;
import com.auto.mall.model.OrderRecordDetail;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderRecordDetailService extends ServiceImpl<OrderRecordDetailMapper, OrderRecordDetail> {
  public OrderRecordDetailService() {
  }

  @Transactional(
          readOnly = true
  )
  public PageResp<OrderRecordDetailDto> selectOrderRecordDetailByPage(OrderRecordReq req) {
    Page page = req.getPage();
    List<OrderRecordDetailDto> result = ((OrderRecordDetailMapper)this.getBaseMapper()).selectOrderRecordDetailByPage(page, req.getId(), req.getLang());
    return new PageResp(page, result);
  }

  @Transactional(
          readOnly = true
  )
  public List<MallOrdersPrize> queryOrderList(OrderRecordReq req) {
    return ((OrderRecordDetailMapper)this.getBaseMapper()).queryOrderList(req.getPageNo() - 1, req.getPageSize(), req.getId());
  }

  @Transactional(
          readOnly = true
  )
  public long queryOrderTotal(OrderRecordReq req) {
    return ((OrderRecordDetailMapper)this.getBaseMapper()).queryOrderListTotal(req.getPage(), req.getId());
  }
}
