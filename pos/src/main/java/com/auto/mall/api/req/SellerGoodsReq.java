 

package com.auto.mall.api.req;

import java.util.List;

public class SellerGoodsReq extends PageReq {
    private static final long serialVersionUID = 1923654772813254748L;
    private String goodsName;
    private String sellerId;
    private String userCode;
    private String categoryId;
    private String secondaryCategoryId;
    private String loginPartyId;
    private List<String> children;

    public SellerGoodsReq() {
    }

    public String getGoodsName() {
        return this.goodsName;
    }

    public String getSellerId() {
        return this.sellerId;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getSecondaryCategoryId() {
        return this.secondaryCategoryId;
    }

    public String getLoginPartyId() {
        return this.loginPartyId;
    }

    public List<String> getChildren() {
        return this.children;
    }

    public void setGoodsName(final String goodsName) {
        this.goodsName = goodsName;
    }

    public void setSellerId(final String sellerId) {
        this.sellerId = sellerId;
    }

    public void setUserCode(final String userCode) {
        this.userCode = userCode;
    }

    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    public void setSecondaryCategoryId(final String secondaryCategoryId) {
        this.secondaryCategoryId = secondaryCategoryId;
    }

    public void setLoginPartyId(final String loginPartyId) {
        this.loginPartyId = loginPartyId;
    }

    public void setChildren(final List<String> children) {
        this.children = children;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SellerGoodsReq)) {
            return false;
        } else {
            SellerGoodsReq other = (SellerGoodsReq)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label95: {
                    Object this$goodsName = this.getGoodsName();
                    Object other$goodsName = other.getGoodsName();
                    if (this$goodsName == null) {
                        if (other$goodsName == null) {
                            break label95;
                        }
                    } else if (this$goodsName.equals(other$goodsName)) {
                        break label95;
                    }

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

                Object this$userCode = this.getUserCode();
                Object other$userCode = other.getUserCode();
                if (this$userCode == null) {
                    if (other$userCode != null) {
                        return false;
                    }
                } else if (!this$userCode.equals(other$userCode)) {
                    return false;
                }

                label74: {
                    Object this$categoryId = this.getCategoryId();
                    Object other$categoryId = other.getCategoryId();
                    if (this$categoryId == null) {
                        if (other$categoryId == null) {
                            break label74;
                        }
                    } else if (this$categoryId.equals(other$categoryId)) {
                        break label74;
                    }

                    return false;
                }

                label67: {
                    Object this$secondaryCategoryId = this.getSecondaryCategoryId();
                    Object other$secondaryCategoryId = other.getSecondaryCategoryId();
                    if (this$secondaryCategoryId == null) {
                        if (other$secondaryCategoryId == null) {
                            break label67;
                        }
                    } else if (this$secondaryCategoryId.equals(other$secondaryCategoryId)) {
                        break label67;
                    }

                    return false;
                }

                Object this$loginPartyId = this.getLoginPartyId();
                Object other$loginPartyId = other.getLoginPartyId();
                if (this$loginPartyId == null) {
                    if (other$loginPartyId != null) {
                        return false;
                    }
                } else if (!this$loginPartyId.equals(other$loginPartyId)) {
                    return false;
                }

                Object this$children = this.getChildren();
                Object other$children = other.getChildren();
                if (this$children == null) {
                    if (other$children != null) {
                        return false;
                    }
                } else if (!this$children.equals(other$children)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SellerGoodsReq;
    }

    public int hashCode() {
          
        int result = 1;
        Object $goodsName = this.getGoodsName();
        result = result * 59 + ($goodsName == null ? 43 : $goodsName.hashCode());
        Object $sellerId = this.getSellerId();
        result = result * 59 + ($sellerId == null ? 43 : $sellerId.hashCode());
        Object $userCode = this.getUserCode();
        result = result * 59 + ($userCode == null ? 43 : $userCode.hashCode());
        Object $categoryId = this.getCategoryId();
        result = result * 59 + ($categoryId == null ? 43 : $categoryId.hashCode());
        Object $secondaryCategoryId = this.getSecondaryCategoryId();
        result = result * 59 + ($secondaryCategoryId == null ? 43 : $secondaryCategoryId.hashCode());
        Object $loginPartyId = this.getLoginPartyId();
        result = result * 59 + ($loginPartyId == null ? 43 : $loginPartyId.hashCode());
        Object $children = this.getChildren();
        result = result * 59 + ($children == null ? 43 : $children.hashCode());
        return result;
    }

    public String toString() {
        return "SellerGoodsReq(goodsName=" + this.getGoodsName() + ", sellerId=" + this.getSellerId() + ", userCode=" + this.getUserCode() + ", categoryId=" + this.getCategoryId() + ", secondaryCategoryId=" + this.getSecondaryCategoryId() + ", loginPartyId=" + this.getLoginPartyId() + ", children=" + this.getChildren() + ")";
    }
}
