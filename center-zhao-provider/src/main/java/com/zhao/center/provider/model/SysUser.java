package com.zhao.center.provider.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ZCH
 * @Description 用户信息
 * @since 2020/12/8$ 15:05$
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "sys_user") // 通用mapper识别数据库  如果表明和类名 驼峰命名法一致 则可以不写 不一致添加
public class SysUser extends BaseModel{


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
