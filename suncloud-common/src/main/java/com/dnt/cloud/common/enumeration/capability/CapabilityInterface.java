package com.dnt.cloud.common.enumeration.capability;

/**
 * ProjectName: common
 * InterfaceName: CapabilityInterface
 * Date: 2019/1/2 10:14
 * Content: 状态信息能力接口
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
public interface CapabilityInterface {
    /**
     * 获得状态码
     * @return  状态码
     */
    Integer getCode();

    /**
     * 获得状态描述
     * @return  状态信息
     */
    String getMessage();

}
