package com.zhao.center.provider.service.impl;

import com.zhao.center.api.SysMenuService;
import com.zhao.center.dto.resp.SysMenuDTO;
import com.zhao.center.provider.mapper.SysMenuMapper;
import com.zhao.center.provider.model.SysMenu;
import com.zhao.center.util.BeanMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ZCH
 * @Description 菜单
 * @since 2020/12/8$ 17:05$
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper baseSysMenuMapper;

    @Override
    public List<SysMenuDTO> findAllMenuList(Long userId) {
        List<SysMenu> sysMenuList = baseSysMenuMapper.findAllUserIdMenu(userId);
        return BeanMapper.mapList(sysMenuList,SysMenuDTO.class);
    }

    @Override
    public List<SysMenuDTO> findMenuAll() {
        List<SysMenu> sysMenuList = baseSysMenuMapper.findMenuAll();
        return BeanMapper.mapList(sysMenuList,SysMenuDTO.class);
    }

    @Override
    public List<SysMenuDTO> findAllUserNameMenuList(String username) {
        List<SysMenu> sysMenuList = baseSysMenuMapper.findAllUserNameIdMenu(username);
        return BeanMapper.mapList(sysMenuList,SysMenuDTO.class);
    }
}
