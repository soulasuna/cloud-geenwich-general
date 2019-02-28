package com.dnt.cloud.user.center.service.impl;

import com.dnt.cloud.common.framework.pojo.domain.usercenter.UserBase;
import com.dnt.cloud.user.center.dao.UserBaseMapper;
import com.dnt.cloud.user.center.service.UserBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProjectName: user-center
 * ClassName: UserBaseServiceImpl
 * Date: 2018/12/20 12:43
 * Content: TODO
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@Slf4j
@Service(value = "userBaseService")
public class UserBaseServiceImpl implements UserBaseService {

    @Autowired
    private UserBaseMapper userBaseMapper;


    /**
     * 根据用户id获得用户对象
     * @param id    用户id
     * @return
     */
    @Override
    public UserBase getOne(Long id) {
        return this.userBaseMapper.getOne(id);
    }
}
