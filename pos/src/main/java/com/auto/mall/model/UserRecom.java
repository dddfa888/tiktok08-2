 

package com.auto.mall.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

@TableName("PAT_USER_RECOM")
public class UserRecom implements Serializable {
    private static final long serialVersionUID = 2418749548542538512L;
    @TableId("uuid")
    private String uuid;
    @TableField("party_id")
    private String partyId;
    @TableField("reco_id")
    private String recoId;

    public UserRecom() {
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public String getRecoId() {
        return this.recoId;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }

    public void setPartyId(final String partyId) {
        this.partyId = partyId;
    }

    public void setRecoId(final String recoId) {
        this.recoId = recoId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UserRecom)) {
            return false;
        } else {
            UserRecom other = (UserRecom)o;
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

                Object this$partyId = this.getPartyId();
                Object other$partyId = other.getPartyId();
                if (this$partyId == null) {
                    if (other$partyId != null) {
                        return false;
                    }
                } else if (!this$partyId.equals(other$partyId)) {
                    return false;
                }

                Object this$recoId = this.getRecoId();
                Object other$recoId = other.getRecoId();
                if (this$recoId == null) {
                    if (other$recoId != null) {
                        return false;
                    }
                } else if (!this$recoId.equals(other$recoId)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserRecom;
    }

    public int hashCode() {
          
        int result = 1;
        Object $uuid = this.getUuid();
        result = result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
        Object $partyId = this.getPartyId();
        result = result * 59 + ($partyId == null ? 43 : $partyId.hashCode());
        Object $recoId = this.getRecoId();
        result = result * 59 + ($recoId == null ? 43 : $recoId.hashCode());
        return result;
    }

    public String toString() {
        return "UserRecom(uuid=" + this.getUuid() + ", partyId=" + this.getPartyId() + ", recoId=" + this.getRecoId() + ")";
    }
}
