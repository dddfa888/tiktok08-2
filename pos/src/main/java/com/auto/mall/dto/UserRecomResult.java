 

package com.auto.mall.dto;

import java.io.Serializable;

public class UserRecomResult implements Serializable {
    private String id;
    private String reco_id;
    private String partyId;

    public UserRecomResult() {
    }

    public String getId() {
        return this.id;
    }

    public String getReco_id() {
        return this.reco_id;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setReco_id(final String reco_id) {
        this.reco_id = reco_id;
    }

    public void setPartyId(final String partyId) {
        this.partyId = partyId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UserRecomResult)) {
            return false;
        } else {
            UserRecomResult other = (UserRecomResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label47;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label47;
                    }

                    return false;
                }

                Object this$reco_id = this.getReco_id();
                Object other$reco_id = other.getReco_id();
                if (this$reco_id == null) {
                    if (other$reco_id != null) {
                        return false;
                    }
                } else if (!this$reco_id.equals(other$reco_id)) {
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

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserRecomResult;
    }

    public int hashCode() {
          
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $reco_id = this.getReco_id();
        result = result * 59 + ($reco_id == null ? 43 : $reco_id.hashCode());
        Object $partyId = this.getPartyId();
        result = result * 59 + ($partyId == null ? 43 : $partyId.hashCode());
        return result;
    }

    public String toString() {
        return "UserRecomResult(id=" + this.getId() + ", reco_id=" + this.getReco_id() + ", partyId=" + this.getPartyId() + ")";
    }
}
