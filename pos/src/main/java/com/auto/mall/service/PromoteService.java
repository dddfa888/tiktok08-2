 

package com.auto.mall.service;

import cn.hutool.core.util.StrUtil;
import com.auto.mall.api.req.PromoteReq;
import com.auto.mall.api.resp.PromoteResp;
import com.auto.mall.exception.MallToolGlobalException;
import com.auto.mall.service.redis.RedisService;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PromoteService {
    private static final Logger logger = LoggerFactory.getLogger(PromoteService.class);
    @Resource
    RedisService redisService;
    @Resource
    UserRecomService userRecomService;
    @Resource
    MallOrderPrizeService mallOrderPrizeService;

    public PromoteService() {
    }

    @Transactional(
            readOnly = true
    )
    public List<PromoteResp> list(PromoteReq req) {
        String token = req.getToken();
        if (StrUtil.isBlank(token)) {
            throw new MallToolGlobalException(403, "登录已过期");
        } else {
            String partyId = token.length() > 36 ? (String)this.redisService.get("PLAT_FROM_TOKEN_" + token, String.class) : (String)this.redisService.get("TOKEN_" + token, String.class);
            if (StrUtil.isBlank(partyId)) {
                throw new MallToolGlobalException(403, "登录已过期");
            } else {
                req.setPartyId(partyId);
                return this.userRecomService.findChildPromote(req);
            }
        }
    }

    public List<String> distribution(String orderId) {
        return this.mallOrderPrizeService.distribution(orderId);
    }
}
