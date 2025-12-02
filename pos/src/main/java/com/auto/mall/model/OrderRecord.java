 

package com.auto.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName("T_MALL_ORDER_RECORD")
public class OrderRecord implements Serializable {
    private static final long serialVersionUID = -5838213798609801171L;
    @TableId(
            value = "uuid",
            type = IdType.UUID
    )
    private String id;
    @JsonProperty("startTime")
    @TableField("start_time")
    private Date start_time;
    @JsonProperty("endTime")
    @TableField("end_time")
    private Date end_time;
    @JsonProperty("orderSpacingStart")
    @TableField("order_spacing_start")
    private Integer order_spacing_start;
    @JsonProperty("orderSpacingEnd")
    @TableField("order_spacing_end")
    private Integer order_spacing_end;
    @JsonProperty("buyNumStart")
    @TableField("buy_num_start")
    private Integer buy_num_start;
    @TableField("buy_num_end")
    @JsonProperty("buyNumEnd")
    private Integer buy_num_end;
    @TableField("buy_amount_start")
    @JsonProperty("buyAmountStart")
    private BigDecimal buy_amount_start;
    @TableField("buy_amount_end")
    @JsonProperty("buyAmountEnd")
    private BigDecimal buy_amount_end;
    @TableField("lump_amount")
    @JsonProperty("lumpAmount")
    private BigDecimal lump_amount;
    @TableField("ordered_num")
    @JsonProperty("orderedNum")
    private Integer order_num;
    @TableField("CREATE_TIME")
    private Date createTime;
    @TableField("order_num_all")
    @JsonProperty("orderNumAll")
    private Integer orderNumAll;
    @JsonProperty("orderAmount")
    @TableField("order_amount")
    private BigDecimal order_amount;
    @TableField("seller_goods_id")
    @JsonIgnore
    private String seller_goods_id;
    @TableField("status")
    private Integer status;
    @TableField("ORDER_IDS")
    private String orderIds;
    @TableField("type")
    private String type;
    @TableField("CREATE_USER")
    private String createUser;
    @TableField(exist = false)
    private String sellerId;

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getOrder_num() {
        return null == this.order_num ? 0 : this.order_num;
    }

    public BigDecimal getOrder_amount() {
        return null == this.order_amount ? new BigDecimal(0.0) : this.order_amount;
    }

    public OrderRecord() {
    }

    public String getId() {
        return this.id;
    }

    public Date getStart_time() {
        return this.start_time;
    }

    public Date getEnd_time() {
        return this.end_time;
    }

    public Integer getOrder_spacing_start() {
        return this.order_spacing_start;
    }

    public Integer getOrder_spacing_end() {
        return this.order_spacing_end;
    }

    public Integer getBuy_num_start() {
        return this.buy_num_start;
    }

    public Integer getBuy_num_end() {
        return this.buy_num_end;
    }

    public BigDecimal getBuy_amount_start() {
        return this.buy_amount_start;
    }

    public BigDecimal getBuy_amount_end() {
        return this.buy_amount_end;
    }

