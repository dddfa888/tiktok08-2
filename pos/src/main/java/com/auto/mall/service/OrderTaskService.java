 

package com.auto.mall.service;

import com.auto.mall.mapper.OrderTaskMapper;
import com.auto.mall.model.OrderTask;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderTaskService extends ServiceImpl<OrderTaskMapper, OrderTask> {
  private static final Logger LOGGER = LoggerFactory.getLogger(OrderTaskService.class);

  public OrderTaskService() {
  }
}
