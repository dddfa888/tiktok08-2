 

package com.auto.mall.service;

import com.auto.mall.mapper.UserAddressMapper;
import com.auto.mall.model.UserAddress;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserAddressService extends ServiceImpl<UserAddressMapper, UserAddress> {
    public UserAddressService() {
    }
}
