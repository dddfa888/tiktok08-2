 

package com.auto.mall.api;

import cn.hutool.core.collection.CollectionUtil;
import com.auto.mall.api.req.*;
import com.auto.mall.api.resp.PageResp;
import com.auto.mall.exception.MallToolGlobalException;
import com.auto.mall.response.JsonResponse;
import com.auto.mall.service.ItemService;
import com.auto.mall.service.OrderRecordService;
import com.auto.mall.utils.SpringUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping({"/api/item"})
public class ItemController {
    @Resource
    ItemService itemService;
    @Resource
    OrderRecordService singleTonOrderRecordService;

    public ItemController() {
    }

    @PostMapping({"/collect"})
    public JsonResponse collect(@RequestBody ItemCollectionReq req) {
        this.itemService.collect(req.getUrl(), req.getCategory());
        return JsonResponse.success();
    }

    @PostMapping({"/order"})
    public JsonResponse order(@RequestBody BatchOrderReq req) {
        try {
            ((OrderRecordService)SpringUtil.getBean(OrderRecordService.class)).order(req);
        } catch (MallToolGlobalException var3) {
            MallToolGlobalException e = var3;
            return JsonResponse.fail(500, e.getMessage());
        }

        return JsonResponse.success();
    }

    @PostMapping({"/order/single"})
    public JsonResponse order(@RequestBody OrderReq req) {
        JsonResponse response = this.singleTonOrderRecordService.orderSingle(req);
        return response;
    }

    @PostMapping({"/cancel"})
    public JsonResponse cancel(@RequestBody OrderCancelReq req) {
        this.singleTonOrderRecordService.cancel(req.getOrderId());
        return JsonResponse.success();
    }

    @PostMapping({"/cancelBatch"})
    public JsonResponse cancel(@RequestBody OrderCancelBatchReq req) {
        List<String> orderIds = req.getOrderIds();
        if (CollectionUtil.isEmpty(orderIds)) {
            return JsonResponse.success();
        } else {
            Stream<String>  var10000 = orderIds.stream();
            OrderRecordService var10001 = this.singleTonOrderRecordService;
            var10000.forEach(var10001::cancel);
            return JsonResponse.success();
        }
    }

    @PostMapping({"/storage"})
    public JsonResponse storage(@RequestBody GoodsReq req) {
        this.itemService.storage(req);
        return JsonResponse.success();
    }

    @PostMapping({"/findCategoryList"})
    public JsonResponse findCategoryList() {
        return JsonResponse.success(200, "", this.itemService.findCategoryList());
    }

    @PostMapping({"/findPartyList"})
    public JsonResponse findPartyList() {
        return JsonResponse.success(200, "", this.itemService.findPartyList());
    }

    @PostMapping({"/findPartyCount"})
    public JsonResponse findPartyCount() {
        return JsonResponse.success(200, "", this.itemService.findPartyCount());
    }

    @PostMapping({"/findSellerList"})
    public JsonResponse findSellerList(String loginPartyId) {
        return JsonResponse.success(200, "", this.itemService.findSellerList(loginPartyId));
    }

    @PostMapping({"/findSellerGoodsList"})
    public PageResp findSellerGoodsList(@RequestBody SellerGoodsReq req) {
        if (req != null && req.getSellerId() != null) {
            req.setSellerId(req.getSellerId().replaceAll("\\s+", ""));
        }
        if(req != null && req.getUserCode() != null){
            req.setUserCode(req.getUserCode().replaceAll("\\s+", ""));
        }
        PageResp sellerGoodsList = this.itemService.findSellerGoodsList(req);
        return sellerGoodsList;
    }

    @PostMapping({"/findUserAddressById"})
    public JsonResponse findUserAddressById(@RequestBody UserAddressReq req) {
        return JsonResponse.success(200, "", this.itemService.findUserAddressById(req));
    }
}
