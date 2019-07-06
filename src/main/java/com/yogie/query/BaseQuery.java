package com.yogie.query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

/**
 * @program: aimoll
 * @Date: 2019/7/4 19:27
 * @Author: Chenyogie
 * @Description: 继承公共的父类
 */

public abstract class BaseQuery {

    private Integer currentPage = 1;
    private Integer pageSize = 10;

    private String orderName;//根据哪个字段进行排序
    private String orderType = "ASC"; //指定排序的规则，默认为增长

    /**
     * 创建一个抽象方法，规范子类创建对应的方法
     */
    public abstract Specification createSpec();

    /**
     * 创建排序的对象
     */
    public Sort createSort(){
        //StringUtils类是apache.commons.lang3下的工具类包
        if(StringUtils.isNotBlank(orderName)){
            return new Sort(Sort.Direction.valueOf(orderType.toUpperCase()),orderName);
        }
        return null;
    }

    public Integer getCurrentPage() {
        //jpa分页查询是从0开始计算
        return currentPage -1 ;
    }

    /**
     * 解决前台参数与后台参数不一致的方案
     * @param page 分页查询当前页
     */
    public void setPage(Integer page){
        this.currentPage = page;
    }

    /**
     * 解决前台参数与后台参数不一致的方案
     * @param rows 分页查询的每页数据容量
     */
    public void setRowS(Integer rows){
        this.pageSize = rows;
    }

    /**
     * 解决前台参数与后台参数不一致的方案
     * 排序查询
     * @param sort 排序的字段
     */
    public void setSort(String sort){
        this.orderName = sort;
    }

    /**
     *解决前台参数与后台参数不一致的方案
     * 排序查询
     * @param order 排序的类型
     */
    public void setOrder(String order){
        this.orderType = order.toUpperCase();
    }


    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize ;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

}
