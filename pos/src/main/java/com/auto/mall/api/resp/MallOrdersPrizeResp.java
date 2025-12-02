 

package com.auto.mall.api.resp;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MallOrdersPrizeResp implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String partyId;
    private String sellerId;
    private String sellerName;
    private LocalDateTime createTime;
    private String address;
    private String contacts;

    public MallOrdersPrizeResp() {
    }

    public String getId() {
        return this.id;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public String getSellerId() {
        return this.sellerId;
    }

    public String getSellerName() {
        return this.sellerName;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public String getAddress() {
        return this.address;
    }

    public String getContacts() {
        return this.contacts;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setPartyId(final String partyId) {
        this.partyId = partyId;
    }

    public void setSellerId(final String sellerId) {
        this.sellerId = sellerId;
    }

    public void setSellerName(final String sellerName) {
        this.sellerName = sellerName;
    }

    public void setCreateTime(final LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public void setContacts(final String contacts) {
        this.contacts = contacts;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MallOrdersPrizeResp)) {
            return false;
        } else {
            MallOrdersPrizeResp other = (MallOrdersPrizeResp)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label95: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label95;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label95;
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

                Object this$sellerId = this.getSellerId();
                Object other$sellerId = other.getSellerId();
                if (this$sellerId == null) {
                    if (other$sellerId != null) {
                        return false;
                    }
                } else if (!this$sellerId.equals(other$sellerId)) {
                    return false;
                }

                label74: {
                    Object this$sellerName = this.getSellerName();
                    Object other$sellerName = other.getSellerName();
                    if (this$sellerName == null) {
                        if (other$sellerName == null) {
                            break label74;
                        }
                    } else if (this$sellerName.equals(other$sellerName)) {
                        break label74;
                    }

                    return false;
                }

                label67: {
                    Object this$createTime = this.getCreateTime();
                    Object other$createTime = other.getCreateTime();
                    if (this$createTime == null) {
                        if (other$createTime == null) {
                            break label67;
                        }
                    } else if (this$createTime.equals(other$createTime)) {
                        break label67;
                    }

                    return false;
                }

                Object this$address = this.getAddress();
                Object other$address = other.getAddress();
                if (this$address == null) {
                    if (other$address != null) {
                        return false;
                    }
                } else if (!this$address.equals(other$address)) {
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

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MallOrdersPrizeResp;
    }

    public int hashCode() {
          
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $partyId = this.getPartyId();
        result = result * 59 + ($partyId == null ? 43 : $partyId.hashCode());
        Object $sellerId = this.getSellerId();
        result = result * 59 + ($sellerId == null ? 43 : $sellerId.hashCode());
        Object $sellerName = this.getSellerName();
        result = result * 59 + ($sellerName == null ? 43 : $sellerName.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $address = this.getAddress();
        result = result * 59 + ($address == null ? 43 : $address.hashCode());
        Object $contacts = this.getContacts();
        result = result * 59 + ($contacts == null ? 43 : $contacts.hashCode());
        return result;
    }

    public String toString() {
        return "MallOrdersPrizeResp(id=" + this.getId() + ", partyId=" + this.getPartyId() + ", sellerId=" + this.getSellerId() + ", sellerName=" + this.getSellerName() + ", createTime=" + this.getCreateTime() + ", address=" + this.getAddress() + ", contacts=" + this.getContacts() + ")";
    }
}
