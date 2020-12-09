package com.zhao.center.provider.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author ZCH
 * @Description 用户信息
 * @since 2020/12/8$ 11:24$
 */
@Data
@Table(name = "sys_user")
public class UserInfo implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String nickName;
}
