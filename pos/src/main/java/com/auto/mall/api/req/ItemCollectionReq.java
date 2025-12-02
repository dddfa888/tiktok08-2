 

package com.auto.mall.api.req;

import java.io.Serializable;

public class ItemCollectionReq implements Serializable {
    private static final long serialVersionUID = -4291495858496158982L;
    private String url;
    private String category;

    public ItemCollectionReq() {
    }

    public ItemCollectionReq(String url, String category) {
        this.url = url;
        this.category = category;
    }

    public String getUrl() {
        return this.url;
    }

    public String getCategory() {
        return this.category;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ItemCollectionReq)) {
            return false;
        } else {
            ItemCollectionReq other = (ItemCollectionReq)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$url = this.getUrl();
                Object other$url = other.getUrl();
                if (this$url == null) {
                    if (other$url != null) {
                        return false;
                    }
                } else if (!this$url.equals(other$url)) {
                    return false;
                }

                Object this$category = this.getCategory();
                Object other$category = other.getCategory();
                if (this$category == null) {
                    if (other$category != null) {
                        return false;
                    }
                } else if (!this$category.equals(other$category)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ItemCollectionReq;
    }

    public int hashCode() {
        int result = 1;
        Object $url = this.getUrl();
        result = result * 59 + ($url == null ? 43 : $url.hashCode());
        Object $category = this.getCategory();
        result = result * 59 + ($category == null ? 43 : $category.hashCode());
        return result;
    }

    public String toString() {
        return "ItemCollectionReq(url=" + this.getUrl() + ", category=" + this.getCategory() + ")";
    }
}