    public BigDecimal getLump_amount() {
        return this.lump_amount;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Integer getOrderNumAll() {
        return this.orderNumAll;
    }

    public String getSeller_goods_id() {
        return this.seller_goods_id;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getOrderIds() {
        return this.orderIds;
    }

    public String getType() {
        return this.type;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setId(final String id) {
        this.id = id;
    }

    @JsonProperty("startTime")
    public void setStart_time(final Date start_time) {
        this.start_time = start_time;
    }

    @JsonProperty("endTime")
    public void setEnd_time(final Date end_time) {
        this.end_time = end_time;
    }

    @JsonProperty("orderSpacingStart")
    public void setOrder_spacing_start(final Integer order_spacing_start) {
        this.order_spacing_start = order_spacing_start;
    }

    @JsonProperty("orderSpacingEnd")
    public void setOrder_spacing_end(final Integer order_spacing_end) {
        this.order_spacing_end = order_spacing_end;
    }

    @JsonProperty("buyNumStart")
    public void setBuy_num_start(final Integer buy_num_start) {
        this.buy_num_start = buy_num_start;
    }

    @JsonProperty("buyNumEnd")
    public void setBuy_num_end(final Integer buy_num_end) {
        this.buy_num_end = buy_num_end;
    }

    @JsonProperty("buyAmountStart")
    public void setBuy_amount_start(final BigDecimal buy_amount_start) {
        this.buy_amount_start = buy_amount_start;
    }

    @JsonProperty("buyAmountEnd")
    public void setBuy_amount_end(final BigDecimal buy_amount_end) {
        this.buy_amount_end = buy_amount_end;
    }

    @JsonProperty("lumpAmount")
    public void setLump_amount(final BigDecimal lump_amount) {
        this.lump_amount = lump_amount;
    }

    @JsonProperty("orderedNum")
    public void setOrder_num(final Integer order_num) {
        this.order_num = order_num;
    }

    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
    }

    @JsonProperty("orderNumAll")
    public void setOrderNumAll(final Integer orderNumAll) {
        this.orderNumAll = orderNumAll;
    }

    @JsonProperty("orderAmount")
    public void setOrder_amount(final BigDecimal order_amount) {
        this.order_amount = order_amount;
    }

    @JsonIgnore
    public void setSeller_goods_id(final String seller_goods_id) {
        this.seller_goods_id = seller_goods_id;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }

    public void setOrderIds(final String orderIds) {
        this.orderIds = orderIds;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public void setCreateUser(final String createUser) {
        this.createUser = createUser;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OrderRecord)) {
            return false;
        } else {
            OrderRecord other = (OrderRecord)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label239: {
                    Object this$order_spacing_start = this.getOrder_spacing_start();
                    Object other$order_spacing_start = other.getOrder_spacing_start();
                    if (this$order_spacing_start == null) {
                        if (other$order_spacing_start == null) {
                            break label239;
                        }
                    } else if (this$order_spacing_start.equals(other$order_spacing_start)) {
                        break label239;
                    }

                    return false;
                }

                Object this$order_spacing_end = this.getOrder_spacing_end();
                Object other$order_spacing_end = other.getOrder_spacing_end();
                if (this$order_spacing_end == null) {
                    if (other$order_spacing_end != null) {
                        return false;
                    }
                } else if (!this$order_spacing_end.equals(other$order_spacing_end)) {
                    return false;
                }

                Object this$buy_num_start = this.getBuy_num_start();
                Object other$buy_num_start = other.getBuy_num_start();
                if (this$buy_num_start == null) {
                    if (other$buy_num_start != null) {
                        return false;
                    }
                } else if (!this$buy_num_start.equals(other$buy_num_start)) {
                    return false;
                }

                label218: {
                    Object this$buy_num_end = this.getBuy_num_end();
                    Object other$buy_num_end = other.getBuy_num_end();
                    if (this$buy_num_end == null) {
                        if (other$buy_num_end == null) {
                            break label218;
                        }
                    } else if (this$buy_num_end.equals(other$buy_num_end)) {
                        break label218;
                    }

                    return false;
                }

                label211: {
                    Object this$order_num = this.getOrder_num();
                    Object other$order_num = other.getOrder_num();
                    if (this$order_num == null) {
                        if (other$order_num == null) {
                            break label211;
                        }
                    } else if (this$order_num.equals(other$order_num)) {
                        break label211;
                    }

                    return false;
                }

                Object this$orderNumAll = this.getOrderNumAll();
                Object other$orderNumAll = other.getOrderNumAll();
                if (this$orderNumAll == null) {
                    if (other$orderNumAll != null) {
                        return false;
                    }
                } else if (!this$orderNumAll.equals(other$orderNumAll)) {
                    return false;
                }

                Object this$status = this.getStatus();
                Object other$status = other.getStatus();
                if (this$status == null) {
                    if (other$status != null) {
                        return false;
                    }
                } else if (!this$status.equals(other$status)) {
                    return false;
                }

                label190: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label190;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label190;
                    }

                    return false;
                }

                label183: {
                    Object this$start_time = this.getStart_time();
                    Object other$start_time = other.getStart_time();
                    if (this$start_time == null) {
                        if (other$start_time == null) {
                            break label183;
                        }
                    } else if (this$start_time.equals(other$start_time)) {
                        break label183;
                    }

                    return false;
                }

                Object this$end_time = this.getEnd_time();
                Object other$end_time = other.getEnd_time();
                if (this$end_time == null) {
                    if (other$end_time != null) {
                        return false;
                    }
                } else if (!this$end_time.equals(other$end_time)) {
                    return false;
                }

                label169: {
                    Object this$buy_amount_start = this.getBuy_amount_start();
                    Object other$buy_amount_start = other.getBuy_amount_start();
                    if (this$buy_amount_start == null) {
                        if (other$buy_amount_start == null) {
                            break label169;
                        }
                    } else if (this$buy_amount_start.equals(other$buy_amount_start)) {
                        break label169;
                    }

                    return false;
                }

                Object this$buy_amount_end = this.getBuy_amount_end();
                Object other$buy_amount_end = other.getBuy_amount_end();
                if (this$buy_amount_end == null) {
                    if (other$buy_amount_end != null) {
                        return false;
                    }
                } else if (!this$buy_amount_end.equals(other$buy_amount_end)) {
                    return false;
                }

                label155: {
                    Object this$lump_amount = this.getLump_amount();
                    Object other$lump_amount = other.getLump_amount();
                    if (this$lump_amount == null) {
                        if (other$lump_amount == null) {
                            break label155;
                        }
                    } else if (this$lump_amount.equals(other$lump_amount)) {
                        break label155;
                    }

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

                Object this$order_amount = this.getOrder_amount();
                Object other$order_amount = other.getOrder_amount();
                if (this$order_amount == null) {
                    if (other$order_amount != null) {
                        return false;
                    }
                } else if (!this$order_amount.equals(other$order_amount)) {
                    return false;
                }

                label134: {
                    Object this$seller_goods_id = this.getSeller_goods_id();
                    Object other$seller_goods_id = other.getSeller_goods_id();
                    if (this$seller_goods_id == null) {
                        if (other$seller_goods_id == null) {
                            break label134;
                        }
                    } else if (this$seller_goods_id.equals(other$seller_goods_id)) {
                        break label134;
                    }

                    return false;
                }

                label127: {
                    Object this$orderIds = this.getOrderIds();
                    Object other$orderIds = other.getOrderIds();
                    if (this$orderIds == null) {
                        if (other$orderIds == null) {
                            break label127;
                        }
                    } else if (this$orderIds.equals(other$orderIds)) {
                        break label127;
                    }

                    return false;
                }

                Object this$type = this.getType();
                Object other$type = other.getType();
                if (this$type == null) {
                    if (other$type != null) {
                        return false;
                    }
                } else if (!this$type.equals(other$type)) {
                    return false;
                }

                Object this$createUser = this.getCreateUser();
                Object other$createUser = other.getCreateUser();
                if (this$createUser == null) {
                    if (other$createUser != null) {
                        return false;
                    }
                } else if (!this$createUser.equals(other$createUser)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OrderRecord;
    }

    public int hashCode() {
          
        int result = 1;
        Object $order_spacing_start = this.getOrder_spacing_start();
        result = result * 59 + ($order_spacing_start == null ? 43 : $order_spacing_start.hashCode());
        Object $order_spacing_end = this.getOrder_spacing_end();
        result = result * 59 + ($order_spacing_end == null ? 43 : $order_spacing_end.hashCode());
        Object $buy_num_start = this.getBuy_num_start();
        result = result * 59 + ($buy_num_start == null ? 43 : $buy_num_start.hashCode());
        Object $buy_num_end = this.getBuy_num_end();
        result = result * 59 + ($buy_num_end == null ? 43 : $buy_num_end.hashCode());
        Object $order_num = this.getOrder_num();
        result = result * 59 + ($order_num == null ? 43 : $order_num.hashCode());
        Object $orderNumAll = this.getOrderNumAll();
        result = result * 59 + ($orderNumAll == null ? 43 : $orderNumAll.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $start_time = this.getStart_time();
        result = result * 59 + ($start_time == null ? 43 : $start_time.hashCode());
        Object $end_time = this.getEnd_time();
        result = result * 59 + ($end_time == null ? 43 : $end_time.hashCode());
        Object $buy_amount_start = this.getBuy_amount_start();
        result = result * 59 + ($buy_amount_start == null ? 43 : $buy_amount_start.hashCode());
        Object $buy_amount_end = this.getBuy_amount_end();
        result = result * 59 + ($buy_amount_end == null ? 43 : $buy_amount_end.hashCode());
        Object $lump_amount = this.getLump_amount();
        result = result * 59 + ($lump_amount == null ? 43 : $lump_amount.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $order_amount = this.getOrder_amount();
        result = result * 59 + ($order_amount == null ? 43 : $order_amount.hashCode());
        Object $seller_goods_id = this.getSeller_goods_id();
        result = result * 59 + ($seller_goods_id == null ? 43 : $seller_goods_id.hashCode());
        Object $orderIds = this.getOrderIds();
        result = result * 59 + ($orderIds == null ? 43 : $orderIds.hashCode());
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        Object $createUser = this.getCreateUser();
        result = result * 59 + ($createUser == null ? 43 : $createUser.hashCode());
        return result;
    }

    public String toString() {
        return "OrderRecord(id=" + this.getId() + ", start_time=" + this.getStart_time() + ", end_time=" + this.getEnd_time() + ", order_spacing_start=" + this.getOrder_spacing_start() + ", order_spacing_end=" + this.getOrder_spacing_end() + ", buy_num_start=" + this.getBuy_num_start() + ", buy_num_end=" + this.getBuy_num_end() + ", buy_amount_start=" + this.getBuy_amount_start() + ", buy_amount_end=" + this.getBuy_amount_end() + ", lump_amount=" + this.getLump_amount() + ", order_num=" + this.getOrder_num() + ", createTime=" + this.getCreateTime() + ", orderNumAll=" + this.getOrderNumAll() + ", order_amount=" + this.getOrder_amount() + ", seller_goods_id=" + this.getSeller_goods_id() + ", status=" + this.getStatus() + ", orderIds=" + this.getOrderIds() + ", type=" + this.getType() + ", createUser=" + this.getCreateUser() + ")";
    }
}
