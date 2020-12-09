package com.zhao.center.web.controller;

import com.zhao.center.api.SysMenuService;
import com.zhao.center.api.SysUserService;
import com.zhao.center.dto.resp.SysUserDTO;
import com.zhao.center.exception.ApiException;
import com.zhao.center.exception.Asserts;
import com.zhao.center.returnUtils.CommonResult;
import com.zhao.center.returnUtils.ResultCode;
import com.zhao.center.security.util.JwtTokenUtil;
import com.zhao.center.web.dto.req.SecurityUserDetails;
import com.zhao.center.web.dto.req.SysMenuReqVO;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZCH
 * @Description 用户
 * @since 2020/12/9$ 10:41$
 */
@RestController
@RequestMapping("/sys/user/")
@Api(tags = {"用户"})
public class SysUserController {

    @Reference
    private SysUserService sysUserService;
    @Reference
    private SysMenuService sysMenuService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public CommonResult<String> login(String username, String password) throws ApiException {
        SysUserDTO sysUserDTO = sysUserService.loadUserByUsername(username);
        if (!passwordEncoder.matches(password, sysUserDTO.getPassword())) {
//            throw new ApiException(ResultCode.ERRORPASSWORD);
            Asserts.fail(ResultCode.ERRORPASSWORD);
        }
        SecurityUserDetails securityUserDetails = new SecurityUserDetails(sysUserDTO, sysMenuService.findAllMenuList(sysUserDTO.getId()));
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(securityUserDetails, null, securityUserDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken(securityUserDetails, securityUserDetails.getSysUserDTO().getId());
        return CommonResult.success(token);
    }

    public static void main(String[] args) {
        List<SysMenuReqVO> sysMenuDTOList = new ArrayList<SysMenuReqVO>() {{
            add(SysMenuReqVO.builder().id(1L).name("菜单1").parentId(1L).url("/1/").build());
            add(SysMenuReqVO.builder().id(2L).name("菜单2").parentId(2L).url("/2/").build());
            add(SysMenuReqVO.builder().id(3L).name("菜单3").parentId(3L).url("/3/").build());
            add(SysMenuReqVO.builder().id(4L).name("菜单4").parentId(4L).url("/4/").build());
        }};
        List<SimpleGrantedAuthority> collect = sysMenuDTOList.stream()
                .map(resource -> new SimpleGrantedAuthority(resource.getId() + ":" + resource.getName() + ":" + resource.getParentId() + ":" + resource.getUrl()))
                .collect(Collectors.toList());
        for (SimpleGrantedAuthority simpleGrantedAuthority : collect) {
            System.out.println(simpleGrantedAuthority.toString());
        }
    }

}
