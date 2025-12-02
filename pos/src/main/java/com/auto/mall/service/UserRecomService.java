 

package com.auto.mall.service;

import cn.hutool.core.collection.CollectionUtil;
import com.auto.mall.api.req.PromoteReq;
import com.auto.mall.api.resp.PromoteResp;
import com.auto.mall.dto.MallRebateDto;
import com.auto.mall.mapper.MallRebateMapper;
import com.auto.mall.mapper.UserRecomMapper;
import com.auto.mall.model.UserRecom;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRecomService extends ServiceImpl<UserRecomMapper, UserRecom> {
  @Resource
  MallRebateMapper rebateMapper;

  public UserRecomService() {
  }

  @Transactional(
          readOnly = true
  )
  public List<PromoteResp> findChildPromote(PromoteReq req) {
    List<String> children = this.findChildParty(req);
    if (CollectionUtil.isNotEmpty(children)) {
      List<PromoteResp> promotes = ((UserRecomMapper)this.getBaseMapper()).selectPromoteList(req.getPage(), children);
      if (CollectionUtil.isNotEmpty(promotes)) {
        promotes.forEach((e) -> {
          MallRebateDto rebate = this.rebateMapper.selectOrderRebate(e.getUuid(), req.getPartyId());
          if (null != rebate) {
            e.setOrderCount(rebate.getOrderCount());
            e.setIncome(rebate.getIncome());
          }

        });
      }

      return promotes;
    } else {
      return null;
    }
  }

  @Transactional(
          readOnly = true
  )
  public Map<Integer, String> findParents(String sellerId) {
    Map<Integer, String> map = new HashMap();

    for(int level = 1; null != sellerId && level <= 3; ++level) {
      sellerId = this.recursion(sellerId);
      if (null != sellerId) {
        map.put(level, sellerId);
      }
    }

    return map;
  }

  public List<String> findChildParty(PromoteReq req) {
    List<String> parents = new ArrayList();
    ((List)parents).add(req.getPartyId());

    for(int level = req.getLevel(); level >= 1; --level) {
      parents = this.recursion((List)parents);
    }

    return (List)parents;
  }

  private List<String> recursion(List<String> parent) {
    if (CollectionUtil.isNotEmpty(parent)) {
      QueryWrapper<UserRecom> wrapper = new QueryWrapper();
      wrapper.in("RECO_ID", parent);
      List<UserRecom> records = ((UserRecomMapper)this.getBaseMapper()).selectList(wrapper);
      if (CollectionUtil.isNotEmpty(records)) {
        return (List)records.stream().map(UserRecom::getPartyId).collect(Collectors.toList());
      }
    }

    return new ArrayList();
  }

  private String recursion(String child) {
    QueryWrapper<UserRecom> wrapper = new QueryWrapper();
    wrapper.eq("party_id", child);
    UserRecom userRecom = (UserRecom)((UserRecomMapper)this.getBaseMapper()).selectOne(wrapper);
    return null == userRecom ? null : userRecom.getRecoId();
  }
}
