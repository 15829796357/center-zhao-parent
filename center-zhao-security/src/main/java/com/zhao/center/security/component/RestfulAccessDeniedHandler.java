package com.zhao.center.security.component;

import cn.hutool.json.JSONUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 6
 * 这里还有个问题需要提下，当前端跨域访问没
 * 有权限的接口时，会出现跨域问题，只需要在没有权限
 * 访问的处理类RestfulAccessDeniedHandler中添加
 * 允许跨域访问的响应头即可。
 * <p>
 * 自定义返回结果：没有权限访问时
 * Created by macro on 2018/4/26.
 */
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println("没有权限访问");
//        response.getWriter().println(JSONUtil.parse(CommonResult.forbidden(e.getMessage())));
        response.getWriter().flush();
    }
}
