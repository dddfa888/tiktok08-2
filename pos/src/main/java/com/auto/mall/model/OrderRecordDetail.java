 

package com.auto.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName("T_MALL_ORDER_RECORD_DETAIL")
public class OrderRecordDetail implements Serializable {
    @TableId(
            value = "UUID",
            type = IdType.UUID
    )
    private String id;
    @TableField("RECORD_ID")
    private String recordId;
    @TableField("SELLER_ID")
    private String sellerId;
    @TableField("ORDER_ID")
    private String orderId;
    @TableField("USER_ID")
    private String userId;
    @TableField("ORDER_AMOUNT")
    private BigDecimal orderAmount;
    @TableField("SELLER_GOODS_ID")
    private String sellerGoodsId;
    @TableField("SKU_ID")
    private String skuId;
    @TableField("CREATE_TIME")
    private Date createTime;
    @TableField("NUM")
    private Integer num;

    public OrderRecordDetail() {
    }

    public OrderRecordDetail(String recordId, String orderId, String userId, BigDecimal orderAmount, String sellerId, String sellerGoodsId, String skuId, Integer num) {
        this.recordId = recordId;
        this.orderId = orderId;
        this.userId = userId;
        this.sellerId = sellerId;
        this.orderAmount = orderAmount;
        this.sellerGoodsId = sellerGoodsId;
        this.skuId = skuId;
        this.num = num;
        this.createTime = new Date();
    }

    public String getId() {
        return this.id;
    }

    public String getRecordId() {
        return this.recordId;
    }

    public String getSellerId() {
        return this.sellerId;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getUserId() {
        return this.userId;
    }

    public BigDecimal getOrderAmount() {
        return this.orderAmount;
    }

    public String getSellerGoodsId() {
        return this.sellerGoodsId;
    }

    public String getSkuId() {
        return this.skuId;
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

    public void setSellerId(final String sellerId) {
        this.sellerId = sellerId;
    }

    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setOrderAmount(final BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public void setSellerGoodsId(final String sellerGoodsId) {
        this.sellerGoodsId = sellerGoodsId;
    }

    public void setSkuId(final String skuId) {
        this.skuId = skuId;
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
        } else if (!(o instanceof OrderRecordDetail)) {
            return false;
        } else {
            OrderRecordDetail other = (OrderRecordDetail)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$num = this.getNum();
                Object other$num = other.getNum();
                if (this$num == null) {
                    if (other$num != null) {
                        return false;
                    }
                } else if (!this$num.equals(other$num)) {
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

                label110: {
                    Object this$sellerId = this.getSellerId();
                    Object other$sellerId = other.getSellerId();
                    if (this$sellerId == null) {
                        if (other$sellerId == null) {
                            break label110;
                        }
                    } else if (this$sellerId.equals(other$sellerId)) {
                        break label110;
                    }

                    return false;
                }

                label103: {
                    Object this$orderId = this.getOrderId();
                    Object other$orderId = other.getOrderId();
                    if (this$orderId == null) {
                        if (other$orderId == null) {
                            break label103;
                        }
                    } else if (this$orderId.equals(other$orderId)) {
                        break label103;
                    }

                    return false;
                }

                Object this$userId = this.getUserId();
                Object other$userId = other.getUserId();
                if (this$userId == null) {
                    if (other$userId != null) {
                        return false;
                    }
                } else if (!this$userId.equals(other$userId)) {
                    return false;
                }

                label89: {
                    Object this$orderAmount = this.getOrderAmount();
                    Object other$orderAmount = other.getOrderAmount();
                    if (this$orderAmount == null) {
                        if (other$orderAmount == null) {
                            break label89;
                        }
                    } else if (this$orderAmount.equals(other$orderAmount)) {
                        break label89;
                    }

                    return false;
                }

                label82: {
                    Object this$sellerGoodsId = this.getSellerGoodsId();
                    Object other$sellerGoodsId = other.getSellerGoodsId();
                    if (this$sellerGoodsId == null) {
                        if (other$sellerGoodsId == null) {
                            break label82;
                        }
                    } else if (this$sellerGoodsId.equals(other$sellerGoodsId)) {
                        break label82;
                    }

                    return false;
                }

                Object this$skuId = this.getSkuId();
                Object other$skuId = other.getSkuId();
                if (this$skuId == null) {
                    if (other$skuId != null) {
                        return false;
                    }
                } else if (!this$skuId.equals(other$skuId)) {
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
        return other instanceof OrderRecordDetail;
    }

    public int hashCode() {
          
        int result = 1;
        Object $num = this.getNum();
        result = result * 59 + ($num == null ? 43 : $num.hashCode());
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $recordId = this.getRecordId();
        result = result * 59 + ($recordId == null ? 43 : $recordId.hashCode());
        Object $sellerId = this.getSellerId();
        result = result * 59 + ($sellerId == null ? 43 : $sellerId.hashCode());
        Object $orderId = this.getOrderId();
        result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $orderAmount = this.getOrderAmount();
        result = result * 59 + ($orderAmount == null ? 43 : $orderAmount.hashCode());
        Object $sellerGoodsId = this.getSellerGoodsId();
        result = result * 59 + ($sellerGoodsId == null ? 43 : $sellerGoodsId.hashCode());
        Object $skuId = this.getSkuId();
        result = result * 59 + ($skuId == null ? 43 : $skuId.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        return result;
    }

    public String toString() {
        return "OrderRecordDetail(id=" + this.getId() + ", recordId=" + this.getRecordId() + ", sellerId=" + this.getSellerId() + ", orderId=" + this.getOrderId() + ", userId=" + this.getUserId() + ", orderAmount=" + this.getOrderAmount() + ", sellerGoodsId=" + this.getSellerGoodsId() + ", skuId=" + this.getSkuId() + ", createTime=" + this.getCreateTime() + ", num=" + this.getNum() + ")";
    }
}
