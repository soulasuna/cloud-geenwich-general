package com.dnt.cloud.common.constant;

import com.dnt.cloud.common.enumeration.ExceptionStatusEnum;
import com.dnt.cloud.common.exception.MyException;

/**
 * ProjectName: common
 * InterfaceName: ExceptionConstant
 * Date: 2019/2/26 17:54
 * Content: 常用系统异常常量
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
public interface ExceptionConstant {
    /**
     * 业务层参数校验自定义异常
     */
    MyException ERROR_PARAM_EXCEPTION = MyException.getInstance(ExceptionStatusEnum.ERROR_PARAM_EXCEPTION);
    MyException MISS_PARAM_EXCEPTION = MyException.getInstance(ExceptionStatusEnum.MISS_PARAM_EXCEPTION);

    /**
     * 数据访问层校验自定义异常
     */
    MyException SQL_ERROR_PARAM_EXCEPTION = MyException.getInstance(ExceptionStatusEnum.SQL_ERROR_EXCEPTION);
    MyException SQL_MISS_PARAM_EXCEPTION = MyException.getInstance(ExceptionStatusEnum.SQL_MISS_EXCEPTION);

}
