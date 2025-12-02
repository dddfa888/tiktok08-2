 

package com.auto.mall.api.resp;

import java.io.Serializable;
import java.math.BigDecimal;

public class PromoteResp implements Serializable {
    private static final long serialVersionUID = -3472269520924090526L;
    private String uuid;
    private String avatar;
    private String name;
    private BigDecimal income;
    private Integer orderCount;
    private String createTime;

    public PromoteResp() {
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getIncome() {
        return this.income;
    }

    public Integer getOrderCount() {
        return this.orderCount;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }

    public void setAvatar(final String avatar) {
        this.avatar = avatar;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setIncome(final BigDecimal income) {
        this.income = income;
    }

    public void setOrderCount(final Integer orderCount) {
        this.orderCount = orderCount;
    }

    public void setCreateTime(final String createTime) {
        this.createTime = createTime;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PromoteResp)) {
            return false;
        } else {
            PromoteResp other = (PromoteResp)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$orderCount = this.getOrderCount();
                Object other$orderCount = other.getOrderCount();
                if (this$orderCount == null) {
                    if (other$orderCount != null) {
                        return false;
                    }
                } else if (!this$orderCount.equals(other$orderCount)) {
                    return false;
                }

                Object this$uuid = this.getUuid();
                Object other$uuid = other.getUuid();
                if (this$uuid == null) {
                    if (other$uuid != null) {
                        return false;
                    }
                } else if (!this$uuid.equals(other$uuid)) {
                    return false;
                }

                Object this$avatar = this.getAvatar();
                Object other$avatar = other.getAvatar();
                if (this$avatar == null) {
                    if (other$avatar != null) {
                        return false;
                    }
                } else if (!this$avatar.equals(other$avatar)) {
                    return false;
                }

                label62: {
                    Object this$name = this.getName();
                    Object other$name = other.getName();
                    if (this$name == null) {
                        if (other$name == null) {
                            break label62;
                        }
                    } else if (this$name.equals(other$name)) {
                        break label62;
                    }

                    return false;
                }

                label55: {
                    Object this$income = this.getIncome();
                    Object other$income = other.getIncome();
                    if (this$income == null) {
                        if (other$income == null) {
                            break label55;
                        }
                    } else if (this$income.equals(other$income)) {
                        break label55;
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

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PromoteResp;
    }

    public int hashCode() {
          
        int result = 1;
        Object $orderCount = this.getOrderCount();
        result = result * 59 + ($orderCount == null ? 43 : $orderCount.hashCode());
        Object $uuid = this.getUuid();
        result = result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
        Object $avatar = this.getAvatar();
        result = result * 59 + ($avatar == null ? 43 : $avatar.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $income = this.getIncome();
        result = result * 59 + ($income == null ? 43 : $income.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        return result;
    }

    public String toString() {
        return "PromoteResp(uuid=" + this.getUuid() + ", avatar=" + this.getAvatar() + ", name=" + this.getName() + ", income=" + this.getIncome() + ", orderCount=" + this.getOrderCount() + ", createTime=" + this.getCreateTime() + ")";
    }
}
