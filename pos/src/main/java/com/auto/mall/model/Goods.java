 

package com.auto.mall.model;

import cn.hutool.core.collection.CollectionUtil;
import com.auto.mall.api.req.GoodsReq;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@TableName("T_MALL_SYSTEM_GOODS")
public class Goods implements Serializable {
    private static final long serialVersionUID = 4123602918171610611L;
    @TableId(
            value = "uuid",
            type = IdType.UUID
    )
    private String id;
    @TableField("link")
    private String link;
    @TableField("system_price")
    private BigDecimal systemPrice;
    @TableField("category_id")
    private String categoryId;
    @TableField("is_shelf")
    private Integer isShelf = 1;
    @TableField("create_time")
    private Date createTime;
    @TableField("up_time")
    private long upTime;
    @TableField("freight_amount")
    private Double freightAmount = 0.0;
    @TableField("img_url_1")
    private String img_url_1;
    @TableField("img_url_2")
    private String img_url_2;
    @TableField("img_url_3")
    private String img_url_3;
    @TableField("img_url_4")
    private String img_url_4;
    @TableField("img_url_5")
    private String img_url_5;
    @TableField("img_url_6")
    private String img_url_6;
    @TableField("img_url_7")
    private String img_url_7;
    @TableField("img_url_8")
    private String img_url_8;
    @TableField("img_url_9")
    private String img_url_9;
    @TableField("img_url_10")
    private String img_url_10;

    public Goods() {
    }

    public Goods(GoodsReq req) {
        this.link = req.getLink();
        this.categoryId = req.getCategory();
        String price = req.getPrice();
        if (null != price && !price.equals("null")) {
            BigDecimal decimal = new BigDecimal(price.replaceAll("\\$|\\¥", ""));
            BigDecimal multiply = decimal.multiply(new BigDecimal("0.9"));
            this.systemPrice = multiply;
        } else {
            this.systemPrice = new BigDecimal("0.00");
        }

        this.createTime = new Date();
        this.upTime = System.currentTimeMillis();
        List<String> img = req.getImg();
        this.img_url_1 = this.img(img, 0);
        this.img_url_2 = this.img(img, 1);
        this.img_url_3 = this.img(img, 2);
        this.img_url_4 = this.img(img, 3);
        this.img_url_5 = this.img(img, 4);
        this.img_url_6 = this.img(img, 5);
        this.img_url_7 = this.img(img, 6);
        this.img_url_8 = this.img(img, 7);
        this.img_url_9 = this.img(img, 8);
        this.img_url_10 = this.img(img, 9);
    }

    private String img(List<String> album, int index) {
        if (CollectionUtil.isNotEmpty(album)) {
            int length = album.size();
            return index > length - 1 ? "" : (String)album.get(index);
        } else {
            return "";
        }
    }

    public String getId() {
        return this.id;
    }

    public String getLink() {
        return this.link;
    }

    public BigDecimal getSystemPrice() {
        return this.systemPrice;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public Integer getIsShelf() {
        return this.isShelf;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public long getUpTime() {
        return this.upTime;
    }

    public Double getFreightAmount() {
        return this.freightAmount;
    }

    public String getImg_url_1() {
        return this.img_url_1;
    }

    public String getImg_url_2() {
        return this.img_url_2;
    }

    public String getImg_url_3() {
        return this.img_url_3;
    }

    public String getImg_url_4() {
        return this.img_url_4;
    }

    public String getImg_url_5() {
        return this.img_url_5;
    }

    public String getImg_url_6() {
        return this.img_url_6;
    }

    public String getImg_url_7() {
        return this.img_url_7;
    }

    public String getImg_url_8() {
        return this.img_url_8;
    }

    public String getImg_url_9() {
        return this.img_url_9;
    }

    public String getImg_url_10() {
        return this.img_url_10;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setLink(final String link) {
        this.link = link;
    }

    public void setSystemPrice(final BigDecimal systemPrice) {
        this.systemPrice = systemPrice;
    }

    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    public void setIsShelf(final Integer isShelf) {
        this.isShelf = isShelf;
    }

    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
    }

    public void setUpTime(final long upTime) {
        this.upTime = upTime;
    }

    public void setFreightAmount(final Double freightAmount) {
        this.freightAmount = freightAmount;
    }

    public void setImg_url_1(final String img_url_1) {
        this.img_url_1 = img_url_1;
    }

    public void setImg_url_2(final String img_url_2) {
        this.img_url_2 = img_url_2;
    }

    public void setImg_url_3(final String img_url_3) {
        this.img_url_3 = img_url_3;
    }

    public void setImg_url_4(final String img_url_4) {
        this.img_url_4 = img_url_4;
    }

    public void setImg_url_5(final String img_url_5) {
        this.img_url_5 = img_url_5;
    }

    public void setImg_url_6(final String img_url_6) {
        this.img_url_6 = img_url_6;
    }

    public void setImg_url_7(final String img_url_7) {
        this.img_url_7 = img_url_7;
    }

    public void setImg_url_8(final String img_url_8) {
        this.img_url_8 = img_url_8;
    }

    public void setImg_url_9(final String img_url_9) {
        this.img_url_9 = img_url_9;
    }

    public void setImg_url_10(final String img_url_10) {
        this.img_url_10 = img_url_10;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Goods)) {
            return false;
        } else {
            Goods other = (Goods)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getUpTime() != other.getUpTime()) {
                return false;
            } else {
                label217: {
                    Object this$isShelf = this.getIsShelf();
                    Object other$isShelf = other.getIsShelf();
                    if (this$isShelf == null) {
                        if (other$isShelf == null) {
                            break label217;
                        }
                    } else if (this$isShelf.equals(other$isShelf)) {
                        break label217;
                    }

                    return false;
                }

                Object this$freightAmount = this.getFreightAmount();
                Object other$freightAmount = other.getFreightAmount();
                if (this$freightAmount == null) {
                    if (other$freightAmount != null) {
                        return false;
                    }
                } else if (!this$freightAmount.equals(other$freightAmount)) {
                    return false;
                }

                label203: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label203;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label203;
                    }

                    return false;
                }

