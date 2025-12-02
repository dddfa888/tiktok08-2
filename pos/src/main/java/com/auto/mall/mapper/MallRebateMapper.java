 

package com.auto.mall.mapper;

import com.auto.mall.dto.MallRebateDto;
import com.auto.mall.model.MallRebate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface MallRebateMapper extends BaseMapper<MallRebate> {
  MallRebateDto selectOrderRebate(@Param("uuid") String uuid, @Param("partyId") String partyId);
}
