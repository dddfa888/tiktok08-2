 

package com.auto.mall.mapper;

import com.auto.mall.dto.OrderRecordDetailDto;
import com.auto.mall.model.MallOrdersPrize;
import com.auto.mall.model.OrderRecordDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderRecordDetailMapper extends BaseMapper<OrderRecordDetail> {
  List<OrderRecordDetailDto> selectOrderRecordDetailByPage(Page page, @Param("id") String id, @Param("lang") String lang);

  List<MallOrdersPrize> queryOrderList(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize, @Param("id") String id);

  long queryOrderListTotal(Page page, String id);
}
