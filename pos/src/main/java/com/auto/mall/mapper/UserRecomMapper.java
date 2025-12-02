 

package com.auto.mall.mapper;

import com.auto.mall.api.resp.PromoteResp;
import com.auto.mall.model.UserRecom;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRecomMapper extends BaseMapper<UserRecom> {
  List<PromoteResp> selectPromoteList(Page page, @Param("objs") List<String> children);
}
