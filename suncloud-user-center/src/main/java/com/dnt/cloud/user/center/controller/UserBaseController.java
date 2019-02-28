package com.dnt.cloud.user.center.controller;

import com.dnt.cloud.common.framework.pojo.domain.usercenter.UserBase;
import com.dnt.cloud.user.center.service.UserBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * ProjectName: user-center
 * ClassName: UserBaseController
 * Date: 2018/12/20 12:40
 * Content: 测试用户模块的CURD
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@Slf4j
@RestController
@RequestMapping(value = "/userBase")
public class UserBaseController {

    @Autowired
    @Qualifier(value = "userBaseService")
    private UserBaseService userBaseService;

    /**
     * 根据用户id获得用户对象
     * @param id    用户id
     * @return      用户对象
     */
    @GetMapping(value = "/{id}")
    public UserBase getUserBaseById(
            @PathVariable(value = "id") Long id){

        return this.userBaseService.getOne(id);
    }


    /**
     * 添加用户对象
     * @param userBase  添加的用户对象
     * @return          添加的用户对象信息
     */
    @PostMapping
    public UserBase postAddUserBase(@RequestBody UserBase userBase){
        log.info("====添加user用户信息====入参userBase:{}",userBase);
        return userBase;

    }

    /**
     * 修改用户对象
     * @param userBase  修改的用户对象
     * @return          修改的用户对象信息
     */
    @PutMapping
    public UserBase putUpdateUserBase(@RequestBody UserBase userBase){
        log.info("====修改user用户信息====入参userBase:{}",userBase);
        return userBase;
    }

    /**
     * 删除用户信息
     * @param id    删除用户的id
     * @return      删除的用户对象的信息
     */
    @DeleteMapping(value = "/{id}")
    public UserBase deleteUserBase(
            @PathVariable(value = "id") Long id){
        log.info("====删除user用户信息====用户id:{}",id);
        UserBase user = this.userBaseService.getOne(id);
        return user;
    }

    /**
     * 上传单个图片
     * @param file  文件对象
     * @return
     */
    @PutMapping(value = "/upload")
    public Map<String,Object> uploadAttachment(
            @RequestParam("fileName") String fileName,
            @RequestPart("file") MultipartFile file){
        Map<String,Object> map = new HashMap<>(16);
        if (file == null){
            map.put("code","0001");
            map.put("msg","没有包含上传文件");
            return map;
        }

        log.info("====传入参数====fileName:{}",fileName);

        log.info("====上传单个文件参数====方法file.getSize():{}",file.getSize());
        log.info("====上传单个文件参数====方法file.getContentType():{}",file.isEmpty());

        log.info("====上传单个文件参数====方法file.getContentType():{}",file.getContentType());
        log.info("====上传单个文件参数====方法file.getName():{}",file.getName());
        log.info("====上传单个文件参数====方法file.getOriginalFilename():{}",file.getOriginalFilename());

        map.put("code","0000");
        map.put("msg","上传成功");

        return map;
    }


    /**
     * 上传多个文件
     * @param files     文件对象数组
     * @return          参数map
     */
    @PostMapping(value = "/uploads")
    public Map<String,Object> uploadAttachments(
            @RequestParam("fileName") String fileName,
            @RequestPart("files") MultipartFile [] files){
        Map<String,Object> map = new HashMap<>(16);

        int length = files.length;

        if (length == 0) {
            map.put("code","0001");
            map.put("msg","没有包含上传文件"+length);
            return map;
        }

        log.info("====传入参数====fileName:{}",fileName);

        for (int i = 0; i < length ; i++) {
            MultipartFile file = files[i];
            log.info("====上传文件参数====方法file.getSize():{}",file.getSize());
            log.info("====上传文件参数====方法file.getContentType():{}",file.isEmpty());

            log.info("====上传文件参数====方法file.getContentType():{}",file.getContentType());
            log.info("====上传文件参数====方法file.getName():{}",file.getName());
            log.info("====上传文件参数====方法file.getOriginalFilename():{}",file.getOriginalFilename());
        }

        map.put("code","0000");
        map.put("msg","上传成功");
        return map;
    }




}
