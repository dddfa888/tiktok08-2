 

package com.auto.mall.service;

import com.auto.mall.mapper.WalletMapper;
import com.auto.mall.model.Wallet;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class WalletService extends ServiceImpl<WalletMapper, Wallet> {
    public WalletService() {
    }
}