                Object this$link = this.getLink();
                Object other$link = other.getLink();
                if (this$link == null) {
                    if (other$link != null) {
                        return false;
                    }
                } else if (!this$link.equals(other$link)) {
                    return false;
                }

                Object this$systemPrice = this.getSystemPrice();
                Object other$systemPrice = other.getSystemPrice();
                if (this$systemPrice == null) {
                    if (other$systemPrice != null) {
                        return false;
                    }
                } else if (!this$systemPrice.equals(other$systemPrice)) {
                    return false;
                }

                label182: {
                    Object this$categoryId = this.getCategoryId();
                    Object other$categoryId = other.getCategoryId();
                    if (this$categoryId == null) {
                        if (other$categoryId == null) {
                            break label182;
                        }
                    } else if (this$categoryId.equals(other$categoryId)) {
                        break label182;
                    }

                    return false;
                }

                label175: {
                    Object this$createTime = this.getCreateTime();
                    Object other$createTime = other.getCreateTime();
                    if (this$createTime == null) {
                        if (other$createTime == null) {
                            break label175;
                        }
                    } else if (this$createTime.equals(other$createTime)) {
                        break label175;
                    }

                    return false;
                }

                Object this$img_url_1 = this.getImg_url_1();
                Object other$img_url_1 = other.getImg_url_1();
                if (this$img_url_1 == null) {
                    if (other$img_url_1 != null) {
                        return false;
                    }
                } else if (!this$img_url_1.equals(other$img_url_1)) {
                    return false;
                }

                Object this$img_url_2 = this.getImg_url_2();
                Object other$img_url_2 = other.getImg_url_2();
                if (this$img_url_2 == null) {
                    if (other$img_url_2 != null) {
                        return false;
                    }
                } else if (!this$img_url_2.equals(other$img_url_2)) {
                    return false;
                }

                label154: {
                    Object this$img_url_3 = this.getImg_url_3();
                    Object other$img_url_3 = other.getImg_url_3();
                    if (this$img_url_3 == null) {
                        if (other$img_url_3 == null) {
                            break label154;
                        }
                    } else if (this$img_url_3.equals(other$img_url_3)) {
                        break label154;
                    }

                    return false;
                }

                label147: {
                    Object this$img_url_4 = this.getImg_url_4();
                    Object other$img_url_4 = other.getImg_url_4();
                    if (this$img_url_4 == null) {
                        if (other$img_url_4 == null) {
                            break label147;
                        }
                    } else if (this$img_url_4.equals(other$img_url_4)) {
                        break label147;
                    }

                    return false;
                }

                Object this$img_url_5 = this.getImg_url_5();
                Object other$img_url_5 = other.getImg_url_5();
                if (this$img_url_5 == null) {
                    if (other$img_url_5 != null) {
                        return false;
                    }
                } else if (!this$img_url_5.equals(other$img_url_5)) {
                    return false;
                }

                Object this$img_url_6 = this.getImg_url_6();
                Object other$img_url_6 = other.getImg_url_6();
                if (this$img_url_6 == null) {
                    if (other$img_url_6 != null) {
                        return false;
                    }
                } else if (!this$img_url_6.equals(other$img_url_6)) {
                    return false;
                }

