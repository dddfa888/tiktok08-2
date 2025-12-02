 

package com.auto.mall.mapper;

import com.auto.mall.model.MallOrderPrize;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface MallOrderPrizeMapper extends BaseMapper<MallOrderPrize> {
  void updateMallOrderProfitStatus(@Param("uuid") String uuid);
}
