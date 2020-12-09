package com.zhao.center.dto.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZCH
 * @Description 用
 * @since 2020/12/8$ 14:13$
 */
@Data
public class UserInfoDTO implements Serializable{

    private Long id;

    private String userCode;
}
