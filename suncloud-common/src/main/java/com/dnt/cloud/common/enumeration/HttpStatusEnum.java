package com.dnt.cloud.common.enumeration;

import com.dnt.cloud.common.enumeration.capability.CapabilityInterface;

/**
 * ProjectName: common
 * EnumName: HttpStatusEnum
 * Date: 2019/1/2 14:46
 * Content: 自定义http状态枚举
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
public enum HttpStatusEnum implements CapabilityInterface {

    /*--------------------2xx--------------------*/

    /**
     * 状态码200
     * 请求方式:get请求,幂等操作
     */
    SUCCESS{
        @Override
        public Integer getCode() {
            return 200;
        }

        @Override
        public String getMessage() {
            return "请求成功,获得资源";
        }
    },
    /**
     * 状态码201
     * 请求方式:post,put请求,非幂等操作
     */
    CREATED{
        @Override
        public Integer getCode() {
            return 201;
        }

        @Override
        public String getMessage() {
            return "请求成功,更新成功";
        }
    },
    /**
     * 状态码202
     * 异步任务请求已经处理
     */
    ACCEPTED{
        @Override
        public Integer getCode() {
            return 202;
        }

        @Override
        public String getMessage() {
            return "请求成功,正在处理";
        }
    },
    /**
     * 状态码204
     * 请求方式:get,delete请求,幂等操作
     */
    SUCCESS_NO_CONTENT{
        @Override
        public Integer getCode() {
            return 204;
        }

        @Override
        public String getMessage() {
            return "请求成功,暂无资源";
        }
    },

    /*--------------------4xx--------------------*/

    /**
     * 状态码400
     * 服务端不理解用户的请求,不做任何处理
     * 主要适用于前后台数据加解密
     */
    BAD_REQUEST{
        @Override
        public Integer getCode() {
            return 400;
        }

        @Override
        public String getMessage() {
            return "请求失败,错误信息";
        }
    },

    /**
     * 状态码401
     * 客户端请求身份验证失败(token,或者用户名密码)
     * 主要适用于用户登录验证
     */
    AUTHORIZED_FAILED{
        @Override
        public Integer getCode() {
            return 401;
        }

        @Override
        public String getMessage() {
            return "请求失败,验证失败";
        }
    },

    /**
     * 状态码403
     * 客户端请求没有权限访问
     * 主要适用于操作权限控制
     */
    PERMISSION_DENIED{
        @Override
        public Integer getCode() {
            return 403;
        }

        @Override
        public String getMessage() {
            return "请求失败,禁止访问";
        }
    },

    /**
     * 状态码422
     * 客户端上传的附件无法处理，导致请求失败。
     */
    UPLOAD_ATTACHMENT_FAILED{
        @Override
        public Integer getCode() {
            return 422;
        }

        @Override
        public String getMessage() {
            return "请求失败,上传失败";
        }
    },

    /**
     * 状态码429
     * 客户端的请求次数超过限额.
     */
    TOO_MANY_REQUESTS{
        @Override
        public Integer getCode() {
            return 429;
        }

        @Override
        public String getMessage() {
            return "请求失败,过于频繁";
        }
    }


}
