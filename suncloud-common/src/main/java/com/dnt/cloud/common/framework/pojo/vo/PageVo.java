package com.dnt.cloud.common.framework.pojo.vo;

import com.dnt.cloud.common.constant.GlobalConstant;
import lombok.Data;

import java.io.Serializable;

/**
 * ProjectName: common
 * ClassName: PageVo
 * Date: 2019/1/2 17:47
 * Content: 分页查询VO对象
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@Data
public class PageVo implements Serializable {

    /*--------------------static_filed--------------------*/

    private static final int MAX_PAGE_ROWS = 50;
    private static final int DEFAULT_ROWS_PAGE = 20;

    private static final String DEFAULT_SORT_TYPE = "ASC";

    /*--------------------filed--------------------*/

    /**
     * 查询页数
     */
    private Integer page;
    /**
     * 单页显示条数
     */
    private Integer rows;
    /**
     * 排序字段名称
     * 默认使用id进行排序
     */
    private String sortField;
    /**
     * 排序方式
     * 默认使用asc
     */
    private String sortType;

    /*--------------------get/set--------------------*/

    /**
     * 获得查询当前页数
     * @return  当前页数
     */
    public Integer getPage() {
        if(this.page == null){
            this.page = 1;
        }
        return this.page;
    }

    /**
     * 获得查询单页条数
     * @return  单页条数
     */
    public Integer getRows() {
        if (this.rows > MAX_PAGE_ROWS) {
            this.rows = MAX_PAGE_ROWS;
        }else if (this.rows <= 0){
            this.rows = DEFAULT_ROWS_PAGE;
        }
        return this.rows;
    }

    /**
     * 获得排序字段
     * @return  排序字段的字段名
     */
    public String getSortField() {
        if (this.sortField == null || "".equals(this.sortField)){
            this.sortField = "id";
        }
        return this.sortField;
    }

    /**
     * 获得排序方式
     * @return  排序方式
     */
    public String getSortType () {
        if (GlobalConstant.PAGE_SORT_TYPE_DESC.equalsIgnoreCase(this.sortType)) {
            return this.sortType;
        }else {
            return DEFAULT_SORT_TYPE;
        }
    }

}
