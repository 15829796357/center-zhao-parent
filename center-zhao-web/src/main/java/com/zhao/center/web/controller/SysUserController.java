package com.zhao.center.web.controller;

import com.zhao.center.api.SysMenuService;
import com.zhao.center.api.SysUserService;
import com.zhao.center.api.TestService;
import com.zhao.center.code.ResponseCode;
import com.zhao.center.dto.resp.SysUserDTO;
import com.zhao.center.exception.ASException;
import com.zhao.center.returnUtils.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

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
    @Reference
    private TestService testService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public CommonResult<SysUserDTO> login(String username) throws ASException {
        SysUserDTO sysUserDTO = sysUserService.loadUserByUsername(username);
        if (sysUserDTO.getId() == 2) {
            throw new ASException(ResponseCode.UNAUTHORIZED);
//            throw new ApiException(ResultCode.ERRORPASSWORD);
        }
//        if (!passwordEncoder.matches(password, sysUserDTO.getPassword())) {
//            throw new ApiException(ResultCode.ERRORPASSWORD);
////            Asserts.fail(ResultCode.ERRORPASSWORD);
//        }
//        SecurityUserDetails securityUserDetails = new SecurityUserDetails(sysUserDTO, sysMenuService.findAllMenuList(sysUserDTO.getId()));
//        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(securityUserDetails, null, securityUserDetails.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String token = jwtTokenUtil.generateToken(securityUserDetails, securityUserDetails.getSysUserDTO().getId());
        return CommonResult.success(sysUserDTO);
    }

    @GetMapping("/get")
    public String get() {
        int i = 1 / 0;
        return "1";
    }
//    public static void main(String[] args) {
//        List<SysMenuReqVO> sysMenuDTOList = new ArrayList<SysMenuReqVO>() {{
//            add(SysMenuReqVO.builder().id(1L).name("菜单1").parentId(1L).url("/1/").build());
//            add(SysMenuReqVO.builder().id(2L).name("菜单2").parentId(2L).url("/2/").build());
//            add(SysMenuReqVO.builder().id(3L).name("菜单3").parentId(3L).url("/3/").build());
//            add(SysMenuReqVO.builder().id(4L).name("菜单4").parentId(4L).url("/4/").build());
//        }};
//        List<SimpleGrantedAuthority> collect = sysMenuDTOList.stream()
//                .map(resource -> new SimpleGrantedAuthority(resource.getId() + ":" + resource.getName() + ":" + resource.getParentId() + ":" + resource.getUrl()))
//                .collect(Collectors.toList());
//        for (SimpleGrantedAuthority simpleGrantedAuthority : collect) {
//            System.out.println(simpleGrantedAuthority.toString());
//        }
//    }

    @GetMapping("/buildpage")
    @ApiOperation("kai")
    public CommonResult buildPage(@RequestParam String name) {
        String result = testService.staticPageBuild(name);
        return CommonResult.success(result);
    }

}
