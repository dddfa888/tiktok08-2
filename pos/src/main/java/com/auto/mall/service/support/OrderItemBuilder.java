 

package com.auto.mall.service.support;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.auto.mall.dto.LocalOrderResult;
import com.auto.mall.model.OrderRecordDetail;
import com.auto.mall.service.OrderRecordDetailService;
import com.auto.mall.service.OrderRecordService;
import com.auto.mall.utils.StringUtils;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderItemBuilder implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(OrderItemBuilder.class);
    private String api;
    private String orderId;
    private long delay;
    private String partyId;
    private String uuid;
    private String sellerId;
    private int count;
    private BigDecimal amount;
    private OrderRecordService orderRecordService;
    private OrderRecordDetailService recordDetailService;

    public OrderItemBuilder() {
    }

    public OrderItemBuilder(long time, String partyId, String uuid, String sellerId, int count, BigDecimal amount) {
        this.delay = time;
        this.partyId = partyId;
        this.uuid = uuid;
        this.sellerId = sellerId;
        this.count = count;
        this.amount = amount;
    }

    public void run() {
        if (this.delay > 0L) {
            String value = HttpUtil.post(this.api + "?partyId=" + this.partyId + "&uuid=" + this.uuid + "&num=" + this.count, "");
            logger.info("execute batch order:[orderId=>{}, partyId=>{},uuid=>{}, count=>{}, amount=>{}], response:[{}]", new Object[]{this.orderId, this.partyId, this.uuid, this.count, this.amount, value});

            try {
                JSONObject object = JSONUtil.parseObj(value);
                JSONObject data = JSONUtil.parseObj(object.get("data"));
                List<LocalOrderResult> orderList = data.getBeanList("orderList", LocalOrderResult.class);
                Set<String> orderSuccess = (Set)orderList.stream().filter((o) -> {
                    return o != null && StringUtils.isNotEmpty(o.getOrderId());
                }).map(LocalOrderResult::getOrderId).collect(Collectors.toSet());
                String[] split = this.uuid.split(",");
                this.orderRecordService.updateItem(this.orderId, this.uuid, this.count, this.amount, orderSuccess);
                if (CollectionUtil.isNotEmpty(orderSuccess)) {
                    Iterator var7 = orderSuccess.iterator();

                    while(var7.hasNext()) {
                        String success = (String)var7.next();
                        OrderRecordDetail detail = new OrderRecordDetail(this.orderId, success, this.partyId, this.amount, this.sellerId, split[0], split[1], this.count);
                        this.recordDetailService.save(detail);
                    }
                }
            } catch (Exception var10) {
                Exception e = var10;
                e.printStackTrace();
            }
        }

    }

    public String getApi() {
        return this.api;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public long getDelay() {
        return this.delay;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getSellerId() {
        return this.sellerId;
    }

    public int getCount() {
        return this.count;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public OrderRecordService getOrderRecordService() {
        return this.orderRecordService;
    }

    public OrderRecordDetailService getRecordDetailService() {
        return this.recordDetailService;
    }

    public void setApi(final String api) {
        this.api = api;
    }

    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    public void setDelay(final long delay) {
        this.delay = delay;
    }

    public void setPartyId(final String partyId) {
        this.partyId = partyId;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }

    public void setSellerId(final String sellerId) {
        this.sellerId = sellerId;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    public void setOrderRecordService(final OrderRecordService orderRecordService) {
        this.orderRecordService = orderRecordService;
    }

    public void setRecordDetailService(final OrderRecordDetailService recordDetailService) {
        this.recordDetailService = recordDetailService;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OrderItemBuilder)) {
            return false;
        } else {
            OrderItemBuilder other = (OrderItemBuilder)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getDelay() != other.getDelay()) {
                return false;
            } else if (this.getCount() != other.getCount()) {
                return false;
            } else {
                label112: {
                    Object this$api = this.getApi();
                    Object other$api = other.getApi();
                    if (this$api == null) {
                        if (other$api == null) {
                            break label112;
                        }
                    } else if (this$api.equals(other$api)) {
                        break label112;
                    }

                    return false;
                }

                label105: {
                    Object this$orderId = this.getOrderId();
                    Object other$orderId = other.getOrderId();
                    if (this$orderId == null) {
                        if (other$orderId == null) {
                            break label105;
                        }
                    } else if (this$orderId.equals(other$orderId)) {
                        break label105;
                    }

                    return false;
                }

                Object this$partyId = this.getPartyId();
                Object other$partyId = other.getPartyId();
                if (this$partyId == null) {
                    if (other$partyId != null) {
                        return false;
                    }
                } else if (!this$partyId.equals(other$partyId)) {
                    return false;
                }

                label91: {
                    Object this$uuid = this.getUuid();
                    Object other$uuid = other.getUuid();
                    if (this$uuid == null) {
                        if (other$uuid == null) {
                            break label91;
                        }
                    } else if (this$uuid.equals(other$uuid)) {
                        break label91;
                    }

                    return false;
                }

                Object this$sellerId = this.getSellerId();
                Object other$sellerId = other.getSellerId();
                if (this$sellerId == null) {
                    if (other$sellerId != null) {
                        return false;
                    }
                } else if (!this$sellerId.equals(other$sellerId)) {
                    return false;
                }

                label77: {
                    Object this$amount = this.getAmount();
                    Object other$amount = other.getAmount();
                    if (this$amount == null) {
                        if (other$amount == null) {
                            break label77;
                        }
                    } else if (this$amount.equals(other$amount)) {
                        break label77;
                    }

                    return false;
                }

                label70: {
                    Object this$orderRecordService = this.getOrderRecordService();
                    Object other$orderRecordService = other.getOrderRecordService();
                    if (this$orderRecordService == null) {
                        if (other$orderRecordService == null) {
                            break label70;
                        }
                    } else if (this$orderRecordService.equals(other$orderRecordService)) {
                        break label70;
                    }

                    return false;
                }

                Object this$recordDetailService = this.getRecordDetailService();
                Object other$recordDetailService = other.getRecordDetailService();
                if (this$recordDetailService == null) {
                    if (other$recordDetailService != null) {
                        return false;
                    }
                } else if (!this$recordDetailService.equals(other$recordDetailService)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OrderItemBuilder;
    }

    public int hashCode() {
          
        int result = 1;
        long $delay = this.getDelay();
        result = result * 59 + (int)($delay >>> 32 ^ $delay);
        result = result * 59 + this.getCount();
        Object $api = this.getApi();
        result = result * 59 + ($api == null ? 43 : $api.hashCode());
        Object $orderId = this.getOrderId();
        result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
        Object $partyId = this.getPartyId();
        result = result * 59 + ($partyId == null ? 43 : $partyId.hashCode());
        Object $uuid = this.getUuid();
        result = result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
        Object $sellerId = this.getSellerId();
        result = result * 59 + ($sellerId == null ? 43 : $sellerId.hashCode());
        Object $amount = this.getAmount();
        result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
        Object $orderRecordService = this.getOrderRecordService();
        result = result * 59 + ($orderRecordService == null ? 43 : $orderRecordService.hashCode());
        Object $recordDetailService = this.getRecordDetailService();
        result = result * 59 + ($recordDetailService == null ? 43 : $recordDetailService.hashCode());
        return result;
    }

    public String toString() {
        return "OrderItemBuilder(api=" + this.getApi() + ", orderId=" + this.getOrderId() + ", delay=" + this.getDelay() + ", partyId=" + this.getPartyId() + ", uuid=" + this.getUuid() + ", sellerId=" + this.getSellerId() + ", count=" + this.getCount() + ", amount=" + this.getAmount() + ", orderRecordService=" + this.getOrderRecordService() + ", recordDetailService=" + this.getRecordDetailService() + ")";
    }
}
