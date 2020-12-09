package com.zhao.center.util;

import java.io.Serializable;

/**
 * @author ZCH
 * @Description 分页请求
 * @since 2020/11/27$ 15:35$
 */
public class PageParam<T> implements Serializable{
    //  description = "页码", defaultValue =  1
    private Integer pageNum = 1;

    // description = "页数", defaultValue = 20
    private Integer pageSize = 10;

    // description = "排序", example = "id desc"
    private String orderBy;

    //  description = "参数"
    private T param;

    public PageParam<T> setOrderBy(String orderBy) {
        this.orderBy = orderBy; // 此处可优化 优化详情且看解析
        return this;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }
}
