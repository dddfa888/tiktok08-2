 

package com.auto.mall.mapper;

import com.auto.mall.api.req.SellerGoodsReq;
import com.auto.mall.api.resp.CategoryResp;
import com.auto.mall.api.resp.PartyResp;
import com.auto.mall.api.resp.SellerGoodsResp;
import com.auto.mall.api.resp.SellerResp;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
  List<CategoryResp> findCategoryList();

  List<SellerResp> findSellerList();

  List<SellerGoodsResp> findSellerGoodsList(Page page, @Param("obj") SellerGoodsReq req);

  List<PartyResp> findPartyList();

  int findPartyCount();
}
