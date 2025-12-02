 

package com.auto.mall.service;

import com.auto.mall.mapper.SellerGoodMapper;
import com.auto.mall.model.SellerGoods;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SellerGoodService extends ServiceImpl<SellerGoodMapper, SellerGoods> {
    public SellerGoodService() {
    }
}
