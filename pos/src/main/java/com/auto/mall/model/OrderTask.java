 

package com.auto.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName("T_MALL_ORDER_TASK")
public class OrderTask implements Serializable {
    @TableId(
            value = "id",
            type = IdType.UUID
    )
    private String id;
    @TableField("order_id")
    private String orderId;
    @TableField("delay")
    private Date delay;
    @TableField("party_id")
    private String partyId;
    @TableField("good_info")
    private String goodInfo;
    @TableField("seller_id")
    private String sellerId;
    @TableField("count")
    private int count;
    @TableField("amount")
    private BigDecimal amount;
    @TableField("status")
    private int status;

    public OrderTask() {
    }

    public String getId() {
        return this.id;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public Date getDelay() {
        return this.delay;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public String getGoodInfo() {
        return this.goodInfo;
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

    public int getStatus() {
        return this.status;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    public void setDelay(final Date delay) {
        this.delay = delay;
    }

    public void setPartyId(final String partyId) {
        this.partyId = partyId;
    }

    public void setGoodInfo(final String goodInfo) {
        this.goodInfo = goodInfo;
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

    public void setStatus(final int status) {
        this.status = status;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OrderTask)) {
            return false;
        } else {
            OrderTask other = (OrderTask)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCount() != other.getCount()) {
                return false;
            } else if (this.getStatus() != other.getStatus()) {
                return false;
            } else {
                label100: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label100;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label100;
                    }

                    return false;
                }

                Object this$orderId = this.getOrderId();
                Object other$orderId = other.getOrderId();
                if (this$orderId == null) {
                    if (other$orderId != null) {
                        return false;
                    }
                } else if (!this$orderId.equals(other$orderId)) {
                    return false;
                }

                label86: {
                    Object this$delay = this.getDelay();
                    Object other$delay = other.getDelay();
                    if (this$delay == null) {
                        if (other$delay == null) {
                            break label86;
                        }
                    } else if (this$delay.equals(other$delay)) {
                        break label86;
                    }

                    return false;
                }

                label79: {
                    Object this$partyId = this.getPartyId();
                    Object other$partyId = other.getPartyId();
                    if (this$partyId == null) {
                        if (other$partyId == null) {
                            break label79;
                        }
                    } else if (this$partyId.equals(other$partyId)) {
                        break label79;
                    }

                    return false;
                }

                label72: {
                    Object this$goodInfo = this.getGoodInfo();
                    Object other$goodInfo = other.getGoodInfo();
                    if (this$goodInfo == null) {
                        if (other$goodInfo == null) {
                            break label72;
                        }
                    } else if (this$goodInfo.equals(other$goodInfo)) {
                        break label72;
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

                Object this$amount = this.getAmount();
                Object other$amount = other.getAmount();
                if (this$amount == null) {
                    if (other$amount != null) {
                        return false;
                    }
                } else if (!this$amount.equals(other$amount)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OrderTask;
    }

    public int hashCode() {
          
        int result = 1;
        result = result * 59 + this.getCount();
        result = result * 59 + this.getStatus();
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $orderId = this.getOrderId();
        result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
        Object $delay = this.getDelay();
        result = result * 59 + ($delay == null ? 43 : $delay.hashCode());
        Object $partyId = this.getPartyId();
        result = result * 59 + ($partyId == null ? 43 : $partyId.hashCode());
        Object $goodInfo = this.getGoodInfo();
        result = result * 59 + ($goodInfo == null ? 43 : $goodInfo.hashCode());
        Object $sellerId = this.getSellerId();
        result = result * 59 + ($sellerId == null ? 43 : $sellerId.hashCode());
        Object $amount = this.getAmount();
        result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
        return result;
    }

    public String toString() {
        return "OrderTask(id=" + this.getId() + ", orderId=" + this.getOrderId() + ", delay=" + this.getDelay() + ", partyId=" + this.getPartyId() + ", goodInfo=" + this.getGoodInfo() + ", sellerId=" + this.getSellerId() + ", count=" + this.getCount() + ", amount=" + this.getAmount() + ", status=" + this.getStatus() + ")";
    }
}
