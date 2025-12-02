package com.auto.mall.api.req;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
public class BatchOrderReq implements Serializable {
    private static final long serialVersionUID = -82328037365315952L;
    private List<String> partyIds;
    private List<String> items;
    private List<String> skuIds;
    private String[] datetime;
    private int[] time_limit;
    private BigDecimal[] price_limit;
    private int[] item_limit;
    private BigDecimal total_amount;
    private int total_count;
    private String createUser;

    public BatchOrderReq() {
    }

    public List<String> getPartyIds() {
        return this.partyIds;
    }

    public List<String> getItems() {
        return this.items;
    }

    public List<String> getSkuIds() {
        return this.skuIds;
    }

    public String[] getDatetime() {
        return this.datetime;
    }

    public int[] getTime_limit() {
        return this.time_limit;
    }

    public BigDecimal[] getPrice_limit() {
        return this.price_limit;
    }

    public int[] getItem_limit() {
        return this.item_limit;
    }

    public BigDecimal getTotal_amount() {
        return this.total_amount;
    }

    public int getTotal_count() {
        return this.total_count;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setPartyIds(final List<String> partyIds) {
        this.partyIds = partyIds;
    }

    public void setItems(final List<String> items) {
        this.items = items;
    }

    public void setSkuIds(final List<String> skuIds) {
        this.skuIds = skuIds;
    }

    public void setDatetime(final String[] datetime) {
        this.datetime = datetime;
    }

    public void setTime_limit(final int[] time_limit) {
        this.time_limit = time_limit;
    }

    public void setPrice_limit(final BigDecimal[] price_limit) {
        this.price_limit = price_limit;
    }

    public void setItem_limit(final int[] item_limit) {
        this.item_limit = item_limit;
    }

    public void setTotal_amount(final BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public void setTotal_count(final int total_count) {
        this.total_count = total_count;
    }

    public void setCreateUser(final String createUser) {
        this.createUser = createUser;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BatchOrderReq)) {
            return false;
        } else {
            BatchOrderReq other = (BatchOrderReq)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getTotal_count() != other.getTotal_count()) {
                return false;
            } else {
                label89: {
                    Object this$partyIds = this.getPartyIds();
                    Object other$partyIds = other.getPartyIds();
                    if (this$partyIds == null) {
                        if (other$partyIds == null) {
                            break label89;
                        }
                    } else if (this$partyIds.equals(other$partyIds)) {
                        break label89;
                    }

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

                label75: {
                    Object this$skuIds = this.getSkuIds();
                    Object other$skuIds = other.getSkuIds();
                    if (this$skuIds == null) {
                        if (other$skuIds == null) {
                            break label75;
                        }
                    } else if (this$skuIds.equals(other$skuIds)) {
                        break label75;
                    }

                    return false;
                }

                if (!Arrays.deepEquals(this.getDatetime(), other.getDatetime())) {
                    return false;
                } else if (!Arrays.equals(this.getTime_limit(), other.getTime_limit())) {
                    return false;
                } else if (!Arrays.deepEquals(this.getPrice_limit(), other.getPrice_limit())) {
                    return false;
                } else if (!Arrays.equals(this.getItem_limit(), other.getItem_limit())) {
                    return false;
                } else {
                    Object this$total_amount = this.getTotal_amount();
                    Object other$total_amount = other.getTotal_amount();
                    if (this$total_amount == null) {
                        if (other$total_amount != null) {
                            return false;
                        }
                    } else if (!this$total_amount.equals(other$total_amount)) {
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
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BatchOrderReq;
    }

    public int hashCode() {
        int result = 1;
        result = result * 59 + this.getTotal_count();
        Object $partyIds = this.getPartyIds();
        result = result * 59 + ($partyIds == null ? 43 : $partyIds.hashCode());
        Object $items = this.getItems();
        result = result * 59 + ($items == null ? 43 : $items.hashCode());
        Object $skuIds = this.getSkuIds();
        result = result * 59 + ($skuIds == null ? 43 : $skuIds.hashCode());
        result = result * 59 + Arrays.deepHashCode(this.getDatetime());
        result = result * 59 + Arrays.hashCode(this.getTime_limit());
        result = result * 59 + Arrays.deepHashCode(this.getPrice_limit());
        result = result * 59 + Arrays.hashCode(this.getItem_limit());
        Object $total_amount = this.getTotal_amount();
        result = result * 59 + ($total_amount == null ? 43 : $total_amount.hashCode());
        Object $createUser = this.getCreateUser();
        result = result * 59 + ($createUser == null ? 43 : $createUser.hashCode());
        return result;
    }

    public String toString() {
        return "BatchOrderReq(partyIds=" + this.getPartyIds() + ", items=" + this.getItems() + ", skuIds=" + this.getSkuIds() + ", datetime=" + Arrays.deepToString(this.getDatetime()) + ", time_limit=" + Arrays.toString(this.getTime_limit()) + ", price_limit=" + Arrays.deepToString(this.getPrice_limit()) + ", item_limit=" + Arrays.toString(this.getItem_limit()) + ", total_amount=" + this.getTotal_amount() + ", total_count=" + this.getTotal_count() + ", createUser=" + this.getCreateUser() + ")";
    }
}
