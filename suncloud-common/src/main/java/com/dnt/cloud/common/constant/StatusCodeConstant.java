package com.dnt.cloud.common.constant;

/**
 * ProjectName: common
 * InterfaceName: StatusCodeConstant
 * Date: 2019/1/2 10:17
 * Content: 状态码常量
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
public interface StatusCodeConstant {

    /*--------------------http_code--------------------*/




    /*--------------------error_code--------------------*/

    /**
     * 接口错误参数异常状态码
     * 接口错误参数异常状态信息
     */
    Integer ERROR_PARAM_STATUS_CODE = 506;
    String ERROR_PARAM_STATUS_MESSAGE = "error : my exception function param error !";

    /**
     * 接口缺少必传参数异常状态码
     * 接口缺少必传参数异常状态信息
     */
    Integer MISS_PARAM_STATUS_CODE = 507;
    String MISS_PARAM_STATUS_MESSAGE = "error : my exception function miss param !";

    /**
     * 数据库异常状态码
     * 数据库异常状态信息
     */
    Integer SQL_ERROR_STATUS_CODE = 508;
    String SQL_ERROR_STATUS_MESSAGE = "error : my exception sql param error !";

    /**
     * 数据库异常状态码
     * 数据库异常状态信息
     */
    Integer SQL_MISS_STATUS_CODE = 509;
    String SQL_MISS_STATUS_MESSAGE = "error : my exception sql miss param !";


    /*--------------------status_code--------------------*/


}
