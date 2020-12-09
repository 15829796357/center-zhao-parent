package com.zhao.center.exception;


import com.zhao.center.returnUtils.IErrorCode;

/**
 * 断言处理类，用于抛出各种API异常
 * Created by macro on 2020/2/27.
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) throws ApiException {
        throw new ApiException(errorCode);
    }
}
