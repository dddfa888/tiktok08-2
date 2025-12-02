 

package com.auto.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;

@TableName("T_USERDATA")
public class UserData {
  @TableId(
          value = "uuid",
          type = IdType.UUID
  )
  private String id;
  @TableField("party_id")
  private String partyId;
  @TableField("REBATE_1")
  private BigDecimal rebate1;
  @TableField("REBATE_2")
  private BigDecimal rebate2;
  @TableField("REBATE_3")
  private BigDecimal rebate3;
  @TableField("create_time")
  private Date createTime;

  public UserData() {
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPartyId() {
    return this.partyId;
  }

  public void setPartyId(String partyId) {
    this.partyId = partyId;
  }

  public BigDecimal getRebate1() {
    return null == this.rebate1 ? new BigDecimal("0.00") : this.rebate1;
  }

  public void setRebate1(BigDecimal rebate1) {
    this.rebate1 = rebate1;
  }

  public BigDecimal getRebate2() {
    return null == this.rebate2 ? new BigDecimal("0.00") : this.rebate2;
  }

  public void setRebate2(BigDecimal rebate2) {
    this.rebate2 = rebate2;
  }

  public BigDecimal getRebate3() {
    return null == this.rebate3 ? new BigDecimal("0.00") : this.rebate3;
  }

  public void setRebate3(BigDecimal rebate3) {
    this.rebate3 = rebate3;
  }

  public Date getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
