package com.dnt.cloud.common.framework.pojo.domain.usercenter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * ProjectName: common
 * ClassName: UserBase
 * Date: 2018/12/20 10:09
 * Content: 用户基本表实体类
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@ApiModel(value = "UserBase", description = "用户基本信息")
@Data
@ToString(callSuper = true)
public class UserBase {
    /**
     * 用户id
     */
    @ApiModelProperty(value="id", name="id", dataType = "Long")
    private Long id;
    /**
     * 用户名称
     */
    @ApiModelProperty(value="用户名", name="userName", dataType = "String")
    private String userName;
    /**
     * 用户密码
     */
    @ApiModelProperty(value="用户密码", name="passWord", dataType = "String")
    private String passWord;
}
