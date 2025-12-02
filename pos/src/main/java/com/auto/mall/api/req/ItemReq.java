 

package com.auto.mall.api.req;

import java.io.Serializable;

public class ItemReq implements Serializable {
    private static final long serialVersionUID = -4900213401019956641L;
    private String itemId;
    private String skuId;
    private Integer count;

    public ItemReq() {
    }

    public String getItemId() {
        return this.itemId;
    }

    public String getSkuId() {
        return this.skuId;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setItemId(final String itemId) {
        this.itemId = itemId;
    }

    public void setSkuId(final String skuId) {
        this.skuId = skuId;
    }

    public void setCount(final Integer count) {
        this.count = count;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ItemReq)) {
            return false;
        } else {
            ItemReq other = (ItemReq)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$count = this.getCount();
                    Object other$count = other.getCount();
                    if (this$count == null) {
                        if (other$count == null) {
                            break label47;
                        }
                    } else if (this$count.equals(other$count)) {
                        break label47;
                    }

                    return false;
                }

                Object this$itemId = this.getItemId();
                Object other$itemId = other.getItemId();
                if (this$itemId == null) {
                    if (other$itemId != null) {
                        return false;
                    }
                } else if (!this$itemId.equals(other$itemId)) {
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

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ItemReq;
    }

    public int hashCode() {

        int result = 1;
        Object $count = this.getCount();
        result = result * 59 + ($count == null ? 43 : $count.hashCode());
        Object $itemId = this.getItemId();
        result = result * 59 + ($itemId == null ? 43 : $itemId.hashCode());
        Object $skuId = this.getSkuId();
        result = result * 59 + ($skuId == null ? 43 : $skuId.hashCode());
        return result;
    }

    public String toString() {
        return "ItemReq(itemId=" + this.getItemId() + ", skuId=" + this.getSkuId() + ", count=" + this.getCount() + ")";
    }
}
