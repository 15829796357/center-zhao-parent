package com.zhao.center.provider.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * @author ZCH
 * @Description 菜单
 * @since 2020/12/8$ 15:36$
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "sys_menu")
public class SysMenu extends BaseModel{

    private String name;
    private Long parentId;
    private String url;
    private String perms;
    private Integer type;
    private String icon;
    private Integer orderNum;

}
