package com.dnt.cloud.user.center.dao;

import com.dnt.cloud.common.framework.pojo.domain.usercenter.UserBase;
import org.apache.ibatis.annotations.Mapper;

/**
 * ProjectName: user-center
 * InterfaceName: UserBaseMapper
 * Date: 2019/2/27 10:41
 * Content: TODO
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@Mapper
public interface UserBaseMapper {

    /**
     *
     * @param id
     * @return
     */
    UserBase getOne(Long id);
}
