package com.zhao.center.provider.service.impl;

import com.zhao.center.api.SysDeptService;
import com.zhao.center.provider.mapper.SysDeptMapper;
import com.zhao.center.provider.model.SysDept;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ZCH
 * @Description 部门
 * @since 2020/12/8$ 17:06$
 */
@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptMapper baseSysDeptMapper;

}
