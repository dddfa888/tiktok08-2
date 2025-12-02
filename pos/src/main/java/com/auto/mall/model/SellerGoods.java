 

package com.auto.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

@TableName("T_MALL_SELLER_GOODS")
public class SellerGoods implements Serializable {
    private static final long serialVersionUID = -5319590836180705807L;
    @TableId(
            value = "uuid",
            type = IdType.UUID
    )
    private String id;
    @TableField("seller_id")
    private String sellerId;
    @TableField("category_id")
    private String categoryId;
    @TableField("secondary_category_id")
    private String secondaryCategoryId;
    @TableField("goods_id")
    private String goodId;
    @TableField("views_num")
    private Integer viewNum;
    @TableField("selling_price")
    private BigDecimal sellingPrice;
    @TableField("is_shelf")
    private Integer isShelf;
    @TableField("is_valid")
    private int isValid;

    public SellerGoods() {
    }

    public String getId() {
        return this.id;
    }

    public String getSellerId() {
        return this.sellerId;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getSecondaryCategoryId() {
        return this.secondaryCategoryId;
    }

    public String getGoodId() {
        return this.goodId;
    }

    public Integer getViewNum() {
        return this.viewNum;
    }

    public BigDecimal getSellingPrice() {
        return this.sellingPrice;
    }

    public Integer getIsShelf() {
        return this.isShelf;
    }

    public int getIsValid() {
        return this.isValid;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setSellerId(final String sellerId) {
        this.sellerId = sellerId;
    }

    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    public void setSecondaryCategoryId(final String secondaryCategoryId) {
        this.secondaryCategoryId = secondaryCategoryId;
    }

    public void setGoodId(final String goodId) {
        this.goodId = goodId;
    }

    public void setViewNum(final Integer viewNum) {
        this.viewNum = viewNum;
    }

    public void setSellingPrice(final BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setIsShelf(final Integer isShelf) {
        this.isShelf = isShelf;
    }

    public void setIsValid(final int isValid) {
        this.isValid = isValid;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SellerGoods)) {
            return false;
        } else {
            SellerGoods other = (SellerGoods)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getIsValid() != other.getIsValid()) {
                return false;
            } else {
                label109: {
                    Object this$viewNum = this.getViewNum();
                    Object other$viewNum = other.getViewNum();
                    if (this$viewNum == null) {
                        if (other$viewNum == null) {
                            break label109;
                        }
                    } else if (this$viewNum.equals(other$viewNum)) {
                        break label109;
                    }

                    return false;
                }

                label102: {
                    Object this$isShelf = this.getIsShelf();
                    Object other$isShelf = other.getIsShelf();
                    if (this$isShelf == null) {
                        if (other$isShelf == null) {
                            break label102;
                        }
                    } else if (this$isShelf.equals(other$isShelf)) {
                        break label102;
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

                label88: {
                    Object this$sellerId = this.getSellerId();
                    Object other$sellerId = other.getSellerId();
                    if (this$sellerId == null) {
                        if (other$sellerId == null) {
                            break label88;
                        }
                    } else if (this$sellerId.equals(other$sellerId)) {
                        break label88;
                    }

                    return false;
                }

                Object this$categoryId = this.getCategoryId();
                Object other$categoryId = other.getCategoryId();
                if (this$categoryId == null) {
                    if (other$categoryId != null) {
                        return false;
                    }
                } else if (!this$categoryId.equals(other$categoryId)) {
                    return false;
                }

                label74: {
                    Object this$secondaryCategoryId = this.getSecondaryCategoryId();
                    Object other$secondaryCategoryId = other.getSecondaryCategoryId();
                    if (this$secondaryCategoryId == null) {
                        if (other$secondaryCategoryId == null) {
                            break label74;
                        }
                    } else if (this$secondaryCategoryId.equals(other$secondaryCategoryId)) {
                        break label74;
                    }

                    return false;
                }

                Object this$goodId = this.getGoodId();
                Object other$goodId = other.getGoodId();
                if (this$goodId == null) {
                    if (other$goodId != null) {
                        return false;
                    }
                } else if (!this$goodId.equals(other$goodId)) {
                    return false;
                }

                Object this$sellingPrice = this.getSellingPrice();
                Object other$sellingPrice = other.getSellingPrice();
                if (this$sellingPrice == null) {
                    if (other$sellingPrice != null) {
                        return false;
                    }
                } else if (!this$sellingPrice.equals(other$sellingPrice)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SellerGoods;
    }

    public int hashCode() {
          
        int result = 1;
        result = result * 59 + this.getIsValid();
        Object $viewNum = this.getViewNum();
        result = result * 59 + ($viewNum == null ? 43 : $viewNum.hashCode());
        Object $isShelf = this.getIsShelf();
        result = result * 59 + ($isShelf == null ? 43 : $isShelf.hashCode());
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $sellerId = this.getSellerId();
        result = result * 59 + ($sellerId == null ? 43 : $sellerId.hashCode());
        Object $categoryId = this.getCategoryId();
        result = result * 59 + ($categoryId == null ? 43 : $categoryId.hashCode());
        Object $secondaryCategoryId = this.getSecondaryCategoryId();
        result = result * 59 + ($secondaryCategoryId == null ? 43 : $secondaryCategoryId.hashCode());
        Object $goodId = this.getGoodId();
        result = result * 59 + ($goodId == null ? 43 : $goodId.hashCode());
        Object $sellingPrice = this.getSellingPrice();
        result = result * 59 + ($sellingPrice == null ? 43 : $sellingPrice.hashCode());
        return result;
    }

    public String toString() {
        return "SellerGoods(id=" + this.getId() + ", sellerId=" + this.getSellerId() + ", categoryId=" + this.getCategoryId() + ", secondaryCategoryId=" + this.getSecondaryCategoryId() + ", goodId=" + this.getGoodId() + ", viewNum=" + this.getViewNum() + ", sellingPrice=" + this.getSellingPrice() + ", isShelf=" + this.getIsShelf() + ", isValid=" + this.getIsValid() + ")";
    }
}
