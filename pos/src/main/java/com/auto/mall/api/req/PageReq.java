

package com.auto.mall.api.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.Arrays;

public class PageReq<T> implements Serializable {
    protected int pageNo = 1;
    protected int pageSize = 10;
    protected T parameter;
    protected String[] orders;

    public PageReq() {
    }

    public Page getPage() {
        return new Page((long)this.pageNo, (long)this.pageSize);
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public T getParameter() {
        return this.parameter;
    }

    public String[] getOrders() {
        return this.orders;
    }

    public void setPageNo(final int pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    public void setParameter(final T parameter) {
        this.parameter = parameter;
    }

    public void setOrders(final String[] orders) {
        this.orders = orders;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageReq)) {
            return false;
        } else {
            PageReq<?> other = (PageReq)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getPageNo() != other.getPageNo()) {
                return false;
            } else if (this.getPageSize() != other.getPageSize()) {
                return false;
            } else {
                Object this$parameter = this.getParameter();
                Object other$parameter = other.getParameter();
                if (this$parameter == null) {
                    if (other$parameter == null) {
                        return Arrays.deepEquals(this.getOrders(), other.getOrders());
                    }
                } else if (this$parameter.equals(other$parameter)) {
                    return Arrays.deepEquals(this.getOrders(), other.getOrders());
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PageReq;
    }

    public int hashCode() {

        int result = 1;
        result = result * 59 + this.getPageNo();
        result = result * 59 + this.getPageSize();
        Object $parameter = this.getParameter();
        result = result * 59 + ($parameter == null ? 43 : $parameter.hashCode());
        result = result * 59 + Arrays.deepHashCode(this.getOrders());
        return result;
    }

    public String toString() {
        return "PageReq(pageNo=" + this.getPageNo() + ", pageSize=" + this.getPageSize() + ", parameter=" + this.getParameter() + ", orders=" + Arrays.deepToString(this.getOrders()) + ")";
    }
}
