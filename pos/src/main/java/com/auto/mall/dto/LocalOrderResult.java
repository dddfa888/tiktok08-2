 

package com.auto.mall.dto;

public class LocalOrderResult {
  private String orderId;
  private String prizeReal;
  private String fees;
  private String tax;

  public LocalOrderResult() {
  }

  public String getOrderId() {
    return this.orderId;
  }

  public String getPrizeReal() {
    return this.prizeReal;
  }

  public String getFees() {
    return this.fees;
  }

  public String getTax() {
    return this.tax;
  }

  public void setOrderId(final String orderId) {
    this.orderId = orderId;
  }

  public void setPrizeReal(final String prizeReal) {
    this.prizeReal = prizeReal;
  }

  public void setFees(final String fees) {
    this.fees = fees;
  }

  public void setTax(final String tax) {
    this.tax = tax;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    } else if (!(o instanceof LocalOrderResult)) {
      return false;
    } else {
      LocalOrderResult other = (LocalOrderResult)o;
      if (!other.canEqual(this)) {
        return false;
      } else {
        label59: {
          Object this$orderId = this.getOrderId();
          Object other$orderId = other.getOrderId();
          if (this$orderId == null) {
            if (other$orderId == null) {
              break label59;
            }
          } else if (this$orderId.equals(other$orderId)) {
            break label59;
          }

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

        return true;
      }
    }
  }

  protected boolean canEqual(final Object other) {
    return other instanceof LocalOrderResult;
  }

  public int hashCode() {
      
    int result = 1;
    Object $orderId = this.getOrderId();
    result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
    Object $prizeReal = this.getPrizeReal();
    result = result * 59 + ($prizeReal == null ? 43 : $prizeReal.hashCode());
    Object $fees = this.getFees();
    result = result * 59 + ($fees == null ? 43 : $fees.hashCode());
    Object $tax = this.getTax();
    result = result * 59 + ($tax == null ? 43 : $tax.hashCode());
    return result;
  }

  public String toString() {
    return "LocalOrderResult(orderId=" + this.getOrderId() + ", prizeReal=" + this.getPrizeReal() + ", fees=" + this.getFees() + ", tax=" + this.getTax() + ")";
  }
}
