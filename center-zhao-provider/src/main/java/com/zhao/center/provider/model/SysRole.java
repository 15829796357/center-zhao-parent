package com.zhao.center.provider.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * @author ZCH
 * @Description 角色类
 * @since 2020/12/8$ 15:30$
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "sys_role")
public class SysRole extends BaseModel{

    private String name;

    private String remark;
}
