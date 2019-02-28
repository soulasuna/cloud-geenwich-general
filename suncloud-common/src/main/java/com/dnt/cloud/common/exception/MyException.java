package com.dnt.cloud.common.exception;

import com.dnt.cloud.common.enumeration.ExceptionStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ProjectName: common
 * ClassName: MyException
 * Date: 2018/12/20 12:10
 * Content: 基于HttpCode的自定义异常
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class MyException extends RuntimeException {

    /*--------------------filed--------------------*/
    /**
     * 异常状态码
     */
    private Integer code;
    /**
     * 异常状态信息
     */
    private String message;

    /*--------------------constructor--------------------*/

    /**
     * 私有无参构造
     */
    private MyException() {
        super();
    }

    /**
     * 私有构造
     * @param exceptionEnum 异常枚举对象
     */
    private MyException(ExceptionStatusEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.initException(exceptionEnum);
    }

    /**
     * 有参构造
     * @param exceptionEnum 异常枚举对象
     * @param cause         异常对象
     */
    public MyException(ExceptionStatusEnum exceptionEnum, Throwable cause){
        super(exceptionEnum.getMessage(), cause);
        this.initException(exceptionEnum);
    }

    /**
     * 有参构造
     * @param code      异常code码
     * @param message   异常消息提示
     * @param cause     异常对象
     */
    public MyException(Integer code, String message, Throwable cause){
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    /*--------------------static_method--------------------*/

    /**
     * 静态获得对象的方法
     * @param exceptionEnum 异常枚举类
     * @return              异常对象
     */
    public static MyException getInstance(ExceptionStatusEnum exceptionEnum){
        return new MyException(exceptionEnum);
    }



    /*--------------------init_method--------------------*/

    /**
     * 根据异常状态枚举初始化异常
     * @param exceptionEnum 异常状态枚举
     */
    private void initException(ExceptionStatusEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }
}
