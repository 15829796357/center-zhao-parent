package com.zhao.center.web.dto.req;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZCH
 * @Description 菜单
 * @since 2020/12/9$ 9:31$
 */
@Data
@ApiModel("菜单")
@Builder
public class SysMenuReqVO implements Serializable{
    private Long id;
    private String name;
    private Long parentId;
    private String url;
    private String perms;
    private Integer type;
    private String icon;
    private Integer orderNum;
}
