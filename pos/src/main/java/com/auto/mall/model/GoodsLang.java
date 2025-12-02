 

package com.auto.mall.model;

import com.auto.mall.api.req.GoodsReq;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

@TableName("T_MALL_SYSTEM_GOODS_LANG")
public class GoodsLang extends Goods implements Serializable {
    private static final long serialVersionUID = 1655474738296596465L;
    @TableId(
            value = "uuid",
            type = IdType.UUID
    )
    private String id;
    @TableField("goods_id")
    private String goodId;
    @TableField("lang")
    private String lang = "en";
    @TableField("unit")
    private String unit;
    @TableField("name")
    private String name;
    @TableField("des")
    private String des;
    @TableField("img_des")
    private String img_desc;
    @TableField("type")
    private Integer type = 0;

    public GoodsLang() {
    }

    public GoodsLang(GoodsReq req, String goodId) {
        this.goodId = goodId;
        this.name = req.getTitle().replaceAll(" ", "");
        this.des = req.basic_info_str();
        this.img_desc = req.detail_str();
    }

    public String getId() {
        return this.id;
    }

    public String getGoodId() {
        return this.goodId;
    }

    public String getLang() {
        return this.lang;
    }

    public String getUnit() {
        return this.unit;
    }

    public String getName() {
        return this.name;
    }

    public String getDes() {
        return this.des;
    }

    public String getImg_desc() {
        return this.img_desc;
    }

    public Integer getType() {
        return this.type;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setGoodId(final String goodId) {
        this.goodId = goodId;
    }

    public void setLang(final String lang) {
        this.lang = lang;
    }

    public void setUnit(final String unit) {
        this.unit = unit;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setDes(final String des) {
        this.des = des;
    }

    public void setImg_desc(final String img_desc) {
        this.img_desc = img_desc;
    }

    public void setType(final Integer type) {
        this.type = type;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof GoodsLang)) {
            return false;
        } else {
            GoodsLang other = (GoodsLang)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label107: {
                    Object this$type = this.getType();
                    Object other$type = other.getType();
                    if (this$type == null) {
                        if (other$type == null) {
                            break label107;
                        }
                    } else if (this$type.equals(other$type)) {
                        break label107;
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

                Object this$goodId = this.getGoodId();
                Object other$goodId = other.getGoodId();
                if (this$goodId == null) {
                    if (other$goodId != null) {
                        return false;
                    }
                } else if (!this$goodId.equals(other$goodId)) {
                    return false;
                }

                label86: {
                    Object this$lang = this.getLang();
                    Object other$lang = other.getLang();
                    if (this$lang == null) {
                        if (other$lang == null) {
                            break label86;
                        }
                    } else if (this$lang.equals(other$lang)) {
                        break label86;
                    }

                    return false;
                }

                label79: {
                    Object this$unit = this.getUnit();
                    Object other$unit = other.getUnit();
                    if (this$unit == null) {
                        if (other$unit == null) {
                            break label79;
                        }
                    } else if (this$unit.equals(other$unit)) {
                        break label79;
                    }

                    return false;
                }

                label72: {
                    Object this$name = this.getName();
                    Object other$name = other.getName();
                    if (this$name == null) {
                        if (other$name == null) {
                            break label72;
                        }
                    } else if (this$name.equals(other$name)) {
                        break label72;
                    }

                    return false;
                }

                Object this$des = this.getDes();
                Object other$des = other.getDes();
                if (this$des == null) {
                    if (other$des != null) {
                        return false;
                    }
                } else if (!this$des.equals(other$des)) {
                    return false;
                }

                Object this$img_desc = this.getImg_desc();
                Object other$img_desc = other.getImg_desc();
                if (this$img_desc == null) {
                    if (other$img_desc != null) {
                        return false;
                    }
                } else if (!this$img_desc.equals(other$img_desc)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GoodsLang;
    }

    public int hashCode() {
        int result = 1;
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $goodId = this.getGoodId();
        result = result * 59 + ($goodId == null ? 43 : $goodId.hashCode());
        Object $lang = this.getLang();
        result = result * 59 + ($lang == null ? 43 : $lang.hashCode());
        Object $unit = this.getUnit();
        result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $des = this.getDes();
        result = result * 59 + ($des == null ? 43 : $des.hashCode());
        Object $img_desc = this.getImg_desc();
        result = result * 59 + ($img_desc == null ? 43 : $img_desc.hashCode());
        return result;
    }

    public String toString() {
        return "GoodsLang(id=" + this.getId() + ", goodId=" + this.getGoodId() + ", lang=" + this.getLang() + ", unit=" + this.getUnit() + ", name=" + this.getName() + ", des=" + this.getDes() + ", img_desc=" + this.getImg_desc() + ", type=" + this.getType() + ")";
    }
}
