package com.zhao.center.exception;

import com.zhao.center.code.IErrorCode;

/**
 * @author ZCH
 * @Description
 * @since 2020/12/11$ 10:49$
 */
public class ASException extends RuntimeException {
    private IErrorCode errorCode;

    public ASException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ASException(String message) {
        super(message);
    }

    public ASException(Throwable cause) {
        super(cause);
    }

    public ASException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
