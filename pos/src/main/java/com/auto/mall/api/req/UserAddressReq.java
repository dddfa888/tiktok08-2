 

package com.auto.mall.api.req;

import java.io.Serializable;

public class UserAddressReq implements Serializable {
    private static final long serialVersionUID = -5587107986675583725L;
    private String userAddressId;

    public UserAddressReq() {
    }

    public String getUserAddressId() {
        return this.userAddressId;
    }

    public void setUserAddressId(final String userAddressId) {
        this.userAddressId = userAddressId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UserAddressReq)) {
            return false;
        } else {
            UserAddressReq other = (UserAddressReq)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
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
        return other instanceof UserAddressReq;
    }

    public int hashCode() {
          
        int result = 1;
        Object $userAddressId = this.getUserAddressId();
        result = result * 59 + ($userAddressId == null ? 43 : $userAddressId.hashCode());
        return result;
    }

    public String toString() {
        return "UserAddressReq(userAddressId=" + this.getUserAddressId() + ")";
    }
}
