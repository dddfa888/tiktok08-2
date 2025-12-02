 

package com.auto.mall.api.req;

import cn.hutool.core.collection.CollectionUtil;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class GoodsReq implements Serializable {
    private static final long serialVersionUID = -5123352701056675374L;
    private String title;
    private String link;
    private String price;
    private String category;
    private List<String> img;
    private List<String> basic_info;
    private List<String> detail;
    private List<CommentReq> comments;

    public String detail_str() {
        if (CollectionUtil.isEmpty(this.detail)) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder();
            Iterator var2 = this.detail.iterator();

            while(var2.hasNext()) {
                String s = (String)var2.next();
                builder.append(s + ",");
            }

            return builder.toString();
        }
    }

    public String basic_info_str() {
        if (CollectionUtil.isEmpty(this.basic_info)) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder();
            Iterator var2 = this.basic_info.iterator();

            while(var2.hasNext()) {
                String s = (String)var2.next();
                builder.append(s + ",");
            }

            return builder.toString();
        }
    }

    public String toString() {
        return "GoodsReq{title='" + this.title + '\'' + ", price='" + this.price + '\'' + ", link='" + this.link + '\'' + ", category='" + this.category + '\'' + ", img=" + this.img + ", basic_info=" + this.basic_info + ", detail=" + this.detail + ", comments=" + this.comments + '}';
    }

    public GoodsReq() {
    }

    public String getTitle() {
        return this.title;
    }

    public String getLink() {
        return this.link;
    }

    public String getPrice() {
        return this.price;
    }

    public String getCategory() {
        return this.category;
    }

    public List<String> getImg() {
        return this.img;
    }

    public List<String> getBasic_info() {
        return this.basic_info;
    }

    public List<String> getDetail() {
        return this.detail;
    }

    public List<CommentReq> getComments() {
        return this.comments;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setLink(final String link) {
        this.link = link;
    }

    public void setPrice(final String price) {
        this.price = price;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public void setImg(final List<String> img) {
        this.img = img;
    }

    public void setBasic_info(final List<String> basic_info) {
        this.basic_info = basic_info;
    }

    public void setDetail(final List<String> detail) {
        this.detail = detail;
    }

    public void setComments(final List<CommentReq> comments) {
        this.comments = comments;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof GoodsReq)) {
            return false;
        } else {
            GoodsReq other = (GoodsReq)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label107: {
                    Object this$title = this.getTitle();
                    Object other$title = other.getTitle();
                    if (this$title == null) {
                        if (other$title == null) {
                            break label107;
                        }
                    } else if (this$title.equals(other$title)) {
                        break label107;
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

                Object this$price = this.getPrice();
                Object other$price = other.getPrice();
                if (this$price == null) {
                    if (other$price != null) {
                        return false;
                    }
                } else if (!this$price.equals(other$price)) {
                    return false;
                }

                label86: {
                    Object this$category = this.getCategory();
                    Object other$category = other.getCategory();
                    if (this$category == null) {
                        if (other$category == null) {
                            break label86;
                        }
                    } else if (this$category.equals(other$category)) {
                        break label86;
                    }

                    return false;
                }

                label79: {
                    Object this$img = this.getImg();
                    Object other$img = other.getImg();
                    if (this$img == null) {
                        if (other$img == null) {
                            break label79;
                        }
                    } else if (this$img.equals(other$img)) {
                        break label79;
                    }

                    return false;
                }

                label72: {
                    Object this$basic_info = this.getBasic_info();
                    Object other$basic_info = other.getBasic_info();
                    if (this$basic_info == null) {
                        if (other$basic_info == null) {
                            break label72;
                        }
                    } else if (this$basic_info.equals(other$basic_info)) {
                        break label72;
                    }

                    return false;
                }

                Object this$detail = this.getDetail();
                Object other$detail = other.getDetail();
                if (this$detail == null) {
                    if (other$detail != null) {
                        return false;
                    }
                } else if (!this$detail.equals(other$detail)) {
                    return false;
                }

                Object this$comments = this.getComments();
                Object other$comments = other.getComments();
                if (this$comments == null) {
                    if (other$comments != null) {
                        return false;
                    }
                } else if (!this$comments.equals(other$comments)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GoodsReq;
    }

    public int hashCode() {
        int result = 1;
        Object $title = this.getTitle();
        result = result * 59 + ($title == null ? 43 : $title.hashCode());
        Object $link = this.getLink();
        result = result * 59 + ($link == null ? 43 : $link.hashCode());
        Object $price = this.getPrice();
        result = result * 59 + ($price == null ? 43 : $price.hashCode());
        Object $category = this.getCategory();
        result = result * 59 + ($category == null ? 43 : $category.hashCode());
        Object $img = this.getImg();
        result = result * 59 + ($img == null ? 43 : $img.hashCode());
        Object $basic_info = this.getBasic_info();
        result = result * 59 + ($basic_info == null ? 43 : $basic_info.hashCode());
        Object $detail = this.getDetail();
        result = result * 59 + ($detail == null ? 43 : $detail.hashCode());
        Object $comments = this.getComments();
        result = result * 59 + ($comments == null ? 43 : $comments.hashCode());
        return result;
    }
}
