 

package com.auto.mall.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

@TableName("PAT_PARTY")
public class PatParty implements Serializable {
    @TableId("UUID")
    private String uuid;
    @TableField("USERNAME")
    private String username;
    @TableField("ROLENAME")
    private String roleName;

    public PatParty() {
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getUsername() {
        return this.username;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PatParty)) {
            return false;
        } else {
            PatParty other = (PatParty)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$uuid = this.getUuid();
                    Object other$uuid = other.getUuid();
                    if (this$uuid == null) {
                        if (other$uuid == null) {
                            break label47;
                        }
                    } else if (this$uuid.equals(other$uuid)) {
                        break label47;
                    }

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

                Object this$roleName = this.getRoleName();
                Object other$roleName = other.getRoleName();
                if (this$roleName == null) {
                    if (other$roleName != null) {
                        return false;
                    }
                } else if (!this$roleName.equals(other$roleName)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PatParty;
    }

    public int hashCode() {
          
        int result = 1;
        Object $uuid = this.getUuid();
        result = result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
        Object $username = this.getUsername();
        result = result * 59 + ($username == null ? 43 : $username.hashCode());
        Object $roleName = this.getRoleName();
        result = result * 59 + ($roleName == null ? 43 : $roleName.hashCode());
        return result;
    }

    public String toString() {
        return "PatParty(uuid=" + this.getUuid() + ", username=" + this.getUsername() + ", roleName=" + this.getRoleName() + ")";
    }
}
