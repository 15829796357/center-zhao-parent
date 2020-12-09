package com.zhao.center.provider.service.impl;

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

    @Override
    public SysUserDTO loadUserByUsername(String name) {
        SysUser user = new SysUser();
        user.setName(name);
        SysUser sysUser = baseSysUserMapper.selectOne(user);
        return BeanMapper.map(sysUser,SysUserDTO.class);
    }
}
