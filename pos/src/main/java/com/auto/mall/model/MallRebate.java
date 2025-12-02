 

package com.auto.mall.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName("T_MALL_REBATE")
public class MallRebate implements Serializable {
    @TableId(
            value = "uuid",
            type = IdType.UUID
    )
    private String id;
    @TableField("order_id")
    private String orderId;
    @TableField("party_id")
    private String partyId;
    @TableField("order_party_id")
    private String orderPartyId;
    @TableField("rebate")
    private BigDecimal rebate;
    @TableField("level")
    private Integer level;
    @TableField(
            fill = FieldFill.INSERT,
            value = "create_time"
    )
    private Date createTime;

    public MallRebate() {
    }

    public String getId() {
        return this.id;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public String getOrderPartyId() {
        return this.orderPartyId;
    }

    public BigDecimal getRebate() {
        return this.rebate;
    }

    public Integer getLevel() {
        return this.level;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    public void setPartyId(final String partyId) {
        this.partyId = partyId;
    }

    public void setOrderPartyId(final String orderPartyId) {
        this.orderPartyId = orderPartyId;
    }

    public void setRebate(final BigDecimal rebate) {
        this.rebate = rebate;
    }

    public void setLevel(final Integer level) {
        this.level = level;
    }

    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MallRebate)) {
            return false;
        } else {
            MallRebate other = (MallRebate)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label95: {
                    Object this$level = this.getLevel();
                    Object other$level = other.getLevel();
                    if (this$level == null) {
                        if (other$level == null) {
                            break label95;
                        }
                    } else if (this$level.equals(other$level)) {
                        break label95;
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

                Object this$orderId = this.getOrderId();
                Object other$orderId = other.getOrderId();
                if (this$orderId == null) {
                    if (other$orderId != null) {
                        return false;
                    }
                } else if (!this$orderId.equals(other$orderId)) {
                    return false;
                }

                label74: {
                    Object this$partyId = this.getPartyId();
                    Object other$partyId = other.getPartyId();
                    if (this$partyId == null) {
                        if (other$partyId == null) {
                            break label74;
                        }
                    } else if (this$partyId.equals(other$partyId)) {
                        break label74;
                    }

                    return false;
                }

                label67: {
                    Object this$orderPartyId = this.getOrderPartyId();
                    Object other$orderPartyId = other.getOrderPartyId();
                    if (this$orderPartyId == null) {
                        if (other$orderPartyId == null) {
                            break label67;
                        }
                    } else if (this$orderPartyId.equals(other$orderPartyId)) {
                        break label67;
                    }

                    return false;
                }

                Object this$rebate = this.getRebate();
                Object other$rebate = other.getRebate();
                if (this$rebate == null) {
                    if (other$rebate != null) {
                        return false;
                    }
                } else if (!this$rebate.equals(other$rebate)) {
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
        return other instanceof MallRebate;
    }

    public int hashCode() {
          
        int result = 1;
        Object $level = this.getLevel();
        result = result * 59 + ($level == null ? 43 : $level.hashCode());
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $orderId = this.getOrderId();
        result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
        Object $partyId = this.getPartyId();
        result = result * 59 + ($partyId == null ? 43 : $partyId.hashCode());
        Object $orderPartyId = this.getOrderPartyId();
        result = result * 59 + ($orderPartyId == null ? 43 : $orderPartyId.hashCode());
        Object $rebate = this.getRebate();
        result = result * 59 + ($rebate == null ? 43 : $rebate.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        return result;
    }

    public String toString() {
        return "MallRebate(id=" + this.getId() + ", orderId=" + this.getOrderId() + ", partyId=" + this.getPartyId() + ", orderPartyId=" + this.getOrderPartyId() + ", rebate=" + this.getRebate() + ", level=" + this.getLevel() + ", createTime=" + this.getCreateTime() + ")";
    }
}
