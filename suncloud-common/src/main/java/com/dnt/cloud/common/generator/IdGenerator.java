package com.dnt.cloud.common.generator;

import com.dnt.cloud.common.utils.SnowflakeIdWorker;

/**
 * ProjectName: common
 * ClassName: IdGenerator
 * Date: 2019/1/16 13:21
 * Content: 唯一识别码生成器
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
public final class IdGenerator {

    /**
     * 基于雪花算法分布式id生成方法
     * 返回一个自增唯一的Long类型的id
     *
     * @return      自增19位long类型的id
     */
    public static Long generatorId(){
        return SnowflakeIdWorker.generateId();
    }




}
