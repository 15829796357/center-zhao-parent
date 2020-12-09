package com.zhao.center.web.dto.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ZCH
 * @Description 角色列表
 * @since 2020/12/9$ 9:29$
 */
@Data
@ApiModel("角色列表")
public class SysRoleReqVO implements Serializable {

    private Long id;

    private String name;

    private String remark;

    private List<SysMenuReqVO> menuReqVOList;
}
