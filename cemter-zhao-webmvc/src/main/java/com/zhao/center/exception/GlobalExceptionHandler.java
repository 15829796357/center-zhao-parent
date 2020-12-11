package com.zhao.center.exception;


import com.zhao.center.code.ResponseCode;
import com.zhao.center.vo.ResultVO;
import org.springframework.ui.Model;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 *
 * @author macro
 * @date 2020/2/27
 */
@RestControllerAdvice

public class GlobalExceptionHandler {

    /**
     * -------- 通用异常处理方法 --------
     **/
    @ExceptionHandler(Exception.class)
    public ResultVO error(Exception e) {
        e.printStackTrace();
        // 通用异常结果
        return ResultVO.fail(e.getMessage());
    }

    @ExceptionHandler(ASException.class)
    public ResultVO handle(ASException e) {
        System.out.println("自定义异常");
//        log.info("自定义异常");
        if (e.getErrorCode() != null) {
            return ResultVO.fail(e.getErrorCode());
        }
        return ResultVO.fail(e.getMessage());
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResultVO arithmeticExceptionExceptionProcessing(ArithmeticException e) {
        return ResultVO.fail(ResponseCode.ARITHMETIC_EXCEPTION);
    }
    @ExceptionHandler(AuthenticationException.class)
    public ResultVO authenticationExceptionProcessing(AuthenticationException e, Model model) {
        return ResultVO.fail(ResponseCode.FORBIDDEN);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 注意哦，这里传递的响应码枚举
        return ResultVO.fail(ResponseCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResultVO<String> SQLIntegrityConstraintViolationExceptionHandler(SQLIntegrityConstraintViolationException e) {
        System.out.println("数据库异常");
        String objectError = e.getMessage();
        // 注意哦，这里传递的响应码枚举
        return ResultVO.fail(ResponseCode.VALIDATE_FAILED, objectError);
    }

}
