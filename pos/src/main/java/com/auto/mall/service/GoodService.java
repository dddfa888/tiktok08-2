 

package com.auto.mall.service;

import cn.hutool.core.collection.CollectionUtil;
import com.auto.mall.api.resp.GoodResp;
import com.auto.mall.mapper.GoodMapper;
import com.auto.mall.model.Goods;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class GoodService extends ServiceImpl<GoodMapper, Goods> {
  public GoodService() {
  }

  @Transactional(
          readOnly = true
  )
  public List<GoodResp> selectGoodsByItemsAndSku(List<String> items, List<String> skuIds) {
    List<GoodResp> goodRespList = ((GoodMapper)this.getBaseMapper()).selectGoodsByItemsAndSku(items, skuIds);
    if (CollectionUtil.isNotEmpty(goodRespList)) {
      Date now = new Date();
      goodRespList.forEach((e) -> {
        if (e.getDiscountPrice().compareTo(new BigDecimal(0.0)) > 0 && now.before(e.getDiscountEndTime()) && now.after(e.getDiscountStartTime())) {
          e.setSellingPrice(e.getDiscountPrice());
        }

      });
    }

    return goodRespList;
  }
}
