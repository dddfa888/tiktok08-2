

package com.auto.mall.service;

import com.auto.mall.api.req.SellerGoodsReq;
import com.auto.mall.api.resp.CategoryResp;
import com.auto.mall.api.resp.PageResp;
import com.auto.mall.api.resp.PartyResp;
import com.auto.mall.api.resp.SellerResp;
import java.util.List;

public interface CategoryService {
  List<CategoryResp> findCategoryList();

  List<SellerResp> findSellerList(String loginPartyId);

  PageResp findSellerGoodsList(SellerGoodsReq req);

  List<PartyResp> findPartyList();

  int findPartyCount();
}
