package com.zhao.center.provider.mapper;

import com.zhao.center.provider.model.SysMenu;
import com.zhao.center.provider.utils.BaseComMapper;

import java.util.List;

/**
 * @author ZCH
 * @Description ${DESCRIPTION}
 * @since 2020/12/8$ 15:37$
 */
public interface SysMenuMapper extends BaseComMapper<SysMenu> {

    List<SysMenu> findAllUserIdMenu(Long userId);
    List<SysMenu> findAllUserNameIdMenu(String username);
    List<SysMenu> findMenuAll();
}
