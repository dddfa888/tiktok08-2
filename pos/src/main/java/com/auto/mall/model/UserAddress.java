 

package com.auto.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

@TableName("T_MALL_USERADDRESS")
public class UserAddress {
    @TableId(
            value = "UUID",
            type = IdType.UUID
    )
    private String id;
    @TableField("PARTY_ID")
    private String partyId;
    @TableField("STATUS")
    private Integer status;
    @TableField("PHONE")
    private String phone;
    @TableField("EMAIL")
    private String email;
    @TableField("CONTACTS")
    private String contacts;
    @TableField("POSTCODE")
    private String postCode;
    @TableField("COUNTRY")
    private String country;
    @TableField("PROVINCE")
    private String province;
    @TableField("CITY")
    private String city;
    @TableField("ADDRESS")
    private String address;
    @TableField("CREATE_TIME")
    private Date createTime;

    public UserAddress() {
    }

    public String getId() {
        return this.id;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getContacts() {
        return this.contacts;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public String getCountry() {
        return this.country;
    }

    public String getProvince() {
        return this.province;
    }

    public String getCity() {
        return this.city;
    }

    public String getAddress() {
        return this.address;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setPartyId(final String partyId) {
        this.partyId = partyId;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setContacts(final String contacts) {
        this.contacts = contacts;
    }

    public void setPostCode(final String postCode) {
        this.postCode = postCode;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public void setProvince(final String province) {
        this.province = province;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UserAddress)) {
            return false;
        } else {
            UserAddress other = (UserAddress)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label155: {
                    Object this$status = this.getStatus();
                    Object other$status = other.getStatus();
                    if (this$status == null) {
                        if (other$status == null) {
                            break label155;
                        }
                    } else if (this$status.equals(other$status)) {
                        break label155;
                    }

                    return false;
                }

                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
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

                label134: {
                    Object this$phone = this.getPhone();
                    Object other$phone = other.getPhone();
                    if (this$phone == null) {
                        if (other$phone == null) {
                            break label134;
                        }
                    } else if (this$phone.equals(other$phone)) {
                        break label134;
                    }

                    return false;
                }

                label127: {
                    Object this$email = this.getEmail();
                    Object other$email = other.getEmail();
                    if (this$email == null) {
                        if (other$email == null) {
                            break label127;
                        }
                    } else if (this$email.equals(other$email)) {
                        break label127;
                    }

                    return false;
                }

                label120: {
                    Object this$contacts = this.getContacts();
                    Object other$contacts = other.getContacts();
                    if (this$contacts == null) {
                        if (other$contacts == null) {
                            break label120;
                        }
                    } else if (this$contacts.equals(other$contacts)) {
                        break label120;
                    }

                    return false;
                }

                Object this$postCode = this.getPostCode();
                Object other$postCode = other.getPostCode();
                if (this$postCode == null) {
                    if (other$postCode != null) {
                        return false;
                    }
                } else if (!this$postCode.equals(other$postCode)) {
                    return false;
                }

                label106: {
                    Object this$country = this.getCountry();
                    Object other$country = other.getCountry();
                    if (this$country == null) {
                        if (other$country == null) {
                            break label106;
                        }
                    } else if (this$country.equals(other$country)) {
                        break label106;
                    }

                    return false;
                }

                Object this$province = this.getProvince();
                Object other$province = other.getProvince();
                if (this$province == null) {
                    if (other$province != null) {
                        return false;
                    }
                } else if (!this$province.equals(other$province)) {
                    return false;
                }

                label92: {
                    Object this$city = this.getCity();
                    Object other$city = other.getCity();
                    if (this$city == null) {
                        if (other$city == null) {
                            break label92;
                        }
                    } else if (this$city.equals(other$city)) {
                        break label92;
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

                Object this$createTime = this.getCreateTime();
                Object other$createTime = other.getCreateTime();
                if (this$createTime == null) {
                    if (other$createTime != null) {
                        return false;
                    }
                } else if (!this$createTime.equals(other$createTime)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserAddress;
    }

    public int hashCode() {
          
        int result = 1;
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $partyId = this.getPartyId();
        result = result * 59 + ($partyId == null ? 43 : $partyId.hashCode());
        Object $phone = this.getPhone();
        result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
        Object $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        Object $contacts = this.getContacts();
        result = result * 59 + ($contacts == null ? 43 : $contacts.hashCode());
        Object $postCode = this.getPostCode();
        result = result * 59 + ($postCode == null ? 43 : $postCode.hashCode());
        Object $country = this.getCountry();
        result = result * 59 + ($country == null ? 43 : $country.hashCode());
        Object $province = this.getProvince();
        result = result * 59 + ($province == null ? 43 : $province.hashCode());
        Object $city = this.getCity();
        result = result * 59 + ($city == null ? 43 : $city.hashCode());
        Object $address = this.getAddress();
        result = result * 59 + ($address == null ? 43 : $address.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        return result;
    }

    public String toString() {
        return "UserAddress(id=" + this.getId() + ", partyId=" + this.getPartyId() + ", status=" + this.getStatus() + ", phone=" + this.getPhone() + ", email=" + this.getEmail() + ", contacts=" + this.getContacts() + ", postCode=" + this.getPostCode() + ", country=" + this.getCountry() + ", province=" + this.getProvince() + ", city=" + this.getCity() + ", address=" + this.getAddress() + ", createTime=" + this.getCreateTime() + ")";
    }
}
