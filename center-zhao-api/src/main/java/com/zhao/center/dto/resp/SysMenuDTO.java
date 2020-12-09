package com.zhao.center.dto.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZCH
 * @Description 菜单
 * @since 2020/12/9$ 10:21$
 */
@Data
public class SysMenuDTO implements Serializable{
    private Long id;
    private String name;
    private Long parentId;
    private String url;
    private String perms;
    private Integer type;
    private String icon;
    private Integer orderNum;

}
