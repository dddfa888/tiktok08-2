 

package com.auto.mall.api.resp;

import java.io.Serializable;

public class CategoryResp implements Serializable {
    private String categoryId;
    private String categoryName;

    public CategoryResp() {
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CategoryResp)) {
            return false;
        } else {
            CategoryResp other = (CategoryResp)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$categoryId = this.getCategoryId();
                Object other$categoryId = other.getCategoryId();
                if (this$categoryId == null) {
                    if (other$categoryId != null) {
                        return false;
                    }
                } else if (!this$categoryId.equals(other$categoryId)) {
                    return false;
                }

                Object this$categoryName = this.getCategoryName();
                Object other$categoryName = other.getCategoryName();
                if (this$categoryName == null) {
                    if (other$categoryName != null) {
                        return false;
                    }
                } else if (!this$categoryName.equals(other$categoryName)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CategoryResp;
    }

    public int hashCode() {
          
        int result = 1;
        Object $categoryId = this.getCategoryId();
        result = result * 59 + ($categoryId == null ? 43 : $categoryId.hashCode());
        Object $categoryName = this.getCategoryName();
        result = result * 59 + ($categoryName == null ? 43 : $categoryName.hashCode());
        return result;
    }

    public String toString() {
        return "CategoryResp(categoryId=" + this.getCategoryId() + ", categoryName=" + this.getCategoryName() + ")";
    }
}
