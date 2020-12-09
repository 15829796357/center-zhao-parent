package com.zhao.center.provider.service.impl;

import com.zhao.center.api.UserInfoService;
import com.zhao.center.dto.req.UserInfoDTO;
import com.zhao.center.provider.mapper.UserInfoMapper;
import com.zhao.center.provider.model.UserInfo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ZCH
 * @Description 用户实现
 * @since 2020/12/8$ 14:12$
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfoDTO findById() {
        UserInfo user = new UserInfo();
        user.setId(1L);
        UserInfo userInfo = userInfoMapper.selectOne(user);
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setId(userInfo.getId());
        userInfoDTO.setUserCode(userInfo.getNickName());
        return userInfoDTO;
    }
}
