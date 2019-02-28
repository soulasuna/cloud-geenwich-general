package com.dnt.cloud.common.framework.pojo.vo;

import com.dnt.cloud.common.enumeration.HttpStatusEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * ProjectName: common
 * ClassName: ResultEntity
 * Date: 2019/1/2 14:30
 * Content: 统一响应报文
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@Data
public class ResultEntity<T> implements Serializable {

    /*--------------------filed--------------------*/

    /**
     * 交互状态码
     */
    private Integer code;
    /**
     * 交互状态码说明
     */
    private String message;
    /**
     * 交互信息
     */
    private T data;

    /*--------------------constructor--------------------*/

    /**
     * 无参构造
     */
    public ResultEntity(){
        super();
    }
    /**
     * 有参构造
     * @param httpStatusEnum    状态枚举对象
     * @param data              资源对象
     */
    public ResultEntity(HttpStatusEnum httpStatusEnum, T data){
        super();
        this.initResultEntity(httpStatusEnum,data);
    }
    /*--------------------init_method--------------------*/

    /**
     * 根据状态枚举类,资源对象初始化实体
     * @param httpStatusEnum    状态枚举对象
     * @param data              资源对象
     */
    private void initResultEntity(HttpStatusEnum httpStatusEnum, T data) {
        this.code = httpStatusEnum.getCode();
        this.message = httpStatusEnum.getMessage();
        this.data = data;
    }

}
