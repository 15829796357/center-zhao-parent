package com.zhao.center.exception;


import com.zhao.center.returnUtils.CommonResult;
import com.zhao.center.returnUtils.ResultCode;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class GlobalExceptionHandler {

    /**
     * -------- 通用异常处理方法 --------
     **/
    @ExceptionHandler(Exception.class)
    public CommonResult error(Exception e) {
        e.printStackTrace();
        // 通用异常结果
        return CommonResult.failed();
    }

    @ExceptionHandler(ApiException.class)
    public CommonResult handle(ApiException e) {
        System.out.println("自定义异常");
        log.info("自定义异常");
        if (e.getErrorCode() != null) {
            return CommonResult.failed(e.getErrorCode());
        }
        return CommonResult.failed(e.getMessage());
    }


    @ExceptionHandler(AuthenticationException.class)
    public CommonResult authenticationExceptionProcessing(AuthenticationException e, Model model) {
        return CommonResult.failed(ResultCode.FORBIDDEN);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 注意哦，这里传递的响应码枚举
        return CommonResult.failed(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public CommonResult<String> SQLIntegrityConstraintViolationExceptionHandler(SQLIntegrityConstraintViolationException e) {
        System.out.println("数据库异常");
        String objectError = e.getMessage();
        // 注意哦，这里传递的响应码枚举
        return CommonResult.failed(ResultCode.VALIDATE_FAILED,objectError);
    }

}
