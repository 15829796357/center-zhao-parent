package com.zhao.center.provider.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author ZCH
 * @Description 通用字段设置
 * @since 2020/12/8$ 15:06$
 */
@Data
public class BaseModel {
    @Id
    @GeneratedValue(generator = "JDBC")//获取数据库自增的主键
    private Long id;
    private String createBy;
    private Date createTime;
    private String lastUpdateBy;
    private Date lastUpdateTime;
    private Integer delFlag;
}
