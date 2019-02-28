package com.dnt.cloud.common.framework.feign.usercenter;

import com.dnt.cloud.common.framework.feign.usercenter.fallback.UserFeignClientFallbackFactory;
import com.dnt.cloud.common.framework.pojo.domain.usercenter.UserBase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * ProjectName: user-center-feign
 * InterfaceName: UserFeignClient
 * Date: 2018/12/20 19:49
 * Content: 使用feign远程访问用户为服务
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@FeignClient(name = "SUNCLOUD-USER-CENTER",
            fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {

    /**
     * 根据用户id获得用户信息
     * @param id    用户id
     * @return      用户对象
     */
    @RequestMapping(value = "/userBase/{id}",method = RequestMethod.GET)
    UserBase getUserBaseById(@PathVariable("id") Long id);

    /**
     * 添加用户对象
     * @param userBase  添加的用户对象
     * @return          添加的用户对象信息
     */
    @RequestMapping(value = "/userBase",method = RequestMethod.POST)
    UserBase postAddUserBase(@RequestBody UserBase userBase);

    /**
     * 修改用户对象
     * @param userBase  修改的用户对象
     * @return          修改的用户对象信息
     */
    @RequestMapping(value = "/userBase",method = RequestMethod.PUT)
    UserBase putUpdateUserBase(@RequestBody UserBase userBase);


    /**
     * 删除用户信息
     * @param id    删除用户的id
     * @return      删除的用户对象的信息
     */
    @RequestMapping(value = "/userBase/{id}",method = RequestMethod.DELETE)
    UserBase deleteUserBase(@PathVariable(value = "id") Long id);

    /**
     * 上传单个图片文件
     * @param fileName  文件名称
     * @param file      文件对象
     * @return          响应报文
     */
    @RequestMapping(value = "/userBase/upload",method = RequestMethod.PUT,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Map<String, Object> uploadAttachment(
            @RequestParam("fileName") String fileName,
            @RequestPart(value = "file") MultipartFile file);

    /**
     * 上传多个图片文件
     * @param fileName  文件名称
     * @param files      文件对象
     * @return          响应报文
     */
    @RequestMapping(value = "/userBase/upload",method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Map<String, Object> uploadAttachments(
            @RequestParam("fileName") String fileName,
            @RequestPart(value = "files") MultipartFile[] files);
}
