 

package com.auto.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

@TableName("T_WALLET")
public class Wallet implements Serializable {
  private static final long serialVersionUID = -44367384315080401L;
  @TableId(
          value = "uuid",
          type = IdType.UUID
  )
  private String uuid;
  @TableField("party_id")
  private String partyId;
  @TableField("money")
  private BigDecimal money;
  @TableField("rebate")
  private BigDecimal rebate;

  public Wallet() {
  }

  public String getUuid() {
    return this.uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getPartyId() {
    return this.partyId;
  }

  public void setPartyId(String partyId) {
    this.partyId = partyId;
  }

  public BigDecimal getMoney() {
    return null == this.money ? new BigDecimal("0.00") : this.money;
  }

  public void setMoney(BigDecimal money) {
    this.money = money;
  }

  public BigDecimal getRebate() {
    return null == this.rebate ? new BigDecimal("0.00") : this.rebate;
  }

  public void setRebate(BigDecimal rebate) {
    this.rebate = rebate;
  }
}
