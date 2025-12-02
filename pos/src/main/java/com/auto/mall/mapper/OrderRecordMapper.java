 

package com.auto.mall.mapper;

import com.auto.mall.model.OrderRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

public interface OrderRecordMapper extends BaseMapper<OrderRecord> {
    @Select("SELECT USERCODE FROM T_MALL_ORDER_TASK A LEFT JOIN PAT_PARTY B ON B.UUID=A.SELLER_ID WHERE ORDER_ID =#{ID} LIMIT 1 ")
    String selectSellerId(String id);
}
