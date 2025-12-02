 

package com.auto.mall.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName("T_MALL_ORDERS_PRIZE")
public class MallOrderPrize implements Serializable {
    private static final long serialVersionUID = 2053074722488993544L;
    @TableId("uuid")
    private String uuid;
    @TableField("party_id")
    private String partyId;
    @TableField("user_code")
    private String userCode;
    @TableField("seller_id")
    private String sellerId;
    @TableField("seller_name")
    private String sellerName;
    @TableField("goods__count")
    private Integer goodsCount;
    @TableField("prize_original")
    private BigDecimal prizeOriginal;
    @TableField("prize_real")
    private BigDecimal prizeReal;
    @TableField("system_price")
    private BigDecimal systemPrice;
    @TableField("status")
    private Integer status;
    @TableField("order_status")
    private Integer orderStatus;
    @TableField("return_status")
    private Integer returnStatus;
    @TableField("fees")
    private BigDecimal fees;
    @TableField("tax")
    private BigDecimal tax;
    @TableField("profit")
    private BigDecimal profit;
    @TableField("create_time")
    private Date createTime;
    @TableField("refund_time")
    private Date refundTime;
    @TableField("refund_deal_time")
    private Date refundDealTime;
    @TableField("pay_time")
    private Date payTime;
    @TableField("pay_status")
    private Integer payStatus;
    @TableField("up_time")
    private Long upTime;
    @TableField("phone")
    private String phone;
    @TableField("email")
    private String email;
    @TableField("contacts")
    private String contacts;
    @TableField("postcode")
    private String postcode;
    @TableField("country")
    private String country;
    @TableField("province")
    private String province;
    @TableField("city")
    private String city;
    @TableField("address")
    private String address;
    @TableField("profit_status")
    private Integer profitStatus;
    @TableField("purch_status")
    private Integer purchStatus;
    @TableField("purch_time")
    private Date purchTime;
    @TableField("refund_remark")
    private String refundRemark;
    @TableField("return_reason")
    private String returnReason;
    @TableField("return_detail")
    private String returnDetail;
    @TableField("has_comment")
    private Integer hasComment;

    public MallOrderPrize() {
    }

