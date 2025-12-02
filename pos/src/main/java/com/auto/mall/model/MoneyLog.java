 

package com.auto.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName("T_MONEY_LOG")
public class MoneyLog implements Serializable {
    private static final long serialVersionUID = 56724818108491382L;
    @TableId(
            value = "uuid",
            type = IdType.UUID
    )
    private String id;
    @TableField("log")
    private String log;
    @TableField("wallettype")
    private String walletType;
    @TableField("create_time")
    private Date createTime;
    @TableField("party_id")
    private String partyId;
    @TableField("amount")
    private BigDecimal amount;
    @TableField("amount_before")
    private BigDecimal amountBefore;
    @TableField("amount_after")
    private BigDecimal amountAfter;
    @TableField("content_type")
    private String contentType;
    @TableField("category")
    private String category;

    public MoneyLog() {
    }

    public String getId() {
        return this.id;
    }

    public String getLog() {
        return this.log;
    }

    public String getWalletType() {
        return this.walletType;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public BigDecimal getAmountBefore() {
        return this.amountBefore;
    }

    public BigDecimal getAmountAfter() {
        return this.amountAfter;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getCategory() {
        return this.category;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setLog(final String log) {
        this.log = log;
    }

    public void setWalletType(final String walletType) {
        this.walletType = walletType;
    }

    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
    }

    public void setPartyId(final String partyId) {
        this.partyId = partyId;
    }

    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    public void setAmountBefore(final BigDecimal amountBefore) {
        this.amountBefore = amountBefore;
    }

    public void setAmountAfter(final BigDecimal amountAfter) {
        this.amountAfter = amountAfter;
    }

    public void setContentType(final String contentType) {
        this.contentType = contentType;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MoneyLog)) {
            return false;
        } else {
            MoneyLog other = (MoneyLog)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$log = this.getLog();
                Object other$log = other.getLog();
                if (this$log == null) {
                    if (other$log != null) {
                        return false;
                    }
                } else if (!this$log.equals(other$log)) {
                    return false;
                }

                Object this$walletType = this.getWalletType();
                Object other$walletType = other.getWalletType();
                if (this$walletType == null) {
                    if (other$walletType != null) {
                        return false;
                    }
                } else if (!this$walletType.equals(other$walletType)) {
                    return false;
                }

                label110: {
                    Object this$createTime = this.getCreateTime();
                    Object other$createTime = other.getCreateTime();
                    if (this$createTime == null) {
                        if (other$createTime == null) {
                            break label110;
                        }
                    } else if (this$createTime.equals(other$createTime)) {
                        break label110;
                    }

                    return false;
                }

                label103: {
                    Object this$partyId = this.getPartyId();
                    Object other$partyId = other.getPartyId();
                    if (this$partyId == null) {
                        if (other$partyId == null) {
                            break label103;
                        }
                    } else if (this$partyId.equals(other$partyId)) {
                        break label103;
                    }

                    return false;
                }

                Object this$amount = this.getAmount();
                Object other$amount = other.getAmount();
                if (this$amount == null) {
                    if (other$amount != null) {
                        return false;
                    }
                } else if (!this$amount.equals(other$amount)) {
                    return false;
                }

                label89: {
                    Object this$amountBefore = this.getAmountBefore();
                    Object other$amountBefore = other.getAmountBefore();
                    if (this$amountBefore == null) {
                        if (other$amountBefore == null) {
                            break label89;
                        }
                    } else if (this$amountBefore.equals(other$amountBefore)) {
                        break label89;
                    }

                    return false;
                }

                label82: {
                    Object this$amountAfter = this.getAmountAfter();
                    Object other$amountAfter = other.getAmountAfter();
                    if (this$amountAfter == null) {
                        if (other$amountAfter == null) {
                            break label82;
                        }
                    } else if (this$amountAfter.equals(other$amountAfter)) {
                        break label82;
                    }

                    return false;
                }

                Object this$contentType = this.getContentType();
                Object other$contentType = other.getContentType();
                if (this$contentType == null) {
                    if (other$contentType != null) {
                        return false;
                    }
                } else if (!this$contentType.equals(other$contentType)) {
                    return false;
                }

                Object this$category = this.getCategory();
                Object other$category = other.getCategory();
                if (this$category == null) {
                    if (other$category != null) {
                        return false;
                    }
                } else if (!this$category.equals(other$category)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MoneyLog;
    }

    public int hashCode() {

        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $log = this.getLog();
        result = result * 59 + ($log == null ? 43 : $log.hashCode());
        Object $walletType = this.getWalletType();
        result = result * 59 + ($walletType == null ? 43 : $walletType.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $partyId = this.getPartyId();
        result = result * 59 + ($partyId == null ? 43 : $partyId.hashCode());
        Object $amount = this.getAmount();
        result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
        Object $amountBefore = this.getAmountBefore();
        result = result * 59 + ($amountBefore == null ? 43 : $amountBefore.hashCode());
        Object $amountAfter = this.getAmountAfter();
        result = result * 59 + ($amountAfter == null ? 43 : $amountAfter.hashCode());
        Object $contentType = this.getContentType();
        result = result * 59 + ($contentType == null ? 43 : $contentType.hashCode());
        Object $category = this.getCategory();
        result = result * 59 + ($category == null ? 43 : $category.hashCode());
        return result;
    }

    public String toString() {
        return "MoneyLog(id=" + this.getId() + ", log=" + this.getLog() + ", walletType=" + this.getWalletType() + ", createTime=" + this.getCreateTime() + ", partyId=" + this.getPartyId() + ", amount=" + this.getAmount() + ", amountBefore=" + this.getAmountBefore() + ", amountAfter=" + this.getAmountAfter() + ", contentType=" + this.getContentType() + ", category=" + this.getCategory() + ")";
    }
}
