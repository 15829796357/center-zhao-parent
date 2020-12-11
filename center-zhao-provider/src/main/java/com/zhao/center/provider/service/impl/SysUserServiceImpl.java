package com.zhao.center.provider.service.impl;

import com.zhao.center.api.SysMenuService;
import com.zhao.center.api.SysUserService;
import com.zhao.center.dto.resp.SysUserDTO;
import com.zhao.center.provider.mapper.SysUserMapper;
import com.zhao.center.provider.model.SysUser;
import com.zhao.center.util.BeanMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ZCH
 * @Description 用户实现类
 * @since 2020/12/8$ 17:03$
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper baseSysUserMapper;
    @Autowired
    private SysMenuService sysMenuService;

//    @Override
//    public UserDetails loadUserByUsername(String name) {
//        SysUser user = new SysUser();
//        user.setName(name);
//        SysUser sysUser = baseSysUserMapper.selectOne(user);
//        if (sysUser != null) {
//            List<SysMenuDTO> resourceList = sysMenuService.findAllMenuList(sysUser.getId());
//            SysUserDTO sysUserDTO = BeanMapper.map(sysUser,SysUserDTO.class);
//            return new SecurityUserDetails(sysUserDTO,resourceList);
//        }
//        throw new UsernameNotFoundException("用户名或密码错误");
//    }

    @Override
    public SysUserDTO loadUserByUsername(String name) {
        SysUser user = new SysUser();
        user.setName(name);
        SysUser sysUser = baseSysUserMapper.selectOne(user);
        return BeanMapper.map(sysUser, SysUserDTO.class);
    }


}
