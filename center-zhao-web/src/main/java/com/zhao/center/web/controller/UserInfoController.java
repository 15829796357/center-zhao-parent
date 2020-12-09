package com.zhao.center.web.controller;

import com.zhao.center.api.UserInfoService;
import com.zhao.center.dto.req.UserInfoDTO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZCH
 * @Description 用户控制器
 * @since 2020/12/8$ 14:31$
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Reference
    private UserInfoService userInfoService;

    @GetMapping("/get")
    public UserInfoDTO getUserInfo(){
        return userInfoService.findById();
    }
}
