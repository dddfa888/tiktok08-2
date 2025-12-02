
package com.auto.mall.api.req;

public class PromoteReq extends PageReq {
  private static final long serialVersionUID = 6038545556502126284L;
  private Integer level;
  private String token;
  private String partyId;

  public PromoteReq() {
  }

  public Integer getLevel() {
    return null != this.level && this.level > 0 ? this.level : 1;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public String getToken() {
    return this.token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getPartyId() {
    return this.partyId;
  }

  public void setPartyId(String partyId) {
    this.partyId = partyId;
  }
}
