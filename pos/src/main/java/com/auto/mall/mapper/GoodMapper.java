 

package com.auto.mall.mapper;

import com.auto.mall.api.resp.GoodResp;
import com.auto.mall.model.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodMapper extends BaseMapper<Goods> {
  void updateVieNumber(@Param("uuid") String uuid, @Param("count") int count);

  List<GoodResp> selectGoodsByItemsAndSku(@Param("items") List<String> items, @Param("skuIds") List<String> skuIds);
}
