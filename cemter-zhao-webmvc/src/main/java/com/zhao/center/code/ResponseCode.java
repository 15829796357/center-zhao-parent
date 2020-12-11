package com.zhao.center.code;

/**
 * @author ZCH
 * @Description
 * @since 2020/8/25$ 14:26$
 */
public enum ResponseCode implements IErrorCode{
    /**
     * 成功
     */
    FAIL(601,"失败"),
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    ARITHMETIC_EXCEPTION(505,"计算报错"),


    ;

    private int code;

    private String message;

    private ResponseCode(){}

    private ResponseCode(int code,String message){
        this.code=code;
        this.message=message;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
