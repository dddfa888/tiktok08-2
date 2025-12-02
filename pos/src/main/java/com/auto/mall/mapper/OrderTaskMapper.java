 

package com.auto.mall.mapper;

import com.auto.mall.api.req.PageReq;
import com.auto.mall.model.OrderTask;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderTaskMapper extends BaseMapper<OrderTask> {
  List<OrderTask> findOrderTaskByDelayAndStatusPage(@Param("page") PageReq<OrderTask> page, @Param("date") Date date, @Param("status") int status);
}
