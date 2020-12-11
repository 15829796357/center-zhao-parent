package com.zhao.center.api;

import com.zhao.center.dto.resp.SysUserDTO;

/**
 * @author ZCH
 * @Description ${DESCRIPTION}
 * @since 2020/12/8$ 15:09$
 */
public interface SysUserService {

    /**
     * 获取用户登录信息
     *
     * @param name
     * @return
     */
    SysUserDTO loadUserByUsername(String name);

//    UserDetails loadUserByUsername(String name);
}
