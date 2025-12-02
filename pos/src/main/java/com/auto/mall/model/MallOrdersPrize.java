 

package com.auto.mall.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

@TableName("T_MALL_ORDERS_PRIZE")
public class MallOrdersPrize implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId("UUID")
    private String id;
    @TableField("PARTY_ID")
    private String partyId;
    @TableField("USER_CODE")
    private String userCode;
    @TableField("SELLER_ID")
    private String sellerId;
    @TableField("PRIZE_ORIGINAL")
    private Object prizeOriginal;
    @TableField("SELLER_NAME")
    private String sellerName;
    @TableField("GOODS__COUNT")
    private Integer goodsCount;
    @TableField("PRIZE_REAL")
    private Object prizeReal;
    @TableField("SYSTEM_PRICE")
    private Object systemPrice;
    @TableField("STATUS")
    private Integer status;
    @TableField("RETURN_STATUS")
    private Integer returnStatus;
    @TableField("ORDER_STATUS")
    private Integer orderStatus;
    @TableField("FEES")
    private Object fees;
    @TableField("TAX")
    private Object tax;
    @TableField("PROFIT")
    private Object profit;
    @TableField("PAY_STATUS")
    private Integer payStatus;
    @TableField("UP_TIME")
    private Long upTime;
    @TableField("CREATE_TIME")
    private Date createTime;
    @TableField("PHONE")
    private String phone;
    @TableField("EMAIL")
    private String email;
    @TableField("CONTACTS")
    private String contacts;
    @TableField("POSTCODE")
    private String postcode;
    @TableField("COUNTRY")
    private String country;
    @TableField("PROVINCE")
    private String province;
    @TableField("CITY")
    private String city;
    @TableField("ADDRESS")
    private String address;
    @TableField("PROFIT_STATUS")
    private Integer profitStatus;
    @TableField("PURCH_STATUS")
    private Integer purchStatus;
    @TableField("REFUND_REMARK")
    private String refundRemark;
    @TableField("RETURN_REASON")
    private String returnReason;
    @TableField("RETURN_DETAIL")
    private String returnDetail;

    public MallOrdersPrize() {
    }

    public String getId() {
        return this.id;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public String getSellerId() {
        return this.sellerId;
    }

    public Object getPrizeOriginal() {
        return this.prizeOriginal;
    }

    public String getSellerName() {
        return this.sellerName;
    }

    public Integer getGoodsCount() {
        return this.goodsCount;
    }

    public Object getPrizeReal() {
        return this.prizeReal;
    }

    public Object getSystemPrice() {
        return this.systemPrice;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Integer getReturnStatus() {
        return this.returnStatus;
    }

    public Integer getOrderStatus() {
        return this.orderStatus;
    }

    public Object getFees() {
        return this.fees;
    }

    public Object getTax() {
        return this.tax;
    }

    public Object getProfit() {
        return this.profit;
    }

    public Integer getPayStatus() {
        return this.payStatus;
    }

    public Long getUpTime() {
        return this.upTime;
    }

    public Date getCreateTime() {
        return this.createTime;
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

    public String getPostcode() {
        return this.postcode;
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

    public Integer getProfitStatus() {
        return this.profitStatus;
    }

    public Integer getPurchStatus() {
        return this.purchStatus;
    }

    public String getRefundRemark() {
        return this.refundRemark;
    }

    public String getReturnReason() {
        return this.returnReason;
    }

    public String getReturnDetail() {
        return this.returnDetail;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setPartyId(final String partyId) {
        this.partyId = partyId;
    }

    public void setUserCode(final String userCode) {
        this.userCode = userCode;
    }

    public void setSellerId(final String sellerId) {
        this.sellerId = sellerId;
    }

    public void setPrizeOriginal(final Object prizeOriginal) {
        this.prizeOriginal = prizeOriginal;
    }

    public void setSellerName(final String sellerName) {
        this.sellerName = sellerName;
    }

    public void setGoodsCount(final Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public void setPrizeReal(final Object prizeReal) {
        this.prizeReal = prizeReal;
    }

    public void setSystemPrice(final Object systemPrice) {
        this.systemPrice = systemPrice;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }

    public void setReturnStatus(final Integer returnStatus) {
        this.returnStatus = returnStatus;
    }

    public void setOrderStatus(final Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setFees(final Object fees) {
        this.fees = fees;
    }

    public void setTax(final Object tax) {
        this.tax = tax;
    }

    public void setProfit(final Object profit) {
        this.profit = profit;
    }

    public void setPayStatus(final Integer payStatus) {
        this.payStatus = payStatus;
    }

    public void setUpTime(final Long upTime) {
        this.upTime = upTime;
    }

    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
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

    public void setPostcode(final String postcode) {
        this.postcode = postcode;
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

    public void setProfitStatus(final Integer profitStatus) {
        this.profitStatus = profitStatus;
    }

    public void setPurchStatus(final Integer purchStatus) {
        this.purchStatus = purchStatus;
    }

    public void setRefundRemark(final String refundRemark) {
        this.refundRemark = refundRemark;
    }

    public void setReturnReason(final String returnReason) {
        this.returnReason = returnReason;
    }

    public void setReturnDetail(final String returnDetail) {
        this.returnDetail = returnDetail;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MallOrdersPrize)) {
            return false;
        } else {
            MallOrdersPrize other = (MallOrdersPrize)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label383: {
                    Object this$goodsCount = this.getGoodsCount();
                    Object other$goodsCount = other.getGoodsCount();
                    if (this$goodsCount == null) {
                        if (other$goodsCount == null) {
                            break label383;
                        }
                    } else if (this$goodsCount.equals(other$goodsCount)) {
                        break label383;
                    }

                    return false;
                }

                Object this$status = this.getStatus();
                Object other$status = other.getStatus();
                if (this$status == null) {
                    if (other$status != null) {
                        return false;
                    }
                } else if (!this$status.equals(other$status)) {
                    return false;
                }

                Object this$returnStatus = this.getReturnStatus();
                Object other$returnStatus = other.getReturnStatus();
                if (this$returnStatus == null) {
                    if (other$returnStatus != null) {
                        return false;
                    }
                } else if (!this$returnStatus.equals(other$returnStatus)) {
                    return false;
                }

                label362: {
                    Object this$orderStatus = this.getOrderStatus();
                    Object other$orderStatus = other.getOrderStatus();
                    if (this$orderStatus == null) {
                        if (other$orderStatus == null) {
                            break label362;
                        }
                    } else if (this$orderStatus.equals(other$orderStatus)) {
                        break label362;
                    }

                    return false;
                }

                label355: {
                    Object this$payStatus = this.getPayStatus();
                    Object other$payStatus = other.getPayStatus();
                    if (this$payStatus == null) {
                        if (other$payStatus == null) {
                            break label355;
                        }
                    } else if (this$payStatus.equals(other$payStatus)) {
                        break label355;
                    }

                    return false;
                }

                Object this$upTime = this.getUpTime();
                Object other$upTime = other.getUpTime();
                if (this$upTime == null) {
                    if (other$upTime != null) {
                        return false;
                    }
                } else if (!this$upTime.equals(other$upTime)) {
                    return false;
                }

                Object this$profitStatus = this.getProfitStatus();
                Object other$profitStatus = other.getProfitStatus();
                if (this$profitStatus == null) {
                    if (other$profitStatus != null) {
                        return false;
                    }
                } else if (!this$profitStatus.equals(other$profitStatus)) {
                    return false;
                }

                label334: {
                    Object this$purchStatus = this.getPurchStatus();
                    Object other$purchStatus = other.getPurchStatus();
                    if (this$purchStatus == null) {
                        if (other$purchStatus == null) {
                            break label334;
                        }
                    } else if (this$purchStatus.equals(other$purchStatus)) {
                        break label334;
                    }

                    return false;
                }

                label327: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label327;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label327;
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

                label313: {
                    Object this$userCode = this.getUserCode();
                    Object other$userCode = other.getUserCode();
                    if (this$userCode == null) {
                        if (other$userCode == null) {
                            break label313;
                        }
                    } else if (this$userCode.equals(other$userCode)) {
                        break label313;
                    }

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

                label299: {
                    Object this$prizeOriginal = this.getPrizeOriginal();
                    Object other$prizeOriginal = other.getPrizeOriginal();
                    if (this$prizeOriginal == null) {
                        if (other$prizeOriginal == null) {
                            break label299;
                        }
                    } else if (this$prizeOriginal.equals(other$prizeOriginal)) {
                        break label299;
                    }

                    return false;
                }

                Object this$sellerName = this.getSellerName();
                Object other$sellerName = other.getSellerName();
                if (this$sellerName == null) {
                    if (other$sellerName != null) {
                        return false;
                    }
                } else if (!this$sellerName.equals(other$sellerName)) {
                    return false;
                }

                Object this$prizeReal = this.getPrizeReal();
                Object other$prizeReal = other.getPrizeReal();
                if (this$prizeReal == null) {
                    if (other$prizeReal != null) {
                        return false;
                    }
                } else if (!this$prizeReal.equals(other$prizeReal)) {
                    return false;
                }

                label278: {
                    Object this$systemPrice = this.getSystemPrice();
                    Object other$systemPrice = other.getSystemPrice();
                    if (this$systemPrice == null) {
                        if (other$systemPrice == null) {
                            break label278;
                        }
                    } else if (this$systemPrice.equals(other$systemPrice)) {
                        break label278;
                    }

                    return false;
                }

                label271: {
                    Object this$fees = this.getFees();
                    Object other$fees = other.getFees();
                    if (this$fees == null) {
                        if (other$fees == null) {
                            break label271;
                        }
                    } else if (this$fees.equals(other$fees)) {
                        break label271;
                    }

                    return false;
                }

                Object this$tax = this.getTax();
                Object other$tax = other.getTax();
                if (this$tax == null) {
                    if (other$tax != null) {
                        return false;
                    }
                } else if (!this$tax.equals(other$tax)) {
                    return false;
                }

                Object this$profit = this.getProfit();
                Object other$profit = other.getProfit();
                if (this$profit == null) {
                    if (other$profit != null) {
                        return false;
                    }
                } else if (!this$profit.equals(other$profit)) {
                    return false;
                }

                label250: {
                    Object this$createTime = this.getCreateTime();
                    Object other$createTime = other.getCreateTime();
                    if (this$createTime == null) {
                        if (other$createTime == null) {
                            break label250;
                        }
                    } else if (this$createTime.equals(other$createTime)) {
                        break label250;
                    }

                    return false;
                }

                label243: {
                    Object this$phone = this.getPhone();
                    Object other$phone = other.getPhone();
                    if (this$phone == null) {
                        if (other$phone == null) {
                            break label243;
                        }
                    } else if (this$phone.equals(other$phone)) {
                        break label243;
                    }

                    return false;
                }

                Object this$email = this.getEmail();
                Object other$email = other.getEmail();
                if (this$email == null) {
                    if (other$email != null) {
                        return false;
                    }
                } else if (!this$email.equals(other$email)) {
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

                label222: {
                    Object this$postcode = this.getPostcode();
                    Object other$postcode = other.getPostcode();
                    if (this$postcode == null) {
                        if (other$postcode == null) {
                            break label222;
                        }
                    } else if (this$postcode.equals(other$postcode)) {
                        break label222;
                    }

                    return false;
                }

                label215: {
                    Object this$country = this.getCountry();
                    Object other$country = other.getCountry();
                    if (this$country == null) {
                        if (other$country == null) {
                            break label215;
                        }
                    } else if (this$country.equals(other$country)) {
                        break label215;
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

                label201: {
                    Object this$city = this.getCity();
                    Object other$city = other.getCity();
                    if (this$city == null) {
                        if (other$city == null) {
                            break label201;
                        }
                    } else if (this$city.equals(other$city)) {
                        break label201;
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

                label187: {
                    Object this$refundRemark = this.getRefundRemark();
                    Object other$refundRemark = other.getRefundRemark();
                    if (this$refundRemark == null) {
                        if (other$refundRemark == null) {
                            break label187;
                        }
                    } else if (this$refundRemark.equals(other$refundRemark)) {
                        break label187;
                    }

                    return false;
                }

                Object this$returnReason = this.getReturnReason();
                Object other$returnReason = other.getReturnReason();
                if (this$returnReason == null) {
                    if (other$returnReason != null) {
                        return false;
                    }
                } else if (!this$returnReason.equals(other$returnReason)) {
                    return false;
                }

                Object this$returnDetail = this.getReturnDetail();
                Object other$returnDetail = other.getReturnDetail();
                if (this$returnDetail == null) {
                    if (other$returnDetail != null) {
                        return false;
                    }
                } else if (!this$returnDetail.equals(other$returnDetail)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MallOrdersPrize;
    }

    public int hashCode() {
          
        int result = 1;
        Object $goodsCount = this.getGoodsCount();
        result = result * 59 + ($goodsCount == null ? 43 : $goodsCount.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $returnStatus = this.getReturnStatus();
        result = result * 59 + ($returnStatus == null ? 43 : $returnStatus.hashCode());
        Object $orderStatus = this.getOrderStatus();
        result = result * 59 + ($orderStatus == null ? 43 : $orderStatus.hashCode());
        Object $payStatus = this.getPayStatus();
        result = result * 59 + ($payStatus == null ? 43 : $payStatus.hashCode());
        Object $upTime = this.getUpTime();
        result = result * 59 + ($upTime == null ? 43 : $upTime.hashCode());
        Object $profitStatus = this.getProfitStatus();
        result = result * 59 + ($profitStatus == null ? 43 : $profitStatus.hashCode());
        Object $purchStatus = this.getPurchStatus();
        result = result * 59 + ($purchStatus == null ? 43 : $purchStatus.hashCode());
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $partyId = this.getPartyId();
        result = result * 59 + ($partyId == null ? 43 : $partyId.hashCode());
        Object $userCode = this.getUserCode();
        result = result * 59 + ($userCode == null ? 43 : $userCode.hashCode());
        Object $sellerId = this.getSellerId();
        result = result * 59 + ($sellerId == null ? 43 : $sellerId.hashCode());
        Object $prizeOriginal = this.getPrizeOriginal();
        result = result * 59 + ($prizeOriginal == null ? 43 : $prizeOriginal.hashCode());
        Object $sellerName = this.getSellerName();
        result = result * 59 + ($sellerName == null ? 43 : $sellerName.hashCode());
        Object $prizeReal = this.getPrizeReal();
        result = result * 59 + ($prizeReal == null ? 43 : $prizeReal.hashCode());
        Object $systemPrice = this.getSystemPrice();
        result = result * 59 + ($systemPrice == null ? 43 : $systemPrice.hashCode());
        Object $fees = this.getFees();
        result = result * 59 + ($fees == null ? 43 : $fees.hashCode());
        Object $tax = this.getTax();
        result = result * 59 + ($tax == null ? 43 : $tax.hashCode());
        Object $profit = this.getProfit();
        result = result * 59 + ($profit == null ? 43 : $profit.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $phone = this.getPhone();
        result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
        Object $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        Object $contacts = this.getContacts();
        result = result * 59 + ($contacts == null ? 43 : $contacts.hashCode());
        Object $postcode = this.getPostcode();
        result = result * 59 + ($postcode == null ? 43 : $postcode.hashCode());
        Object $country = this.getCountry();
        result = result * 59 + ($country == null ? 43 : $country.hashCode());
        Object $province = this.getProvince();
        result = result * 59 + ($province == null ? 43 : $province.hashCode());
        Object $city = this.getCity();
        result = result * 59 + ($city == null ? 43 : $city.hashCode());
        Object $address = this.getAddress();
        result = result * 59 + ($address == null ? 43 : $address.hashCode());
        Object $refundRemark = this.getRefundRemark();
        result = result * 59 + ($refundRemark == null ? 43 : $refundRemark.hashCode());
        Object $returnReason = this.getReturnReason();
        result = result * 59 + ($returnReason == null ? 43 : $returnReason.hashCode());
        Object $returnDetail = this.getReturnDetail();
        result = result * 59 + ($returnDetail == null ? 43 : $returnDetail.hashCode());
        return result;
    }

    public String toString() {
        return "MallOrdersPrize(id=" + this.getId() + ", partyId=" + this.getPartyId() + ", userCode=" + this.getUserCode() + ", sellerId=" + this.getSellerId() + ", prizeOriginal=" + this.getPrizeOriginal() + ", sellerName=" + this.getSellerName() + ", goodsCount=" + this.getGoodsCount() + ", prizeReal=" + this.getPrizeReal() + ", systemPrice=" + this.getSystemPrice() + ", status=" + this.getStatus() + ", returnStatus=" + this.getReturnStatus() + ", orderStatus=" + this.getOrderStatus() + ", fees=" + this.getFees() + ", tax=" + this.getTax() + ", profit=" + this.getProfit() + ", payStatus=" + this.getPayStatus() + ", upTime=" + this.getUpTime() + ", createTime=" + this.getCreateTime() + ", phone=" + this.getPhone() + ", email=" + this.getEmail() + ", contacts=" + this.getContacts() + ", postcode=" + this.getPostcode() + ", country=" + this.getCountry() + ", province=" + this.getProvince() + ", city=" + this.getCity() + ", address=" + this.getAddress() + ", profitStatus=" + this.getProfitStatus() + ", purchStatus=" + this.getPurchStatus() + ", refundRemark=" + this.getRefundRemark() + ", returnReason=" + this.getReturnReason() + ", returnDetail=" + this.getReturnDetail() + ")";
    }
}
