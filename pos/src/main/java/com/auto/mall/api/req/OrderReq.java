

package com.auto.mall.api.req;

import java.io.Serializable;
import java.util.List;

public class OrderReq implements Serializable {
    private static final long serialVersionUID = 573145816239266985L;
    private String secret;
    private String partyId;
    private List<ItemReq> items;
    private String createUser;

    public OrderReq() {
    }

    public String getSecret() {
        return this.secret;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public List<ItemReq> getItems() {
        return this.items;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setSecret(final String secret) {
        this.secret = secret;
    }

    public void setPartyId(final String partyId) {
        this.partyId = partyId;
    }

    public void setItems(final List<ItemReq> items) {
        this.items = items;
    }

    public void setCreateUser(final String createUser) {
        this.createUser = createUser;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OrderReq)) {
            return false;
        } else {
            OrderReq other = (OrderReq)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$secret = this.getSecret();
                    Object other$secret = other.getSecret();
                    if (this$secret == null) {
                        if (other$secret == null) {
                            break label59;
                        }
                    } else if (this$secret.equals(other$secret)) {
                        break label59;
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

                Object this$items = this.getItems();
                Object other$items = other.getItems();
                if (this$items == null) {
                    if (other$items != null) {
                        return false;
                    }
                } else if (!this$items.equals(other$items)) {
                    return false;
                }

                Object this$createUser = this.getCreateUser();
                Object other$createUser = other.getCreateUser();
                if (this$createUser == null) {
                    if (other$createUser != null) {
                        return false;
                    }
                } else if (!this$createUser.equals(other$createUser)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OrderReq;
    }

    public int hashCode() {
        int result = 1;
        Object $secret = this.getSecret();
        result = result * 59 + ($secret == null ? 43 : $secret.hashCode());
        Object $partyId = this.getPartyId();
        result = result * 59 + ($partyId == null ? 43 : $partyId.hashCode());
        Object $items = this.getItems();
        result = result * 59 + ($items == null ? 43 : $items.hashCode());
        Object $createUser = this.getCreateUser();
        result = result * 59 + ($createUser == null ? 43 : $createUser.hashCode());
        return result;
    }

    public String toString() {
        return "OrderReq(secret=" + this.getSecret() + ", partyId=" + this.getPartyId() + ", items=" + this.getItems() + ", createUser=" + this.getCreateUser() + ")";
    }
}
