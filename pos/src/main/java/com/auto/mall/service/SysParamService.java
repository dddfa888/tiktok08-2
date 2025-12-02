 

package com.auto.mall.service;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.auto.mall.config.codec.FastJsonCodec;
import com.auto.mall.mapper.SysParamMapper;
import com.auto.mall.model.SysParam;
import com.auto.mall.service.redis.RedisService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class SysParamService extends ServiceImpl<SysParamMapper, SysParam> {
  @Resource
  RedisService redisService;

  public SysParamService() {
  }

  @Transactional(
          readOnly = true
  )
  public String getSysConfig(String key) {
    String value = null;
    JSONObject obj = (JSONObject)this.redisService.get("SYSPARA_CODE_" + key, JSONObject.class, new FastJsonCodec());
    if (null == obj) {
      QueryWrapper<SysParam> wrapper = new QueryWrapper();
      wrapper.eq("code", key);
      SysParam sysParam = (SysParam)((SysParamMapper)this.getBaseMapper()).selectOne(wrapper);
      if (null != sysParam) {
        value = sysParam.getValue();
      }
    } else {
      value = obj.getString("value");
    }

    return value;
  }

  public BigDecimal getLevelRatio(int level) {
    switch (level) {
      case 1:
        return this.getLevelRatio("level_one_rebate_ratio");
      case 2:
        return this.getLevelRatio("level_two_rebate_ratio");
      case 3:
        return this.getLevelRatio("level_three_rebate_ratio");
      default:
        return null;
    }
  }

  private BigDecimal getLevelRatio(String level) {
    String sysConfig = this.getSysConfig(level);
    if (!StrUtil.isBlank(sysConfig)) {
      BigDecimal decimal = new BigDecimal(sysConfig);
      return decimal;
    } else {
      return null;
    }
  }
}
