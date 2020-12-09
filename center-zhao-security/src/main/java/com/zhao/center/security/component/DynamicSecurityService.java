package com.zhao.center.security.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * 4
 * 我们之前在DynamicSecurityMetadataSource中
 * 注入了一个DynamicSecurityService对象，它是我
 * 自定义的一个动态权限业务接口，其主要用于加载所有的后台资源规则。
 *
 * 动态权限相关业务类
 * Created by macro on 2020/2/7.
 */
public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}
