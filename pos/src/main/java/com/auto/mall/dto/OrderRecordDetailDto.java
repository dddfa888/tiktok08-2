 

package com.auto.mall.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderRecordDetailDto implements Serializable {
    private static final long serialVersionUID = -6207467070540174816L;
    private String id;
    private String recordId;
    private String orderId;
    private String userId;
    private String shopName;
    private String username;
    private BigDecimal orderAmount;
    private BigDecimal amount;
    private String goodsName;
    private Date createTime;
    private Integer num;

    public OrderRecordDetailDto() {
    }

    public String getId() {
        return this.id;
    }

    public String getRecordId() {
        return this.recordId;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getShopName() {
        return this.shopName;
    }

    public String getUsername() {
        return this.username;
    }

    public BigDecimal getOrderAmount() {
        return this.orderAmount;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public String getGoodsName() {
        return this.goodsName;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setRecordId(final String recordId) {
        this.recordId = recordId;
    }

    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setShopName(final String shopName) {
        this.shopName = shopName;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setOrderAmount(final BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    public void setGoodsName(final String goodsName) {
        this.goodsName = goodsName;
    }

    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
    }

    public void setNum(final Integer num) {
        this.num = num;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OrderRecordDetailDto)) {
            return false;
        } else {
            OrderRecordDetailDto other = (OrderRecordDetailDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label143: {
                    Object this$num = this.getNum();
                    Object other$num = other.getNum();
                    if (this$num == null) {
                        if (other$num == null) {
                            break label143;
                        }
                    } else if (this$num.equals(other$num)) {
                        break label143;
                    }

                    return false;
                }

                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$recordId = this.getRecordId();
                Object other$recordId = other.getRecordId();
                if (this$recordId == null) {
                    if (other$recordId != null) {
                        return false;
                    }
                } else if (!this$recordId.equals(other$recordId)) {
                    return false;
                }

                label122: {
                    Object this$orderId = this.getOrderId();
                    Object other$orderId = other.getOrderId();
                    if (this$orderId == null) {
                        if (other$orderId == null) {
                            break label122;
                        }
                    } else if (this$orderId.equals(other$orderId)) {
                        break label122;
                    }

                    return false;
                }

                label115: {
                    Object this$userId = this.getUserId();
                    Object other$userId = other.getUserId();
                    if (this$userId == null) {
                        if (other$userId == null) {
                            break label115;
                        }
                    } else if (this$userId.equals(other$userId)) {
                        break label115;
                    }

                    return false;
                }

                Object this$shopName = this.getShopName();
                Object other$shopName = other.getShopName();
                if (this$shopName == null) {
                    if (other$shopName != null) {
                        return false;
                    }
                } else if (!this$shopName.equals(other$shopName)) {
                    return false;
                }

                Object this$username = this.getUsername();
                Object other$username = other.getUsername();
                if (this$username == null) {
                    if (other$username != null) {
                        return false;
                    }
                } else if (!this$username.equals(other$username)) {
                    return false;
                }

                label94: {
                    Object this$orderAmount = this.getOrderAmount();
                    Object other$orderAmount = other.getOrderAmount();
                    if (this$orderAmount == null) {
                        if (other$orderAmount == null) {
                            break label94;
                        }
                    } else if (this$orderAmount.equals(other$orderAmount)) {
                        break label94;
                    }

                    return false;
                }

                label87: {
                    Object this$amount = this.getAmount();
                    Object other$amount = other.getAmount();
                    if (this$amount == null) {
                        if (other$amount == null) {
                            break label87;
                        }
                    } else if (this$amount.equals(other$amount)) {
                        break label87;
                    }

                    return false;
                }

                Object this$goodsName = this.getGoodsName();
                Object other$goodsName = other.getGoodsName();
                if (this$goodsName == null) {
                    if (other$goodsName != null) {
                        return false;
                    }
                } else if (!this$goodsName.equals(other$goodsName)) {
                    return false;
                }

                Object this$createTime = this.getCreateTime();
                Object other$createTime = other.getCreateTime();
                if (this$createTime == null) {
                    if (other$createTime != null) {
                        return false;
                    }
                } else if (!this$createTime.equals(other$createTime)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OrderRecordDetailDto;
    }

    public int hashCode() {
          
        int result = 1;
        Object $num = this.getNum();
        result = result * 59 + ($num == null ? 43 : $num.hashCode());
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $recordId = this.getRecordId();
        result = result * 59 + ($recordId == null ? 43 : $recordId.hashCode());
        Object $orderId = this.getOrderId();
        result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $shopName = this.getShopName();
        result = result * 59 + ($shopName == null ? 43 : $shopName.hashCode());
        Object $username = this.getUsername();
        result = result * 59 + ($username == null ? 43 : $username.hashCode());
        Object $orderAmount = this.getOrderAmount();
        result = result * 59 + ($orderAmount == null ? 43 : $orderAmount.hashCode());
        Object $amount = this.getAmount();
        result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
        Object $goodsName = this.getGoodsName();
        result = result * 59 + ($goodsName == null ? 43 : $goodsName.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        return result;
    }

    public String toString() {
        return "OrderRecordDetailDto(id=" + this.getId() + ", recordId=" + this.getRecordId() + ", orderId=" + this.getOrderId() + ", userId=" + this.getUserId() + ", shopName=" + this.getShopName() + ", username=" + this.getUsername() + ", orderAmount=" + this.getOrderAmount() + ", amount=" + this.getAmount() + ", goodsName=" + this.getGoodsName() + ", createTime=" + this.getCreateTime() + ", num=" + this.getNum() + ")";
    }
}
