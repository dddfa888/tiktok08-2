

package com.auto.mall.api.req;

import java.io.Serializable;

public class CommentReq implements Serializable {
    private static final long serialVersionUID = 4116655160304145142L;
    private String username;
    private String date;
    private String content;

    public CommentReq() {
    }

    public String getUsername() {
        return this.username;
    }

    public String getDate() {
        return this.date;
    }

    public String getContent() {
        return this.content;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setDate(final String date) {
        this.date = date;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CommentReq)) {
            return false;
        } else {
            CommentReq other = (CommentReq)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$username = this.getUsername();
                    Object other$username = other.getUsername();
                    if (this$username == null) {
                        if (other$username == null) {
                            break label47;
                        }
                    } else if (this$username.equals(other$username)) {
                        break label47;
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

                Object this$content = this.getContent();
                Object other$content = other.getContent();
                if (this$content == null) {
                    if (other$content != null) {
                        return false;
                    }
                } else if (!this$content.equals(other$content)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CommentReq;
    }

    public int hashCode() {

        int result = 1;
        Object $username = this.getUsername();
        result = result * 59 + ($username == null ? 43 : $username.hashCode());
        Object $date = this.getDate();
        result = result * 59 + ($date == null ? 43 : $date.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        return result;
    }

    public String toString() {
        return "CommentReq(username=" + this.getUsername() + ", date=" + this.getDate() + ", content=" + this.getContent() + ")";
    }
}
