package com.zhao.center.web.config;

import com.zhao.center.api.SysMenuService;
import com.zhao.center.api.SysUserService;
import com.zhao.center.dto.resp.SysMenuDTO;
import com.zhao.center.security.component.DynamicSecurityService;
import com.zhao.center.security.config.SecurityConfig;
import com.zhao.center.web.dto.req.SecurityUserDetails;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZCH
 * @Description security配置类
 * @since 2020/12/9$ 10:13$
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends SecurityConfig {
    @Reference
    private SysUserService sysUserService;
    @Reference
    private SysMenuService sysMenuService;

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
//        //获取登录用户信息
//        return username -> sysUserService.loadUserByUsername(username);
        return username -> new SecurityUserDetails(sysUserService.loadUserByUsername(username),sysMenuService.findAllUserNameMenuList(username));
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<SysMenuDTO> resourceList = sysMenuService.findMenuAll();
                for (SysMenuDTO resource : resourceList) {
                    map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
                }
                return map;
            }
        };
    }

}
