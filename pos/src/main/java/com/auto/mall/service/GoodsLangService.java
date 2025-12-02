package com.auto.mall.service;

import com.auto.mall.mapper.GoodsLangMapper;
import com.auto.mall.model.GoodsLang;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class GoodsLangService extends ServiceImpl<GoodsLangMapper, GoodsLang> {
    public GoodsLangService() {
    }
}
