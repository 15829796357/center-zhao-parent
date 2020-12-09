package com.zhao.center.web.dto.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ZCH
 * @Description 用户信息
 * @since 2020/12/9$ 9:23$
 */
@Data
@ApiModel("用户信息")
public class SysUserReqVO implements Serializable {

    private String name;
    private String nickName;
    private String mobile;
    private Long deptId;

    private String deptName;

    private List<SysRoleReqVO> reqVOList;
}
