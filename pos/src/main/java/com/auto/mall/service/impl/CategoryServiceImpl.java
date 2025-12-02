 

package com.auto.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.auto.mall.api.req.SellerGoodsReq;
import com.auto.mall.api.resp.*;
import com.auto.mall.mapper.CategoryMapper;
import com.auto.mall.model.UserRecom;
import com.auto.mall.service.CategoryService;
import com.auto.mall.service.redis.RedisService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    RedisService redisService;

    public CategoryServiceImpl() {
    }

    public List<CategoryResp> findCategoryList() {
        return this.categoryMapper.findCategoryList();
    }

    @Transactional(
            readOnly = true
    )
    public List<SellerResp> findSellerList(String loginPartyId) {
        List<SellerResp> sellerResps = this.categoryMapper.findSellerList();
        if (loginPartyId != null) {
            List<String> children = this.findChildren(loginPartyId);
            sellerResps = (List)sellerResps.stream().filter((s) -> {
                return children.stream().filter((f) -> {
                    return f.equals(s.getSellerId());
                }).findAny().isPresent();
            }).collect(Collectors.toList());
        }

        return sellerResps;
    }

    @Transactional(
            readOnly = true
    )
    public PageResp findSellerGoodsList(SellerGoodsReq req) {
        Page page = req.getPage();
        String loginPartyId = req.getLoginPartyId();
        List<SellerGoodsResp> sellerGoodsList = null;
        if (StrUtil.isBlank(loginPartyId)) {
            sellerGoodsList = this.categoryMapper.findSellerGoodsList(page, req);
        } else {
            List<String> children = this.findChildren(loginPartyId);
            req.setChildren(children);
            sellerGoodsList = this.categoryMapper.findSellerGoodsList(page, req);
        }

        PageResp pageResp = new PageResp(page, sellerGoodsList);
        return pageResp;
    }

    @Transactional(
            readOnly = true
    )
    public List<PartyResp> findPartyList() {
        return this.categoryMapper.findPartyList();
    }

    @Transactional(
            readOnly = true
    )
    public int findPartyCount() {
        return this.categoryMapper.findPartyCount();
    }

    public List<String> findChildren(String partyId) {
        List list = new ArrayList();
         list = this.findChildren(partyId, list);
        return list;
    }

    private List<String> findChildren(Serializable partyId, List<String> list) {
        List recom_list = this.findRecoms(partyId);

        for(int i = 0; i < recom_list.size(); ++i) {
            list.add(((UserRecom)recom_list.get(i)).getPartyId().toString());
            this.findChildren(((UserRecom)recom_list.get(i)).getPartyId().toString(), list);
        }

        return list;
    }

    public List<UserRecom> findRecoms(Serializable partyId) {
        List<UserRecom> list = new ArrayList();
        JSONArray jsonArray = (JSONArray)this.redisService.get("USER_RECOM_RECO_ID_" + partyId.toString(), JSONArray.class);
        if (!Objects.isNull(jsonArray) && !jsonArray.isEmpty()) {
            Iterator var4 = jsonArray.iterator();

            while(var4.hasNext()) {
                Object o = var4.next();
                UserRecom userRecom = new UserRecom();
                JSONObject object = (JSONObject)o;
                userRecom.setPartyId((String)object.get("partyId"));
                list.add(userRecom);
            }
        }

        return list;
    }
}
