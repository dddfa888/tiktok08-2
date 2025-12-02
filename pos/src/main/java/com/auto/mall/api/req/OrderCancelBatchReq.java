 

package com.auto.mall.api.req;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class OrderCancelBatchReq implements Serializable {
    private String secret;
    private List<String> orderIds;

    public OrderCancelBatchReq() {
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OrderCancelBatchReq)) {
            return false;
        } else {
            OrderCancelBatchReq other = (OrderCancelBatchReq)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$secret = this.getSecret();
                Object other$secret = other.getSecret();
                if (this$secret == null) {
                    if (other$secret != null) {
                        return false;
                    }
                } else if (!this$secret.equals(other$secret)) {
                    return false;
                }

                Object this$orderIds = this.getOrderIds();
                Object other$orderIds = other.getOrderIds();
                if (this$orderIds == null) {
                    if (other$orderIds != null) {
                        return false;
                    }
                } else if (!this$orderIds.equals(other$orderIds)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OrderCancelBatchReq;
    }

    public int hashCode() {

        int result = 1;
        Object $secret = this.getSecret();
        result = result * 59 + ($secret == null ? 43 : $secret.hashCode());
        Object $orderIds = this.getOrderIds();
        result = result * 59 + ($orderIds == null ? 43 : $orderIds.hashCode());
        return result;
    }

    public String toString() {
        return "OrderCancelBatchReq(secret=" + this.getSecret() + ", orderIds=" + this.getOrderIds() + ")";
    }
}
