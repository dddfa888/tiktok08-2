 

package com.auto.mall.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class MallRebateDto implements Serializable {
    private String uuid;
    private int orderCount;
    private BigDecimal income;

    public MallRebateDto() {
    }

    public String getUuid() {
        return this.uuid;
    }

    public int getOrderCount() {
        return this.orderCount;
    }

    public BigDecimal getIncome() {
        return this.income;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }

    public void setOrderCount(final int orderCount) {
        this.orderCount = orderCount;
    }

    public void setIncome(final BigDecimal income) {
        this.income = income;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MallRebateDto)) {
            return false;
        } else {
            MallRebateDto other = (MallRebateDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getOrderCount() != other.getOrderCount()) {
                return false;
            } else {
                Object this$uuid = this.getUuid();
                Object other$uuid = other.getUuid();
                if (this$uuid == null) {
                    if (other$uuid != null) {
                        return false;
                    }
                } else if (!this$uuid.equals(other$uuid)) {
                    return false;
                }

                Object this$income = this.getIncome();
                Object other$income = other.getIncome();
                if (this$income == null) {
                    if (other$income != null) {
                        return false;
                    }
                } else if (!this$income.equals(other$income)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MallRebateDto;
    }

    public int hashCode() {
          
        int result = 1;
        result = result * 59 + this.getOrderCount();
        Object $uuid = this.getUuid();
        result = result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
        Object $income = this.getIncome();
        result = result * 59 + ($income == null ? 43 : $income.hashCode());
        return result;
    }

    public String toString() {
        return "MallRebateDto(uuid=" + this.getUuid() + ", orderCount=" + this.getOrderCount() + ", income=" + this.getIncome() + ")";
    }
}
