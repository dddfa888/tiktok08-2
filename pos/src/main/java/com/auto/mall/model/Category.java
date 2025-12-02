 

package com.auto.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

@TableName("T_MALL_CATEGORY")
public class Category implements Serializable {
    private static final long serialVersionUID = 6045174050551552011L;
    @TableId(
            value = "UUID",
            type = IdType.UUID
    )
    private String id;
    @TableField("SORT")
    private Integer sort;
    @TableField("ICON_IMG")
    private String iconImg;
    @TableField("REC_TIME")
    private long recTime;
    @TableField("CREATE_TIME")
    private Date createTime;
    @TableField("STATUS")
    private String status;

    public Category() {
    }

    public String getId() {
        return this.id;
    }

    public Integer getSort() {
        return this.sort;
    }

    public String getIconImg() {
        return this.iconImg;
    }

    public long getRecTime() {
        return this.recTime;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public String getStatus() {
        return this.status;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setSort(final Integer sort) {
        this.sort = sort;
    }

    public void setIconImg(final String iconImg) {
        this.iconImg = iconImg;
    }

    public void setRecTime(final long recTime) {
        this.recTime = recTime;
    }

    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Category)) {
            return false;
        } else {
            Category other = (Category)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getRecTime() != other.getRecTime()) {
                return false;
            } else {
                label73: {
                    Object this$sort = this.getSort();
                    Object other$sort = other.getSort();
                    if (this$sort == null) {
                        if (other$sort == null) {
                            break label73;
                        }
                    } else if (this$sort.equals(other$sort)) {
                        break label73;
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

                label59: {
                    Object this$iconImg = this.getIconImg();
                    Object other$iconImg = other.getIconImg();
                    if (this$iconImg == null) {
                        if (other$iconImg == null) {
                            break label59;
                        }
                    } else if (this$iconImg.equals(other$iconImg)) {
                        break label59;
                    }

                    return false;
                }

                Object this$createTime = this.getCreateTime();
                Object other$createTime = other.getCreateTime();
                if (this$createTime == null) {
                    if (other$createTime != null) {
                        return false;
                    }
                } else if (!this$createTime.equals(other$createTime)) {
                    return false;
                }

                Object this$status = this.getStatus();
                Object other$status = other.getStatus();
                if (this$status == null) {
                    if (other$status != null) {
                        return false;
                    }
                } else if (!this$status.equals(other$status)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Category;
    }

    public int hashCode() {
          
        int result = 1;
        long $recTime = this.getRecTime();
        result = result * 59 + (int)($recTime >>> 32 ^ $recTime);
        Object $sort = this.getSort();
        result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $iconImg = this.getIconImg();
        result = result * 59 + ($iconImg == null ? 43 : $iconImg.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    public String toString() {
        return "Category(id=" + this.getId() + ", sort=" + this.getSort() + ", iconImg=" + this.getIconImg() + ", recTime=" + this.getRecTime() + ", createTime=" + this.getCreateTime() + ", status=" + this.getStatus() + ")";
    }
}
