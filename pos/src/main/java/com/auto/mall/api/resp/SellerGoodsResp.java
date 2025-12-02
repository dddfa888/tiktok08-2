 

package com.auto.mall.api.resp;

import java.math.BigDecimal;

public class SellerGoodsResp {
    private String goodsId;
    private String sellerId;
    private String sellerGoodsId;
    private String imgUrl;
    private BigDecimal sellingPrice;
    private String goodsName;

    public SellerGoodsResp() {
    }

    public String getGoodsId() {
        return this.goodsId;
    }

    public String getSellerId() {
        return this.sellerId;
    }

    public String getSellerGoodsId() {
        return this.sellerGoodsId;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public BigDecimal getSellingPrice() {
        return this.sellingPrice;
    }

    public String getGoodsName() {
        return this.goodsName;
    }

    public void setGoodsId(final String goodsId) {
        this.goodsId = goodsId;
    }

    public void setSellerId(final String sellerId) {
        this.sellerId = sellerId;
    }

    public void setSellerGoodsId(final String sellerGoodsId) {
        this.sellerGoodsId = sellerGoodsId;
    }

    public void setImgUrl(final String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setSellingPrice(final BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setGoodsName(final String goodsName) {
        this.goodsName = goodsName;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SellerGoodsResp)) {
            return false;
        } else {
            SellerGoodsResp other = (SellerGoodsResp)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$goodsId = this.getGoodsId();
                Object other$goodsId = other.getGoodsId();
                if (this$goodsId == null) {
                    if (other$goodsId != null) {
                        return false;
                    }
                } else if (!this$goodsId.equals(other$goodsId)) {
                    return false;
                }

                Object this$sellerId = this.getSellerId();
                Object other$sellerId = other.getSellerId();
                if (this$sellerId == null) {
                    if (other$sellerId != null) {
                        return false;
                    }
                } else if (!this$sellerId.equals(other$sellerId)) {
                    return false;
                }

                Object this$sellerGoodsId = this.getSellerGoodsId();
                Object other$sellerGoodsId = other.getSellerGoodsId();
                if (this$sellerGoodsId == null) {
                    if (other$sellerGoodsId != null) {
                        return false;
                    }
                } else if (!this$sellerGoodsId.equals(other$sellerGoodsId)) {
                    return false;
                }

                label62: {
                    Object this$imgUrl = this.getImgUrl();
                    Object other$imgUrl = other.getImgUrl();
                    if (this$imgUrl == null) {
                        if (other$imgUrl == null) {
                            break label62;
                        }
                    } else if (this$imgUrl.equals(other$imgUrl)) {
                        break label62;
                    }

                    return false;
                }

                label55: {
                    Object this$sellingPrice = this.getSellingPrice();
                    Object other$sellingPrice = other.getSellingPrice();
                    if (this$sellingPrice == null) {
                        if (other$sellingPrice == null) {
                            break label55;
                        }
                    } else if (this$sellingPrice.equals(other$sellingPrice)) {
                        break label55;
                    }

                    return false;
                }

                Object this$goodsName = this.getGoodsName();
                Object other$goodsName = other.getGoodsName();
                if (this$goodsName == null) {
                    if (other$goodsName != null) {
                        return false;
                    }
                } else if (!this$goodsName.equals(other$goodsName)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SellerGoodsResp;
    }

    public int hashCode() {
          
        int result = 1;
        Object $goodsId = this.getGoodsId();
        result = result * 59 + ($goodsId == null ? 43 : $goodsId.hashCode());
        Object $sellerId = this.getSellerId();
        result = result * 59 + ($sellerId == null ? 43 : $sellerId.hashCode());
        Object $sellerGoodsId = this.getSellerGoodsId();
        result = result * 59 + ($sellerGoodsId == null ? 43 : $sellerGoodsId.hashCode());
        Object $imgUrl = this.getImgUrl();
        result = result * 59 + ($imgUrl == null ? 43 : $imgUrl.hashCode());
        Object $sellingPrice = this.getSellingPrice();
        result = result * 59 + ($sellingPrice == null ? 43 : $sellingPrice.hashCode());
        Object $goodsName = this.getGoodsName();
        result = result * 59 + ($goodsName == null ? 43 : $goodsName.hashCode());
        return result;
    }

    public String toString() {
        return "SellerGoodsResp(goodsId=" + this.getGoodsId() + ", sellerId=" + this.getSellerId() + ", sellerGoodsId=" + this.getSellerGoodsId() + ", imgUrl=" + this.getImgUrl() + ", sellingPrice=" + this.getSellingPrice() + ", goodsName=" + this.getGoodsName() + ")";
    }
}
