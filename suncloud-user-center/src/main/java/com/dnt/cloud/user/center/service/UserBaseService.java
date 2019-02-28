package com.dnt.cloud.user.center.service;

import com.dnt.cloud.common.framework.pojo.domain.usercenter.UserBase;

/**
 * ProjectName: user-center
 * InterfaceName: UserBaseService
 * Date: 2018/12/20 12:42
 * Content: 用户基本信息接口实现
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
public interface UserBaseService {

    /**
     * 根据用户ID获得用户对象
     * @param id    用户id
     * @return      用户对象
     */
    UserBase getOne(Long id);
}
