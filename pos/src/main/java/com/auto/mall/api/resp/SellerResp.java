 

package com.auto.mall.api.resp;

public class SellerResp {
    private String sellerId;
    private String sellerName;

    public SellerResp() {
    }

    public String getSellerId() {
        return this.sellerId;
    }

    public String getSellerName() {
        return this.sellerName;
    }

    public void setSellerId(final String sellerId) {
        this.sellerId = sellerId;
    }

    public void setSellerName(final String sellerName) {
        this.sellerName = sellerName;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SellerResp)) {
            return false;
        } else {
            SellerResp other = (SellerResp)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$sellerId = this.getSellerId();
                Object other$sellerId = other.getSellerId();
                if (this$sellerId == null) {
                    if (other$sellerId != null) {
                        return false;
                    }
                } else if (!this$sellerId.equals(other$sellerId)) {
                    return false;
                }

                Object this$sellerName = this.getSellerName();
                Object other$sellerName = other.getSellerName();
                if (this$sellerName == null) {
                    if (other$sellerName != null) {
                        return false;
                    }
                } else if (!this$sellerName.equals(other$sellerName)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SellerResp;
    }

    public int hashCode() {
          
        int result = 1;
        Object $sellerId = this.getSellerId();
        result = result * 59 + ($sellerId == null ? 43 : $sellerId.hashCode());
        Object $sellerName = this.getSellerName();
        result = result * 59 + ($sellerName == null ? 43 : $sellerName.hashCode());
        return result;
    }

    public String toString() {
        return "SellerResp(sellerId=" + this.getSellerId() + ", sellerName=" + this.getSellerName() + ")";
    }
}
