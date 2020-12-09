package com.zhao.center.provider.service.impl;

import com.zhao.center.api.SysRoleService;
import com.zhao.center.provider.mapper.SysRoleMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ZCH
 * @Description 角色实现类
 * @since 2020/12/8$ 16:02$
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

}
