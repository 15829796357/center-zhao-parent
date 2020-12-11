package com.zhao.center.vo;


import com.zhao.center.code.IErrorCode;
import com.zhao.center.code.ResponseCode;

import java.io.Serializable;

/**
 * @author ZCH
 * @Description
 * @since 2020/8/25$ 14:20$
 */
public class ResultVO<T> implements Serializable{

    private Integer code;

    private String message;

    private T data;


    public ResultVO(){
        this.code= ResponseCode.SUCCESS.getCode();
        this.message= ResponseCode.SUCCESS.getMessage();
    }

    public ResultVO(IErrorCode responseCode){
        this.code= responseCode.getCode();
        this.message=responseCode.getMessage();
    }
    public ResultVO(IErrorCode responseCode, String message){
        this.code= responseCode.getCode();
        this.message=message;
    }
    public static <T> ResultVO success(T data){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(data);
        return resultVO;
    }
    public static <T> ResultVO success(T data,String message){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(data);
        resultVO.setMessage(message);
        return resultVO;
    }
    public static <T> ResultVO success(IErrorCode iErrorCode,T data){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(data);
        resultVO.setMessage(iErrorCode.getMessage());
        resultVO.setCode(iErrorCode.getCode());
        return resultVO;
    }
    public static ResultVO fail(){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResponseCode.FAIL.getCode());
        resultVO.setMessage(ResponseCode.FAIL.getMessage());
        return resultVO;
    }
    public static ResultVO fail(IErrorCode iErrorCode){
        ResultVO resultVO = new ResultVO(iErrorCode);
        return resultVO;
    }
    public static ResultVO fail(String message){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResponseCode.FAIL.getCode());
        resultVO.setMessage(message);
        return resultVO;
    }
    public static ResultVO fail(IErrorCode iErrorCode,String message){
        ResultVO resultVO = new ResultVO(iErrorCode,message);
        return resultVO;
    }
    public static <T> ResultVO fail(IErrorCode iErrorCode,T data){
        ResultVO resultVO = new ResultVO(iErrorCode);
        resultVO.setData(data);
        return resultVO;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
