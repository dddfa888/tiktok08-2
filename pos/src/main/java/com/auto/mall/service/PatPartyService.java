 

package com.auto.mall.service;

import com.auto.mall.mapper.PatPartyMapper;
import com.auto.mall.model.PatParty;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PatPartyService extends ServiceImpl<PatPartyMapper, PatParty> {
    public PatPartyService() {
    }
}
