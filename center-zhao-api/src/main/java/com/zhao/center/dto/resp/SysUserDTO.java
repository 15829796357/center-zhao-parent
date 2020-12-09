package com.zhao.center.dto.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZCH
 * @Description 用户信息
 * @since 2020/12/8$ 15:10$
 */
@Data
public class SysUserDTO implements Serializable {
    private Long id;
    private String name;
    private String nickName;
    private String avatar;
    private String password;
    private String salt;
    private String email;
    private String mobile;
    private Integer status;
    private Long deptId;
}
