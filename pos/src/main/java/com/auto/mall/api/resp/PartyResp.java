 

package com.auto.mall.api.resp;

import java.io.Serializable;

public class PartyResp implements Serializable {
    private static final long serialVersionUID = 5510845374811485958L;
    private String partyId;
    private String contacts;
    private String userAddressId;

    public PartyResp() {
    }

    public String getPartyId() {
        return this.partyId;
    }

    public String getContacts() {
        return this.contacts;
    }

    public String getUserAddressId() {
        return this.userAddressId;
    }

    public void setPartyId(final String partyId) {
        this.partyId = partyId;
    }

    public void setContacts(final String contacts) {
        this.contacts = contacts;
    }

    public void setUserAddressId(final String userAddressId) {
        this.userAddressId = userAddressId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PartyResp)) {
            return false;
        } else {
            PartyResp other = (PartyResp)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$partyId = this.getPartyId();
                    Object other$partyId = other.getPartyId();
                    if (this$partyId == null) {
                        if (other$partyId == null) {
                            break label47;
                        }
                    } else if (this$partyId.equals(other$partyId)) {
                        break label47;
                    }

                    return false;
                }

                Object this$contacts = this.getContacts();
                Object other$contacts = other.getContacts();
                if (this$contacts == null) {
                    if (other$contacts != null) {
                        return false;
                    }
                } else if (!this$contacts.equals(other$contacts)) {
                    return false;
                }

                Object this$userAddressId = this.getUserAddressId();
                Object other$userAddressId = other.getUserAddressId();
                if (this$userAddressId == null) {
                    if (other$userAddressId != null) {
                        return false;
                    }
                } else if (!this$userAddressId.equals(other$userAddressId)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PartyResp;
    }

    public int hashCode() {
          
        int result = 1;
        Object $partyId = this.getPartyId();
        result = result * 59 + ($partyId == null ? 43 : $partyId.hashCode());
        Object $contacts = this.getContacts();
        result = result * 59 + ($contacts == null ? 43 : $contacts.hashCode());
        Object $userAddressId = this.getUserAddressId();
        result = result * 59 + ($userAddressId == null ? 43 : $userAddressId.hashCode());
        return result;
    }

    public String toString() {
        return "PartyResp(partyId=" + this.getPartyId() + ", contacts=" + this.getContacts() + ", userAddressId=" + this.getUserAddressId() + ")";
    }
}