                label126: {
                    Object this$img_url_7 = this.getImg_url_7();
                    Object other$img_url_7 = other.getImg_url_7();
                    if (this$img_url_7 == null) {
                        if (other$img_url_7 == null) {
                            break label126;
                        }
                    } else if (this$img_url_7.equals(other$img_url_7)) {
                        break label126;
                    }

                    return false;
                }

                label119: {
                    Object this$img_url_8 = this.getImg_url_8();
                    Object other$img_url_8 = other.getImg_url_8();
                    if (this$img_url_8 == null) {
                        if (other$img_url_8 == null) {
                            break label119;
                        }
                    } else if (this$img_url_8.equals(other$img_url_8)) {
                        break label119;
                    }

                    return false;
                }

                Object this$img_url_9 = this.getImg_url_9();
                Object other$img_url_9 = other.getImg_url_9();
                if (this$img_url_9 == null) {
                    if (other$img_url_9 != null) {
                        return false;
                    }
                } else if (!this$img_url_9.equals(other$img_url_9)) {
                    return false;
                }

                Object this$img_url_10 = this.getImg_url_10();
                Object other$img_url_10 = other.getImg_url_10();
                if (this$img_url_10 == null) {
                    if (other$img_url_10 != null) {
                        return false;
                    }
                } else if (!this$img_url_10.equals(other$img_url_10)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Goods;
    }

    public int hashCode() {
          
        int result = 1;
        long $upTime = this.getUpTime();
        result = result * 59 + (int)($upTime >>> 32 ^ $upTime);
        Object $isShelf = this.getIsShelf();
        result = result * 59 + ($isShelf == null ? 43 : $isShelf.hashCode());
        Object $freightAmount = this.getFreightAmount();
        result = result * 59 + ($freightAmount == null ? 43 : $freightAmount.hashCode());
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $link = this.getLink();
        result = result * 59 + ($link == null ? 43 : $link.hashCode());
        Object $systemPrice = this.getSystemPrice();
        result = result * 59 + ($systemPrice == null ? 43 : $systemPrice.hashCode());
        Object $categoryId = this.getCategoryId();
        result = result * 59 + ($categoryId == null ? 43 : $categoryId.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $img_url_1 = this.getImg_url_1();
        result = result * 59 + ($img_url_1 == null ? 43 : $img_url_1.hashCode());
        Object $img_url_2 = this.getImg_url_2();
        result = result * 59 + ($img_url_2 == null ? 43 : $img_url_2.hashCode());
        Object $img_url_3 = this.getImg_url_3();
        result = result * 59 + ($img_url_3 == null ? 43 : $img_url_3.hashCode());
        Object $img_url_4 = this.getImg_url_4();
        result = result * 59 + ($img_url_4 == null ? 43 : $img_url_4.hashCode());
        Object $img_url_5 = this.getImg_url_5();
        result = result * 59 + ($img_url_5 == null ? 43 : $img_url_5.hashCode());
        Object $img_url_6 = this.getImg_url_6();
        result = result * 59 + ($img_url_6 == null ? 43 : $img_url_6.hashCode());
        Object $img_url_7 = this.getImg_url_7();
        result = result * 59 + ($img_url_7 == null ? 43 : $img_url_7.hashCode());
        Object $img_url_8 = this.getImg_url_8();
        result = result * 59 + ($img_url_8 == null ? 43 : $img_url_8.hashCode());
        Object $img_url_9 = this.getImg_url_9();
        result = result * 59 + ($img_url_9 == null ? 43 : $img_url_9.hashCode());
        Object $img_url_10 = this.getImg_url_10();
        result = result * 59 + ($img_url_10 == null ? 43 : $img_url_10.hashCode());
        return result;
    }

    public String toString() {
        return "Goods(id=" + this.getId() + ", link=" + this.getLink() + ", systemPrice=" + this.getSystemPrice() + ", categoryId=" + this.getCategoryId() + ", isShelf=" + this.getIsShelf() + ", createTime=" + this.getCreateTime() + ", upTime=" + this.getUpTime() + ", freightAmount=" + this.getFreightAmount() + ", img_url_1=" + this.getImg_url_1() + ", img_url_2=" + this.getImg_url_2() + ", img_url_3=" + this.getImg_url_3() + ", img_url_4=" + this.getImg_url_4() + ", img_url_5=" + this.getImg_url_5() + ", img_url_6=" + this.getImg_url_6() + ", img_url_7=" + this.getImg_url_7() + ", img_url_8=" + this.getImg_url_8() + ", img_url_9=" + this.getImg_url_9() + ", img_url_10=" + this.getImg_url_10() + ")";
    }
}
