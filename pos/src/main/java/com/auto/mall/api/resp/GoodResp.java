 

package com.auto.mall.api.resp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GoodResp implements Serializable {
    private static final long serialVersionUID = 5606408312857797609L;
    private String uuid;
    private String skuId;
    private String sellerId;
    private Integer sold_num;
    private Integer view_num;
    private BigDecimal discountPrice;
    private BigDecimal sellingPrice;
    private Date discountStartTime;
    private Date discountEndTime;

    public GoodResp() {
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getSkuId() {
        return this.skuId;
    }

    public String getSellerId() {
        return this.sellerId;
    }

    public Integer getSold_num() {
        return this.sold_num;
    }

    public Integer getView_num() {
        return this.view_num;
    }

    public BigDecimal getDiscountPrice() {
        return this.discountPrice;
    }

    public BigDecimal getSellingPrice() {
        return this.sellingPrice;
    }

    public Date getDiscountStartTime() {
        return this.discountStartTime;
    }

    public Date getDiscountEndTime() {
        return this.discountEndTime;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }

    public void setSkuId(final String skuId) {
        this.skuId = skuId;
    }

    public void setSellerId(final String sellerId) {
        this.sellerId = sellerId;
    }

    public void setSold_num(final Integer sold_num) {
        this.sold_num = sold_num;
    }

    public void setView_num(final Integer view_num) {
        this.view_num = view_num;
    }

    public void setDiscountPrice(final BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public void setSellingPrice(final BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setDiscountStartTime(final Date discountStartTime) {
        this.discountStartTime = discountStartTime;
    }

    public void setDiscountEndTime(final Date discountEndTime) {
        this.discountEndTime = discountEndTime;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof GoodResp)) {
            return false;
        } else {
            GoodResp other = (GoodResp)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label119: {
                    Object this$sold_num = this.getSold_num();
                    Object other$sold_num = other.getSold_num();
                    if (this$sold_num == null) {
                        if (other$sold_num == null) {
                            break label119;
                        }
                    } else if (this$sold_num.equals(other$sold_num)) {
                        break label119;
                    }

                    return false;
                }

                Object this$view_num = this.getView_num();
                Object other$view_num = other.getView_num();
                if (this$view_num == null) {
                    if (other$view_num != null) {
                        return false;
                    }
                } else if (!this$view_num.equals(other$view_num)) {
                    return false;
                }

                label105: {
                    Object this$uuid = this.getUuid();
                    Object other$uuid = other.getUuid();
                    if (this$uuid == null) {
                        if (other$uuid == null) {
                            break label105;
                        }
                    } else if (this$uuid.equals(other$uuid)) {
                        break label105;
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

                label91: {
                    Object this$sellerId = this.getSellerId();
                    Object other$sellerId = other.getSellerId();
                    if (this$sellerId == null) {
                        if (other$sellerId == null) {
                            break label91;
                        }
                    } else if (this$sellerId.equals(other$sellerId)) {
                        break label91;
                    }

                    return false;
                }

                Object this$discountPrice = this.getDiscountPrice();
                Object other$discountPrice = other.getDiscountPrice();
                if (this$discountPrice == null) {
                    if (other$discountPrice != null) {
                        return false;
                    }
                } else if (!this$discountPrice.equals(other$discountPrice)) {
                    return false;
                }

                label77: {
                    Object this$sellingPrice = this.getSellingPrice();
                    Object other$sellingPrice = other.getSellingPrice();
                    if (this$sellingPrice == null) {
                        if (other$sellingPrice == null) {
                            break label77;
                        }
                    } else if (this$sellingPrice.equals(other$sellingPrice)) {
                        break label77;
                    }

                    return false;
                }

                label70: {
                    Object this$discountStartTime = this.getDiscountStartTime();
                    Object other$discountStartTime = other.getDiscountStartTime();
                    if (this$discountStartTime == null) {
                        if (other$discountStartTime == null) {
                            break label70;
                        }
                    } else if (this$discountStartTime.equals(other$discountStartTime)) {
                        break label70;
                    }

                    return false;
                }

                Object this$discountEndTime = this.getDiscountEndTime();
                Object other$discountEndTime = other.getDiscountEndTime();
                if (this$discountEndTime == null) {
                    if (other$discountEndTime != null) {
                        return false;
                    }
                } else if (!this$discountEndTime.equals(other$discountEndTime)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GoodResp;
    }

    public int hashCode() {
          
        int result = 1;
        Object $sold_num = this.getSold_num();
        result = result * 59 + ($sold_num == null ? 43 : $sold_num.hashCode());
        Object $view_num = this.getView_num();
        result = result * 59 + ($view_num == null ? 43 : $view_num.hashCode());
        Object $uuid = this.getUuid();
        result = result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
        Object $skuId = this.getSkuId();
        result = result * 59 + ($skuId == null ? 43 : $skuId.hashCode());
        Object $sellerId = this.getSellerId();
        result = result * 59 + ($sellerId == null ? 43 : $sellerId.hashCode());
        Object $discountPrice = this.getDiscountPrice();
        result = result * 59 + ($discountPrice == null ? 43 : $discountPrice.hashCode());
        Object $sellingPrice = this.getSellingPrice();
        result = result * 59 + ($sellingPrice == null ? 43 : $sellingPrice.hashCode());
        Object $discountStartTime = this.getDiscountStartTime();
        result = result * 59 + ($discountStartTime == null ? 43 : $discountStartTime.hashCode());
        Object $discountEndTime = this.getDiscountEndTime();
        result = result * 59 + ($discountEndTime == null ? 43 : $discountEndTime.hashCode());
        return result;
    }

    public String toString() {
        return "GoodResp(uuid=" + this.getUuid() + ", skuId=" + this.getSkuId() + ", sellerId=" + this.getSellerId() + ", sold_num=" + this.getSold_num() + ", view_num=" + this.getView_num() + ", discountPrice=" + this.getDiscountPrice() + ", sellingPrice=" + this.getSellingPrice() + ", discountStartTime=" + this.getDiscountStartTime() + ", discountEndTime=" + this.getDiscountEndTime() + ")";
    }
}
