 

package com.auto.mall.exception;

public class MallToolGlobalException extends RuntimeException {
    private int code;
    private String message;

    public MallToolGlobalException() {
        this.code = 500;
    }

    public MallToolGlobalException(String message) {
        super(message);
        this.code = 500;
        this.message = message;
    }

    public MallToolGlobalException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MallToolGlobalException)) {
            return false;
        } else {
            MallToolGlobalException other = (MallToolGlobalException)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MallToolGlobalException;
    }

    public int hashCode() {
          
        int result = 1;
        result = result * 59 + this.getCode();
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        return result;
    }

    public String toString() {
        return "MallToolGlobalException(code=" + this.getCode() + ", message=" + this.getMessage() + ")";
    }
}
