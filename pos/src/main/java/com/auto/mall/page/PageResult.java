 

package com.auto.mall.page;

import com.github.pagehelper.Page;
import java.io.Serializable;
import java.util.List;
import org.springframework.http.HttpStatus;

public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 2984636422561292981L;
    private int code;
    private String msg;
    private long totalRows = 0L;
    private int totalPages = 0;
    private int pageNum = 1;
    private int pageSize = 0;
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(List<T> list) {
        this.code = HttpStatus.OK.value();
        this.msg = "success!";
        if (list instanceof Page) {
            Page<T> page = (Page)list;
            this.totalPages = page.getPages();
            this.totalRows = page.getTotal();
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.rows = page.getResult();
        } else {
            this.rows = list;
        }

    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }

    public void setTotalRows(long totalRows, int i) {
        this.totalRows = totalRows;
        this.calTotalPages();
    }

    public void calTotalPages() {
        this.totalPages = (int)(this.totalRows % (long)this.pageSize == 0L ? this.totalRows / (long)this.pageSize : this.totalRows / (long)this.pageSize + 1L);
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public long getTotalRows() {
        return this.totalRows;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public List<T> getRows() {
        return this.rows;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public void setTotalPages(final int totalPages) {
        this.totalPages = totalPages;
    }

    public void setPageNum(final int pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    public void setRows(final List<T> rows) {
        this.rows = rows;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageResult)) {
            return false;
        } else {
            PageResult<?> other = (PageResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else if (this.getTotalRows() != other.getTotalRows()) {
                return false;
            } else if (this.getTotalPages() != other.getTotalPages()) {
                return false;
            } else if (this.getPageNum() != other.getPageNum()) {
                return false;
            } else if (this.getPageSize() != other.getPageSize()) {
                return false;
            } else {
                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                Object this$rows = this.getRows();
                Object other$rows = other.getRows();
                if (this$rows == null) {
                    if (other$rows != null) {
                        return false;
                    }
                } else if (!this$rows.equals(other$rows)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PageResult;
    }

    public int hashCode() {
          
        int result = 1;
        result = result * 59 + this.getCode();
        long $totalRows = this.getTotalRows();
        result = result * 59 + (int)($totalRows >>> 32 ^ $totalRows);
        result = result * 59 + this.getTotalPages();
        result = result * 59 + this.getPageNum();
        result = result * 59 + this.getPageSize();
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        Object $rows = this.getRows();
        result = result * 59 + ($rows == null ? 43 : $rows.hashCode());
        return result;
    }

    public String toString() {
        return "PageResult(code=" + this.getCode() + ", msg=" + this.getMsg() + ", totalRows=" + this.getTotalRows() + ", totalPages=" + this.getTotalPages() + ", pageNum=" + this.getPageNum() + ", pageSize=" + this.getPageSize() + ", rows=" + this.getRows() + ")";
    }
}
