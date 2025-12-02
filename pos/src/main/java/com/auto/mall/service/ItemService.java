 

package com.auto.mall.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import com.auto.mall.api.req.CommentReq;
import com.auto.mall.api.req.GoodsReq;
import com.auto.mall.api.req.SellerGoodsReq;
import com.auto.mall.api.req.UserAddressReq;
import com.auto.mall.api.resp.CategoryResp;
import com.auto.mall.api.resp.PageResp;
import com.auto.mall.api.resp.PartyResp;
import com.auto.mall.api.resp.SellerResp;
import com.auto.mall.mapper.GoodMapper;
import com.auto.mall.mapper.GoodsLangMapper;
import com.auto.mall.model.Comment;
import com.auto.mall.model.Goods;
import com.auto.mall.model.GoodsLang;
import com.auto.mall.model.UserAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ItemService {
    private static final Logger logger = LoggerFactory.getLogger(ItemService.class);
    @Resource
    GoodService goodService;
    @Resource
    GoodsLangService goodsLangService;
    @Resource
    CommentService commentService;
    @Resource
    CategoryService categoryService;
    @Resource
    UserAddressService userAddressService;

    public ItemService() {
    }

    public void collect(String url, String category) {
        JSONObject object = new JSONObject();
        object.set("url", url);
        object.set("category", category);
        String post = HttpUtil.post("http://127.0.0.1:5000/spider", object.toJSONString(2));
        System.out.println(post);
    }

    @Transactional
    public void storage(GoodsReq req) {
        try {
            logger.info("storage item info: {}", req.toString());
            Goods good = new Goods(req);
            ((GoodMapper)this.goodService.getBaseMapper()).insert(good);
            GoodsLang goodLang = new GoodsLang(req, good.getId());
            ((GoodsLangMapper)this.goodsLangService.getBaseMapper()).insert(goodLang);
            this.saveComment(req.getComments(), req.getCategory(), good.getId());
            logger.info("保存商品成功：[{}]", req.getTitle());
        } catch (Exception var4) {
            Exception ex = var4;
            ex.printStackTrace();
            logger.info("保存商品失败：[{}] ==> {}", req.getTitle(), ex);
        }

    }

    private void saveComment(List<CommentReq> comments, String category, String goodId) {
        if (CollectionUtil.isNotEmpty(comments)) {
            List<Comment> result = new ArrayList();
            Iterator var5 = comments.iterator();

            while(var5.hasNext()) {
                CommentReq req = (CommentReq)var5.next();
                result.add(new Comment(req, category, goodId));
            }

            this.commentService.saveBatch(result);
        }

    }

    @Transactional(
            readOnly = true
    )
    public List<CategoryResp> findCategoryList() {
        return this.categoryService.findCategoryList();
    }

    @Transactional(
            readOnly = true
    )
    public List<SellerResp> findSellerList(String loginPartyId) {
        return this.categoryService.findSellerList(loginPartyId);
    }

    @Transactional(
            readOnly = true
    )
    public PageResp findSellerGoodsList(SellerGoodsReq req) {
        return this.categoryService.findSellerGoodsList(req);
    }

    @Transactional(
            readOnly = true
    )
    public List<PartyResp> findPartyList() {
        return this.categoryService.findPartyList();
    }

    @Transactional(
            readOnly = true
    )
    public UserAddress findUserAddressById(UserAddressReq req) {
        return (UserAddress)this.userAddressService.getById(req.getUserAddressId());
    }

    @Transactional(
            readOnly = true
    )
    public int findPartyCount() {
        return this.categoryService.findPartyCount();
    }
}
