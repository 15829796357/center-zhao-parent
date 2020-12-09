package com.zhao.center.api;

import com.zhao.center.dto.resp.SysMenuDTO;

import java.util.List;

/**
 * @author ZCH
 * @Description ${DESCRIPTION}
 * @since 2020/12/8$ 17:03$
 */
public interface SysMenuService {

    /**
     * 获取权限
     * @param userId
     * @return
     */
    List<SysMenuDTO> findAllMenuList(Long userId);

    List<SysMenuDTO> findMenuAll();

    List<SysMenuDTO> findAllUserNameMenuList(String username);

}
