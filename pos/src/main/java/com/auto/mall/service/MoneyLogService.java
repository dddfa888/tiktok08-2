 

package com.auto.mall.service;

import com.auto.mall.mapper.MoneyLogMapper;
import com.auto.mall.model.MoneyLog;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MoneyLogService extends ServiceImpl<MoneyLogMapper, MoneyLog> {
    public MoneyLogService() {
    }
}