    public String getUuid() {
        return this.uuid;
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

    public String getSellerName() {
        return this.sellerName;
    }

    public Integer getGoodsCount() {
        return this.goodsCount;
    }

    public BigDecimal getPrizeOriginal() {
        return this.prizeOriginal;
    }

    public BigDecimal getPrizeReal() {
        return this.prizeReal;
    }

    public BigDecimal getSystemPrice() {
        return this.systemPrice;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Integer getOrderStatus() {
        return this.orderStatus;
    }

    public Integer getReturnStatus() {
        return this.returnStatus;
    }

    public BigDecimal getFees() {
        return this.fees;
    }

    public BigDecimal getTax() {
        return this.tax;
    }

    public BigDecimal getProfit() {
        return this.profit;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Date getRefundTime() {
        return this.refundTime;
    }

    public Date getRefundDealTime() {
        return this.refundDealTime;
    }

    public Date getPayTime() {
        return this.payTime;
    }

    public Integer getPayStatus() {
        return this.payStatus;
    }

    public Long getUpTime() {
        return this.upTime;
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

    public Date getPurchTime() {
        return this.purchTime;
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

    public Integer getHasComment() {
        return this.hasComment;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
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

    public void setSellerName(final String sellerName) {
        this.sellerName = sellerName;
    }

    public void setGoodsCount(final Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public void setPrizeOriginal(final BigDecimal prizeOriginal) {
        this.prizeOriginal = prizeOriginal;
    }

    public void setPrizeReal(final BigDecimal prizeReal) {
        this.prizeReal = prizeReal;
    }

    public void setSystemPrice(final BigDecimal systemPrice) {
        this.systemPrice = systemPrice;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }

    public void setOrderStatus(final Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setReturnStatus(final Integer returnStatus) {
        this.returnStatus = returnStatus;
    }

    public void setFees(final BigDecimal fees) {
        this.fees = fees;
    }

    public void setTax(final BigDecimal tax) {
        this.tax = tax;
    }

    public void setProfit(final BigDecimal profit) {
        this.profit = profit;
    }

    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
    }

    public void setRefundTime(final Date refundTime) {
        this.refundTime = refundTime;
    }

    public void setRefundDealTime(final Date refundDealTime) {
        this.refundDealTime = refundDealTime;
    }

    public void setPayTime(final Date payTime) {
        this.payTime = payTime;
    }

    public void setPayStatus(final Integer payStatus) {
        this.payStatus = payStatus;
    }

    public void setUpTime(final Long upTime) {
        this.upTime = upTime;
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

    public void setPurchTime(final Date purchTime) {
        this.purchTime = purchTime;
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

    public void setHasComment(final Integer hasComment) {
        this.hasComment = hasComment;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MallOrderPrize)) {
            return false;
        } else {
            MallOrderPrize other = (MallOrderPrize)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label443: {
                    Object this$goodsCount = this.getGoodsCount();
                    Object other$goodsCount = other.getGoodsCount();
                    if (this$goodsCount == null) {
                        if (other$goodsCount == null) {
                            break label443;
                        }
                    } else if (this$goodsCount.equals(other$goodsCount)) {
                        break label443;
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

                Object this$orderStatus = this.getOrderStatus();
                Object other$orderStatus = other.getOrderStatus();
                if (this$orderStatus == null) {
                    if (other$orderStatus != null) {
                        return false;
                    }
                } else if (!this$orderStatus.equals(other$orderStatus)) {
                    return false;
                }

                label422: {
                    Object this$returnStatus = this.getReturnStatus();
                    Object other$returnStatus = other.getReturnStatus();
                    if (this$returnStatus == null) {
                        if (other$returnStatus == null) {
                            break label422;
                        }
                    } else if (this$returnStatus.equals(other$returnStatus)) {
                        break label422;
                    }

                    return false;
                }

                label415: {
                    Object this$payStatus = this.getPayStatus();
                    Object other$payStatus = other.getPayStatus();
                    if (this$payStatus == null) {
                        if (other$payStatus == null) {
                            break label415;
                        }
                    } else if (this$payStatus.equals(other$payStatus)) {
                        break label415;
                    }

                    return false;
                }

                label408: {
                    Object this$upTime = this.getUpTime();
                    Object other$upTime = other.getUpTime();
                    if (this$upTime == null) {
                        if (other$upTime == null) {
                            break label408;
                        }
                    } else if (this$upTime.equals(other$upTime)) {
                        break label408;
                    }

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

                label394: {
                    Object this$purchStatus = this.getPurchStatus();
                    Object other$purchStatus = other.getPurchStatus();
                    if (this$purchStatus == null) {
                        if (other$purchStatus == null) {
                            break label394;
                        }
                    } else if (this$purchStatus.equals(other$purchStatus)) {
                        break label394;
                    }

                    return false;
                }

                Object this$hasComment = this.getHasComment();
                Object other$hasComment = other.getHasComment();
                if (this$hasComment == null) {
                    if (other$hasComment != null) {
                        return false;
                    }
                } else if (!this$hasComment.equals(other$hasComment)) {
                    return false;
                }

                label380: {
                    Object this$uuid = this.getUuid();
                    Object other$uuid = other.getUuid();
                    if (this$uuid == null) {
                        if (other$uuid == null) {
                            break label380;
                        }
                    } else if (this$uuid.equals(other$uuid)) {
                        break label380;
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

                Object this$userCode = this.getUserCode();
                Object other$userCode = other.getUserCode();
                if (this$userCode == null) {
                    if (other$userCode != null) {
                        return false;
                    }
                } else if (!this$userCode.equals(other$userCode)) {
                    return false;
                }

                label359: {
                    Object this$sellerId = this.getSellerId();
                    Object other$sellerId = other.getSellerId();
                    if (this$sellerId == null) {
                        if (other$sellerId == null) {
                            break label359;
                        }
                    } else if (this$sellerId.equals(other$sellerId)) {
                        break label359;
                    }

                    return false;
                }

                label352: {
                    Object this$sellerName = this.getSellerName();
                    Object other$sellerName = other.getSellerName();
                    if (this$sellerName == null) {
                        if (other$sellerName == null) {
                            break label352;
                        }
                    } else if (this$sellerName.equals(other$sellerName)) {
                        break label352;
                    }

                    return false;
                }

                Object this$prizeOriginal = this.getPrizeOriginal();
                Object other$prizeOriginal = other.getPrizeOriginal();
                if (this$prizeOriginal == null) {
                    if (other$prizeOriginal != null) {
                        return false;
                    }
                } else if (!this$prizeOriginal.equals(other$prizeOriginal)) {
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

                label331: {
                    Object this$systemPrice = this.getSystemPrice();
                    Object other$systemPrice = other.getSystemPrice();
                    if (this$systemPrice == null) {
                        if (other$systemPrice == null) {
                            break label331;
                        }
                    } else if (this$systemPrice.equals(other$systemPrice)) {
                        break label331;
                    }

                    return false;
                }

                Object this$fees = this.getFees();
                Object other$fees = other.getFees();
                if (this$fees == null) {
                    if (other$fees != null) {
                        return false;
                    }
                } else if (!this$fees.equals(other$fees)) {
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

                label310: {
                    Object this$profit = this.getProfit();
                    Object other$profit = other.getProfit();
                    if (this$profit == null) {
                        if (other$profit == null) {
                            break label310;
                        }
                    } else if (this$profit.equals(other$profit)) {
                        break label310;
                    }

                    return false;
                }

                label303: {
                    Object this$createTime = this.getCreateTime();
                    Object other$createTime = other.getCreateTime();
                    if (this$createTime == null) {
                        if (other$createTime == null) {
                            break label303;
                        }
                    } else if (this$createTime.equals(other$createTime)) {
                        break label303;
                    }

                    return false;
                }

                label296: {
                    Object this$refundTime = this.getRefundTime();
                    Object other$refundTime = other.getRefundTime();
                    if (this$refundTime == null) {
                        if (other$refundTime == null) {
                            break label296;
                        }
                    } else if (this$refundTime.equals(other$refundTime)) {
                        break label296;
                    }

                    return false;
                }

                Object this$refundDealTime = this.getRefundDealTime();
                Object other$refundDealTime = other.getRefundDealTime();
                if (this$refundDealTime == null) {
                    if (other$refundDealTime != null) {
                        return false;
                    }
                } else if (!this$refundDealTime.equals(other$refundDealTime)) {
                    return false;
                }

                label282: {
                    Object this$payTime = this.getPayTime();
                    Object other$payTime = other.getPayTime();
                    if (this$payTime == null) {
                        if (other$payTime == null) {
                            break label282;
                        }
                    } else if (this$payTime.equals(other$payTime)) {
                        break label282;
                    }

                    return false;
                }

                Object this$phone = this.getPhone();
                Object other$phone = other.getPhone();
                if (this$phone == null) {
                    if (other$phone != null) {
                        return false;
                    }
                } else if (!this$phone.equals(other$phone)) {
                    return false;
                }

                label268: {
                    Object this$email = this.getEmail();
                    Object other$email = other.getEmail();
                    if (this$email == null) {
                        if (other$email == null) {
                            break label268;
                        }
                    } else if (this$email.equals(other$email)) {
                        break label268;
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

                Object this$postcode = this.getPostcode();
                Object other$postcode = other.getPostcode();
                if (this$postcode == null) {
                    if (other$postcode != null) {
                        return false;
                    }
                } else if (!this$postcode.equals(other$postcode)) {
                    return false;
                }

                label247: {
                    Object this$country = this.getCountry();
                    Object other$country = other.getCountry();
                    if (this$country == null) {
                        if (other$country == null) {
                            break label247;
                        }
                    } else if (this$country.equals(other$country)) {
                        break label247;
                    }

                    return false;
                }

                label240: {
                    Object this$province = this.getProvince();
                    Object other$province = other.getProvince();
                    if (this$province == null) {
                        if (other$province == null) {
                            break label240;
                        }
                    } else if (this$province.equals(other$province)) {
                        break label240;
                    }

                    return false;
                }

                Object this$city = this.getCity();
                Object other$city = other.getCity();
                if (this$city == null) {
                    if (other$city != null) {
                        return false;
                    }
                } else if (!this$city.equals(other$city)) {
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

                label219: {
                    Object this$purchTime = this.getPurchTime();
                    Object other$purchTime = other.getPurchTime();
                    if (this$purchTime == null) {
                        if (other$purchTime == null) {
                            break label219;
                        }
                    } else if (this$purchTime.equals(other$purchTime)) {
                        break label219;
                    }

                    return false;
                }

                Object this$refundRemark = this.getRefundRemark();
                Object other$refundRemark = other.getRefundRemark();
                if (this$refundRemark == null) {
                    if (other$refundRemark != null) {
                        return false;
                    }
                } else if (!this$refundRemark.equals(other$refundRemark)) {
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
        return other instanceof MallOrderPrize;
    }

    public int hashCode() {
          
        int result = 1;
        Object $goodsCount = this.getGoodsCount();
        result = result * 59 + ($goodsCount == null ? 43 : $goodsCount.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $orderStatus = this.getOrderStatus();
        result = result * 59 + ($orderStatus == null ? 43 : $orderStatus.hashCode());
        Object $returnStatus = this.getReturnStatus();
        result = result * 59 + ($returnStatus == null ? 43 : $returnStatus.hashCode());
        Object $payStatus = this.getPayStatus();
        result = result * 59 + ($payStatus == null ? 43 : $payStatus.hashCode());
        Object $upTime = this.getUpTime();
        result = result * 59 + ($upTime == null ? 43 : $upTime.hashCode());
        Object $profitStatus = this.getProfitStatus();
        result = result * 59 + ($profitStatus == null ? 43 : $profitStatus.hashCode());
        Object $purchStatus = this.getPurchStatus();
        result = result * 59 + ($purchStatus == null ? 43 : $purchStatus.hashCode());
        Object $hasComment = this.getHasComment();
        result = result * 59 + ($hasComment == null ? 43 : $hasComment.hashCode());
        Object $uuid = this.getUuid();
        result = result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
        Object $partyId = this.getPartyId();
        result = result * 59 + ($partyId == null ? 43 : $partyId.hashCode());
        Object $userCode = this.getUserCode();
        result = result * 59 + ($userCode == null ? 43 : $userCode.hashCode());
        Object $sellerId = this.getSellerId();
        result = result * 59 + ($sellerId == null ? 43 : $sellerId.hashCode());
        Object $sellerName = this.getSellerName();
        result = result * 59 + ($sellerName == null ? 43 : $sellerName.hashCode());
        Object $prizeOriginal = this.getPrizeOriginal();
        result = result * 59 + ($prizeOriginal == null ? 43 : $prizeOriginal.hashCode());
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
        Object $refundTime = this.getRefundTime();
        result = result * 59 + ($refundTime == null ? 43 : $refundTime.hashCode());
        Object $refundDealTime = this.getRefundDealTime();
        result = result * 59 + ($refundDealTime == null ? 43 : $refundDealTime.hashCode());
        Object $payTime = this.getPayTime();
        result = result * 59 + ($payTime == null ? 43 : $payTime.hashCode());
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
        Object $purchTime = this.getPurchTime();
        result = result * 59 + ($purchTime == null ? 43 : $purchTime.hashCode());
        Object $refundRemark = this.getRefundRemark();
        result = result * 59 + ($refundRemark == null ? 43 : $refundRemark.hashCode());
        Object $returnReason = this.getReturnReason();
        result = result * 59 + ($returnReason == null ? 43 : $returnReason.hashCode());
        Object $returnDetail = this.getReturnDetail();
        result = result * 59 + ($returnDetail == null ? 43 : $returnDetail.hashCode());
        return result;
    }

    public String toString() {
        return "MallOrderPrize(uuid=" + this.getUuid() + ", partyId=" + this.getPartyId() + ", userCode=" + this.getUserCode() + ", sellerId=" + this.getSellerId() + ", sellerName=" + this.getSellerName() + ", goodsCount=" + this.getGoodsCount() + ", prizeOriginal=" + this.getPrizeOriginal() + ", prizeReal=" + this.getPrizeReal() + ", systemPrice=" + this.getSystemPrice() + ", status=" + this.getStatus() + ", orderStatus=" + this.getOrderStatus() + ", returnStatus=" + this.getReturnStatus() + ", fees=" + this.getFees() + ", tax=" + this.getTax() + ", profit=" + this.getProfit() + ", createTime=" + this.getCreateTime() + ", refundTime=" + this.getRefundTime() + ", refundDealTime=" + this.getRefundDealTime() + ", payTime=" + this.getPayTime() + ", payStatus=" + this.getPayStatus() + ", upTime=" + this.getUpTime() + ", phone=" + this.getPhone() + ", email=" + this.getEmail() + ", contacts=" + this.getContacts() + ", postcode=" + this.getPostcode() + ", country=" + this.getCountry() + ", province=" + this.getProvince() + ", city=" + this.getCity() + ", address=" + this.getAddress() + ", profitStatus=" + this.getProfitStatus() + ", purchStatus=" + this.getPurchStatus() + ", purchTime=" + this.getPurchTime() + ", refundRemark=" + this.getRefundRemark() + ", returnReason=" + this.getReturnReason() + ", returnDetail=" + this.getReturnDetail() + ", hasComment=" + this.getHasComment() + ")";
    }
}
