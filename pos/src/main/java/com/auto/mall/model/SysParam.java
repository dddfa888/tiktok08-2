 

package com.auto.mall.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

@TableName("T_SYSPARA")
public class SysParam implements Serializable {
    private static final long serialVersionUID = -7160285606866396828L;
    @TableId("uuid")
    private String uuid;
    @TableField("code")
    private String code;
    @TableField("party_id")
    private String partyId;
    @TableField("svalue")
    private String value;

    public SysParam() {
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getCode() {
        return this.code;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public String getValue() {
        return this.value;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setPartyId(final String partyId) {
        this.partyId = partyId;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SysParam)) {
            return false;
        } else {
            SysParam other = (SysParam)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$uuid = this.getUuid();
                    Object other$uuid = other.getUuid();
                    if (this$uuid == null) {
                        if (other$uuid == null) {
                            break label59;
                        }
                    } else if (this$uuid.equals(other$uuid)) {
                        break label59;
                    }

                    return false;
                }

                Object this$code = this.getCode();
                Object other$code = other.getCode();
                if (this$code == null) {
                    if (other$code != null) {
                        return false;
                    }
                } else if (!this$code.equals(other$code)) {
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

                Object this$value = this.getValue();
                Object other$value = other.getValue();
                if (this$value == null) {
                    if (other$value != null) {
                        return false;
                    }
                } else if (!this$value.equals(other$value)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SysParam;
    }

    public int hashCode() {
          
        int result = 1;
        Object $uuid = this.getUuid();
        result = result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $partyId = this.getPartyId();
        result = result * 59 + ($partyId == null ? 43 : $partyId.hashCode());
        Object $value = this.getValue();
        result = result * 59 + ($value == null ? 43 : $value.hashCode());
        return result;
    }

    public String toString() {
        return "SysParam(uuid=" + this.getUuid() + ", code=" + this.getCode() + ", partyId=" + this.getPartyId() + ", value=" + this.getValue() + ")";
    }
}
