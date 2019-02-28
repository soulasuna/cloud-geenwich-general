package com.dnt.cloud.common.enumeration;

import com.dnt.cloud.common.constant.StatusCodeConstant;
import com.dnt.cloud.common.enumeration.capability.CapabilityInterface;

/**
 * ProjectName: common
 * EnumName: ExceptionStatusEnum
 * Date: 2019/1/2 10:05
 * Content: 自定义异常状态枚举
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
public enum ExceptionStatusEnum implements CapabilityInterface {

    /**
     * 接口参数错误
     */
    ERROR_PARAM_EXCEPTION{
        @Override
        public Integer getCode() {
            return StatusCodeConstant.ERROR_PARAM_STATUS_CODE;
        }

        @Override
        public String getMessage() {
            return StatusCodeConstant.ERROR_PARAM_STATUS_MESSAGE;
        }
    },

    /**
     * 接口缺少必要参数
     */
    MISS_PARAM_EXCEPTION{
        @Override
        public Integer getCode() {
            return StatusCodeConstant.MISS_PARAM_STATUS_CODE;
        }

        @Override
        public String getMessage() {
            return StatusCodeConstant.MISS_PARAM_STATUS_MESSAGE;
        }
    },

    /**
     * 数据库参数错误
     */
    SQL_ERROR_EXCEPTION{
        @Override
        public Integer getCode() {
            return StatusCodeConstant.SQL_ERROR_STATUS_CODE;
        }

        @Override
        public String getMessage() {
            return StatusCodeConstant.SQL_ERROR_STATUS_MESSAGE;
        }
    },

    /**
     * 数据库缺少必要参数
     */
    SQL_MISS_EXCEPTION{
        @Override
        public Integer getCode() {
            return StatusCodeConstant.SQL_MISS_STATUS_CODE;
        }

        @Override
        public String getMessage() {
            return StatusCodeConstant.SQL_MISS_STATUS_MESSAGE;
        }
    }

}
