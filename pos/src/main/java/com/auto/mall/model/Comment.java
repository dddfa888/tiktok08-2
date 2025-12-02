 

package com.auto.mall.model;

import com.auto.mall.api.req.CommentReq;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

@TableName("T_MALL_COMMENT")
public class Comment implements Serializable {
    private static final long serialVersionUID = 6045174050551552011L;
    @TableId(
            value = "uuid",
            type = IdType.UUID
    )
    private String id;
    @TableField("username")
    private String username;
    @TableField("category")
    private String category;
    @TableField("good_id")
    private String goodId;
    @TableField("content")
    private String content;
    @TableField("date")
    private String date;

    public Comment() {
    }

    public Comment(CommentReq req, String category, String goodId) {
        this.username = req.getUsername();
        this.goodId = goodId;
        this.category = category;
        this.content = req.getContent();
        this.date = req.getDate();
    }

    public String getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getCategory() {
        return this.category;
    }

    public String getGoodId() {
        return this.goodId;
    }

    public String getContent() {
        return this.content;
    }

    public String getDate() {
        return this.date;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public void setGoodId(final String goodId) {
        this.goodId = goodId;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public void setDate(final String date) {
        this.date = date;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Comment)) {
            return false;
        } else {
            Comment other = (Comment)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$username = this.getUsername();
                Object other$username = other.getUsername();
                if (this$username == null) {
                    if (other$username != null) {
                        return false;
                    }
                } else if (!this$username.equals(other$username)) {
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

                label62: {
                    Object this$goodId = this.getGoodId();
                    Object other$goodId = other.getGoodId();
                    if (this$goodId == null) {
                        if (other$goodId == null) {
                            break label62;
                        }
                    } else if (this$goodId.equals(other$goodId)) {
                        break label62;
                    }

                    return false;
                }

                label55: {
                    Object this$content = this.getContent();
                    Object other$content = other.getContent();
                    if (this$content == null) {
                        if (other$content == null) {
                            break label55;
                        }
                    } else if (this$content.equals(other$content)) {
                        break label55;
                    }

                    return false;
                }

                Object this$date = this.getDate();
                Object other$date = other.getDate();
                if (this$date == null) {
                    if (other$date != null) {
                        return false;
                    }
                } else if (!this$date.equals(other$date)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Comment;
    }

    public int hashCode() {
          
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $username = this.getUsername();
        result = result * 59 + ($username == null ? 43 : $username.hashCode());
        Object $category = this.getCategory();
        result = result * 59 + ($category == null ? 43 : $category.hashCode());
        Object $goodId = this.getGoodId();
        result = result * 59 + ($goodId == null ? 43 : $goodId.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        Object $date = this.getDate();
        result = result * 59 + ($date == null ? 43 : $date.hashCode());
        return result;
    }

    public String toString() {
        return "Comment(id=" + this.getId() + ", username=" + this.getUsername() + ", category=" + this.getCategory() + ", goodId=" + this.getGoodId() + ", content=" + this.getContent() + ", date=" + this.getDate() + ")";
    }
}
