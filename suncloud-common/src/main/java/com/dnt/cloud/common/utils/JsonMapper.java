package com.dnt.cloud.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/**
 * ProjectName: common
 * ClassName: JsonMapper
 * Date: 2019/2/14 14:56
 * Content: json操作工具类默认使用Jackson
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@Slf4j
public final class JsonMapper {

    /*--------------------static--------------------*/

    public static final JsonMapper INSTANCE = new JsonMapper();
    private ObjectMapper mapper;

    /*--------------------constructor--------------------*/
    /**
     * 私有构造
     */
    private JsonMapper() {
        this(null);
    }

    /**
     * 有参构造
     * @param include   json输出风格
     */
    private JsonMapper(Include include) {
        mapper = new ObjectMapper();
        if (include != null) {
            mapper.setSerializationInclusion(include);
        }
        /**
         * 忽略在JSON字符串中存在但Java对象实际没有的属性
         */
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    /*--------------------static_mapper--------------------*/

    /**
     * 默认的全部输出的Mapper,
     * 区别于INSTANCE，可以做进一步的配置
     */
    public static JsonMapper defaultMapper() {
        return new JsonMapper();
    }

    /**
     * 创建只输出非Null的属性到Json字符串的Mapper.
     */
    public static JsonMapper nonNullMapper() {
        return new JsonMapper(Include.NON_NULL);
    }

    /**
     * 创建只输出非Null且非Empty(如List.isEmpty)的属性到Json字符串的Mapper.
     * 注意，要小心使用, 特别留意empty的情况.
     */
    public static JsonMapper nonEmptyMapper() {
        return new JsonMapper(Include.NON_EMPTY);
    }

    /**
     * 取出Mapper做进一步的设置或使用其他序列化API.
     */
    public ObjectMapper getMapper() {
        return mapper;
    }

    /*--------------------Object_to_JSON--------------------*/

    /**
     * object转换json字符串
     * @param t     转换对象
     * @param <T>   泛型的类型可以是pojo,Array,Collection,Map
     * @return      object为null时返回:null
     *              object为空Array,Collection时返回:"[]"
     *              object为空Map时返回:"{}"
     */
    public <T> String toJson(T t) {
        try {
            return mapper.writeValueAsString(t);
        } catch (IOException e) {
            log.error("error : object parse to json failed!");
            log.error("error message:{} , object:{}", e, t);
            return null;
        }
    }

    /**
     * object转换成JSONP格式的json字符串
     * @param functionName  回调方法的名称
     * @param t             转换对象
     * @param <T>           泛型的类型可以是pojo,Array,Collection,Map
     * @return              object为null时返回:"functionName(null)"
     *                      object为空Array,Collection时返回:"functionName([])"
     *                      object为空Map时返回"functionName({})"
     */
    public <T> String toJsonP(String functionName, T t) {
        return toJson(new JSONPObject(functionName, t));
    }


    /*--------------------JSON_to_Object--------------------*/

    /**
     * json字符串转换成简单的pojo,Array,Collection,Map
     * 集合的泛型必须是简单泛型,例如String类型
     *
     * @param jsonString    json字符串
     * @param clazz         简单的java类型
     * @param <T>           转换后数据类型
     * @return              json为null,"","null"时返回值null
     *
     */
    public <T> T fromJson(String jsonString, Class<T> clazz) {
        if (StringUtils.isBlank(jsonString)) {
            return null;
        }
        try {
            return mapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            log.error("error : json parse to object failed !");
            log.error("error message:{}, json:{}, clazz:{}", e, jsonString, clazz.getName());
            return null;
        }
    }

    /**
     * json字符串转换成复杂的Array,Collection,Map
     * 集合的泛型可以是复杂的类型,例如pojo
     *
     * @param jsonString    json字符串
     * @param javaType      Collection类型,Map类型
     * @param <T>           转换后数据类型
     * @return              json为null,"","null"时返回值null
     *
     */
    public <T> T fromJson(String jsonString, JavaType javaType) {
        if (StringUtils.isBlank(jsonString)) {
            return null;
        }
        try {
            return mapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            log.error("error : json parse to object failed !");
            log.error("error message:{}, json:{}, javaType:{}", e, jsonString, javaType.getTypeName());
            return null;
        }
    }


    /*--------------------tools_method--------------------*/

    /**
     * 构造Collection类型.
     * @param collectionClass   单列集合的字节码对象
     * @param elementClass      集合元素的字节码对象
     * @return                  构造的Collection集合类型
     */
    public JavaType buildCollectionType(Class<? extends Collection> collectionClass, Class<?> elementClass) {
        return mapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
    }

    /**
     *
     * @param mapClass      Map集合的字节码对象
     * @param keyClass      key类型的字节码对象
     * @param valueClass    value类型的字节码对象
     * @return              构造的Map集合类型
     */
    public JavaType buildMapType(Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass) {
        return mapper.getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
    }


}
