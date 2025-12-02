 

package com.auto.mall.service;

import cn.hutool.core.collection.CollectionUtil;
import com.auto.mall.mapper.*;
import com.auto.mall.model.*;
import com.auto.mall.service.redis.RedisService;
import com.auto.mall.utils.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class MallOrderPrizeService extends ServiceImpl<MallOrderPrizeMapper, MallOrderPrize> {
    private static final Logger logger = LoggerFactory.getLogger(MallOrderPrizeService.class);
    @Resource
    UserRecomService userRecomService;
    @Resource
    SysParamService sysParamService;
    @Resource
    WalletService walletService;
    @Resource
    MoneyLogService moneyLogService;
    @Resource
    MallRebateMapper mallRebateMapper;
    @Resource
    UserDataMapper userDataMapper;
    @Resource
    RedisService redisService;
    @Resource
    PatPartyService patPartyService;

    public MallOrderPrizeService() {
    }

    @Transactional
    public List<String> distribution(String orderId) {
        List<String> result = new ArrayList();

        try {
            boolean tryLock = this.redisService.tryLock("order-lock_" + orderId);
            if (tryLock) {
                MallOrderPrize mallOrderPrize = (MallOrderPrize)((MallOrderPrizeMapper)this.getBaseMapper()).selectById(orderId);
                if (Objects.nonNull(mallOrderPrize)) {
                    Integer status = mallOrderPrize.getStatus();
                    Integer profitStatus = mallOrderPrize.getProfitStatus();
                    logger.info("订单[{}][status:{}][profit-status:{}]释放佣金!", new Object[]{orderId, status, profitStatus});
                    if ((status == 4 || status == 5) && (null == profitStatus || profitStatus == 0)) {
                        QueryWrapper<MoneyLog> wrapper = new QueryWrapper();
                        wrapper.like("LOG", orderId);
                        wrapper.eq("CONTENT_TYPE", "order-income");
                        List<MoneyLog> moneyLogs = ((MoneyLogMapper)this.moneyLogService.getBaseMapper()).selectList(wrapper);
                        if (CollectionUtil.isNotEmpty(moneyLogs)) {
                            this.updateOrder(mallOrderPrize);
                            ArrayList var26 = (ArrayList) result;
                            return var26;
                        }

                        String sellerId = mallOrderPrize.getSellerId();
                        Map<Integer, String> parents = this.userRecomService.findParents(sellerId);
                        BigDecimal profit = mallOrderPrize.getProfit();
                        BigDecimal remain = profit;
                        if (CollectionUtil.isNotEmpty(parents)) {
                            Iterator var13 = parents.entrySet().iterator();

                            while(var13.hasNext()) {
                                Map.Entry<Integer, String> entry = (Map.Entry)var13.next();
                                Integer level = (Integer)entry.getKey();
                                String userId = (String)entry.getValue();
                                PatParty party = (PatParty)this.patPartyService.getById(userId);
                                if (!Objects.isNull(party) && !party.getRoleName().equals("AGENT")) {
                                    BigDecimal rebate_ratio = this.sysParamService.getLevelRatio(level);
                                    if (null != rebate_ratio) {
                                        BigDecimal rebateAmount = profit.multiply(rebate_ratio).setScale(2, 4);
                                        if (rebateAmount.compareTo(new BigDecimal("0.00")) > 0) {
                                            remain = remain.subtract(rebateAmount);
                                            this.updateWallet(orderId, userId, "brokerage", (BigDecimal)null, rebateAmount);
                                            this.saveMallRebate(orderId, userId, sellerId, level, rebateAmount);
                                            this.saveUserData(userId, level, rebateAmount);
                                            result.add(userId);
                                        }
                                    }
                                }
                            }
                        }

                        result.add(sellerId);
                        this.updateWallet(orderId, sellerId, "order-income", mallOrderPrize.getSystemPrice(), remain);
                        this.updateOrder(mallOrderPrize);
                    }
                }
            }
        } catch (Exception var23) {
            Exception ex = var23;
            logger.info(ex.getMessage());
        } finally {
            this.redisService.unLock("order-lock_" + orderId);
        }

        return result;
    }

    private void saveUserData(String partyId, Integer level, BigDecimal rebateAmount) {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime startTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime endTime = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        QueryWrapper<UserData> wrapper = new QueryWrapper();
        wrapper.eq("party_id", partyId);
        wrapper.between("create_time", Date.from(startTime.atZone(zoneId).toInstant()), Date.from(endTime.atZone(zoneId).toInstant()));
        List<UserData> userDatas = this.userDataMapper.selectList(wrapper);
        UserData userData = new UserData();
        if (CollectionUtil.isNotEmpty(userDatas)) {
            userData = (UserData)userDatas.get(0);
        }

        switch (level) {
            case 1:
                userData.setRebate1(rebateAmount.add(userData.getRebate1()));
                break;
            case 2:
                userData.setRebate2(rebateAmount.add(userData.getRebate2()));
                break;
            case 3:
                userData.setRebate3(rebateAmount.add(userData.getRebate3()));
        }

        if (StringUtils.isEmpty(userData.getId())) {
            userData.setPartyId(partyId);
            userData.setCreateTime(new Date());
            this.userDataMapper.insert(userData);
        } else {
            this.userDataMapper.updateById(userData);
        }

    }

    private void saveMallRebate(String orderId, String partyId, String orderSellerId, Integer level, BigDecimal rebateAmount) {
        MallRebate rebate = new MallRebate();
        rebate.setOrderId(orderId);
        rebate.setPartyId(partyId);
        rebate.setOrderPartyId(orderSellerId);
        rebate.setLevel(level);
        rebate.setRebate(rebateAmount);
        rebate.setCreateTime(new Date());
        this.mallRebateMapper.insert(rebate);
    }

    private void updateWallet(String orderId, String partyId, String type, BigDecimal principal, BigDecimal amount) {
        QueryWrapper<Wallet> wrapper = new QueryWrapper();
        wrapper.eq("party_id", partyId);
        Wallet wallet = (Wallet)((WalletMapper)this.walletService.getBaseMapper()).selectOne(wrapper);
        BigDecimal totalAmount = amount;
        if (null == wallet) {
            wallet = new Wallet();
            wallet.setPartyId(partyId);
        }

        if (null != principal) {
            totalAmount = amount.add(principal);
        }

        BigDecimal currentAmount = wallet.getMoney();
        BigDecimal afterAmount = currentAmount.add(totalAmount);
        wallet.setMoney(afterAmount);
        wallet.setRebate(wallet.getRebate().add(amount));
        ((WalletMapper)this.walletService.getBaseMapper()).updateById(wallet);
        this.redisService.set("WALLET_PARTY_ID_" + wallet.getPartyId(), wallet);
        MoneyLog log = new MoneyLog();
        log.setLog("订单：" + orderId);
        log.setAmount(totalAmount);
        log.setAmountBefore(currentAmount);
        log.setAmountAfter(afterAmount);
        log.setPartyId(partyId);
        log.setCreateTime(new Date());
        log.setWalletType("USDT");
        log.setCategory("coin");
        log.setContentType(type);
        ((MoneyLogMapper)this.moneyLogService.getBaseMapper()).insert(log);
    }

    private void updateOrder(MallOrderPrize orderPrize) {
        orderPrize.setProfitStatus(1);
        ((MallOrderPrizeMapper)this.getBaseMapper()).updateById(orderPrize);
    }
}
