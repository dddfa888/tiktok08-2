 

package com.auto.mall.api.resp;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;

public class PageResp<T> implements Serializable {
    private static final long serialVersionUID = 504701959298347730L;
    private int pageNo;
    private int pageSize;
    private int totalPage;
    private int totalCount;
    private boolean hasNext;
    private List<T> records;

    public PageResp() {
    }

    public PageResp(int pageNo, int pageSize, int totalPage, int totalCount, List<T> records) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.records = records;
        this.hasNext = this.pageNo < this.totalPage;
    }

    public PageResp(Page page, List<T> records) {
        this.pageNo = (int)page.getCurrent();
        this.pageSize = (int)page.getSize();
        this.totalPage = (int)page.getPages();
        this.totalCount = (int)page.getTotal();
        this.hasNext = this.pageNo < this.totalPage;
        this.records = records;
    }

    public void setPage(Page page) {
        this.pageNo = (int)page.getCurrent();
        this.pageSize = (int)page.getSize();
        this.totalPage = (int)page.getPages();
        this.totalCount = (int)page.getTotal();
        this.hasNext = this.pageNo < this.totalPage;
    }

    @JsonIgnore
    public PageResp<T> getPage() {
        return new PageResp(this.pageNo, this.pageSize, this.totalPage, this.totalCount, (List)null);
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public boolean isHasNext() {
        return this.hasNext;
    }

    public List<T> getRecords() {
        return this.records;
    }

    public void setPageNo(final int pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalPage(final int totalPage) {
        this.totalPage = totalPage;
    }

    public void setTotalCount(final int totalCount) {
        this.totalCount = totalCount;
    }

    public void setHasNext(final boolean hasNext) {
        this.hasNext = hasNext;
    }

    public void setRecords(final List<T> records) {
        this.records = records;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageResp)) {
            return false;
        } else {
            PageResp<?> other = (PageResp)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getPageNo() != other.getPageNo()) {
                return false;
            } else if (this.getPageSize() != other.getPageSize()) {
                return false;
            } else if (this.getTotalPage() != other.getTotalPage()) {
                return false;
            } else if (this.getTotalCount() != other.getTotalCount()) {
                return false;
            } else if (this.isHasNext() != other.isHasNext()) {
                return false;
            } else {
                Object this$records = this.getRecords();
                Object other$records = other.getRecords();
                if (this$records == null) {
                    if (other$records != null) {
                        return false;
                    }
                } else if (!this$records.equals(other$records)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PageResp;
    }

    public int hashCode() {
          
        int result = 1;
        result = result * 59 + this.getPageNo();
        result = result * 59 + this.getPageSize();
        result = result * 59 + this.getTotalPage();
        result = result * 59 + this.getTotalCount();
        result = result * 59 + (this.isHasNext() ? 79 : 97);
        Object $records = this.getRecords();
        result = result * 59 + ($records == null ? 43 : $records.hashCode());
        return result;
    }

    public String toString() {
        return "PageResp(pageNo=" + this.getPageNo() + ", pageSize=" + this.getPageSize() + ", totalPage=" + this.getTotalPage() + ", totalCount=" + this.getTotalCount() + ", hasNext=" + this.isHasNext() + ", records=" + this.getRecords() + ")";
    }
}
