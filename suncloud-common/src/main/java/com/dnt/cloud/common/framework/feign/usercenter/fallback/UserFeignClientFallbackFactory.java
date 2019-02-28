package com.dnt.cloud.common.framework.feign.usercenter.fallback;

import com.dnt.cloud.common.framework.feign.usercenter.UserFeignClient;
import com.dnt.cloud.common.framework.pojo.domain.usercenter.UserBase;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * ProjectName: common
 * ClassName: UserFeignClientFallbackFactory
 * Date: 2018/12/21 17:45
 * Content: 服务降级,断路实现
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient(){
            /**
             * 查询用户
             * @param id    用户id
             * @return      默认用户
             */
            @Override
            public UserBase getUserBaseById(Long id) {
                UserBase user = new UserBase();
                user.setId(0L);
                user.setUserName("select");
                user.setPassWord("123456");
                return user;
            }

            /**
             * 添加用户信息
             * @param userBase  添加的用户对象
             * @return          默认用户
             */
            @Override
            public UserBase postAddUserBase(UserBase userBase) {
                UserBase user = new UserBase();
                user.setId(0L);
                user.setUserName("insert");
                user.setPassWord("123456");
                return user;
            }

            /**
             * 修改用户信息
             * @param userBase  修改的用户对象
             * @return          默认用户
             */
            @Override
            public UserBase putUpdateUserBase(UserBase userBase) {
                UserBase user = new UserBase();
                user.setId(0L);
                user.setUserName("update");
                user.setPassWord("123456");
                return user;
            }

            /**
             * 删除用户信息
             * @param id    删除用户的id
             * @return      删除用户的信息
             */
            @Override
            public UserBase deleteUserBase(Long id) {
                UserBase user = new UserBase();
                user.setId(0L);
                user.setUserName("delete");
                user.setPassWord("123456");
                return null;
            }

            /**
             * 文件上传单个文件
             * @param file  文件对象
             * @return
             */
            @Override
            public Map<String, Object> uploadAttachment(String fileName, MultipartFile file) {
                Map<String,Object> map = new HashMap<>(16);
                map.put("code","0002");
                map.put("msg","文件服务器繁忙");
                return map;
            }

            /**
             * 文件上传多个文件
             * @param files 文件对象数组
             * @return
             */
            @Override
            public Map<String, Object> uploadAttachments(String fileName, MultipartFile[] files) {
                Map<String,Object> map = new HashMap<>(16);
                map.put("code","0002");
                map.put("msg","文件服务器繁忙");
                return map;
            }
        };
    }
}
