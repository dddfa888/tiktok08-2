

package com.auto.mall.api.req;

import java.io.Serializable;

public class OrderCancelReq implements Serializable {
    private String secret;
    private String orderId;

    public OrderCancelReq() {
    }

    public String getSecret() {
        return this.secret;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setSecret(final String secret) {
        this.secret = secret;
    }

    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OrderCancelReq)) {
            return false;
        } else {
            OrderCancelReq other = (OrderCancelReq)o;
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

                Object this$orderId = this.getOrderId();
                Object other$orderId = other.getOrderId();
                if (this$orderId == null) {
                    if (other$orderId != null) {
                        return false;
                    }
                } else if (!this$orderId.equals(other$orderId)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OrderCancelReq;
    }

    public int hashCode() {
        int result = 1;
        Object $secret = this.getSecret();
        result = result * 59 + ($secret == null ? 43 : $secret.hashCode());
        Object $orderId = this.getOrderId();
        result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
        return result;
    }

    public String toString() {
        return "OrderCancelReq(secret=" + this.getSecret() + ", orderId=" + this.getOrderId() + ")";
    }
}
