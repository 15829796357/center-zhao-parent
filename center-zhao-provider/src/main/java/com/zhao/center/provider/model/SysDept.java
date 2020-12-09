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
@Table(name = "sys_dept")
public class SysDept extends BaseModel {


    private String name;

    private Integer parentId;

    private Integer orderNum;

}
