 

package com.auto.mall.api.req;

import com.auto.mall.model.OrderRecord;

public class OrderRecordReq extends PageReq<OrderRecord> {
    private String id;
    private String status;
    private String startTime;
    private String endTime;
    private String lang;

    public OrderRecordReq() {
    }

    public String getId() {
        return this.id;
    }

    public String getStatus() {
        return this.status;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getLang() {
        return this.lang;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setStartTime(final String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(final String endTime) {
        this.endTime = endTime;
    }

    public void setLang(final String lang) {
        this.lang = lang;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OrderRecordReq)) {
            return false;
        } else {
            OrderRecordReq other = (OrderRecordReq)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label71;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label71;
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

                label57: {
                    Object this$startTime = this.getStartTime();
                    Object other$startTime = other.getStartTime();
                    if (this$startTime == null) {
                        if (other$startTime == null) {
                            break label57;
                        }
                    } else if (this$startTime.equals(other$startTime)) {
                        break label57;
                    }

                    return false;
                }

                Object this$endTime = this.getEndTime();
                Object other$endTime = other.getEndTime();
                if (this$endTime == null) {
                    if (other$endTime != null) {
                        return false;
                    }
                } else if (!this$endTime.equals(other$endTime)) {
                    return false;
                }

                Object this$lang = this.getLang();
                Object other$lang = other.getLang();
                if (this$lang == null) {
                    if (other$lang == null) {
                        return true;
                    }
                } else if (this$lang.equals(other$lang)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OrderRecordReq;
    }

    public int hashCode() {
          
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $startTime = this.getStartTime();
        result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
        Object $endTime = this.getEndTime();
        result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
        Object $lang = this.getLang();
        result = result * 59 + ($lang == null ? 43 : $lang.hashCode());
        return result;
    }

    public String toString() {
        return "OrderRecordReq(id=" + this.getId() + ", status=" + this.getStatus() + ", startTime=" + this.getStartTime() + ", endTime=" + this.getEndTime() + ", lang=" + this.getLang() + ")";
    }
}
