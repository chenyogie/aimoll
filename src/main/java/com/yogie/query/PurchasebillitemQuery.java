package com.yogie.query;


import com.github.wenhao.jpa.Specifications;
import com.yogie.domain.Purchasebillitem;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (Purchasebillitem)实体类
 *
 * @author Chenyogie
 * @since 2019-07-17 09:50:18
 */

public class PurchasebillitemQuery extends BaseQuery {

    private Date beginDate;

    private Date endDate;

    private Integer status;

    //默认以供应商分组
    private Integer groupBy = 0;

    //where条件的参数
    private List<Object> params = new ArrayList<>();

    /**
     * 创建query查询条件
     */
    @Override
    public Specification createSpec() {
        Date tempDate = null;
        //日期的结束条件
        if(endDate!=null) {
            tempDate = DateUtils.addDays(endDate, 1);
        }
        /**
         * Specifications:是com.github.wenhao.jpa插件的类
         */
        Specification<Purchasebillitem> spec = Specifications.<Purchasebillitem>and()
                .eq(status!=null,"bill.status",status)
                .ge(beginDate!=null,"bill.vdate",beginDate)
                .lt(tempDate!=null,"bill.vdate",tempDate)
                .build();
        return spec;
    }

    /**
     * 获取分组的字段
     * @return
     */
    public String getGroupByStr(){
        if(groupBy==1){
            //采购员
            return "o.bill.buyer.username";
        }else if(groupBy==2){
            //月份
            return "Month(o.bill.vdate)";
        }else{
            //供应商
            return "o.bill.supplier.name";
        }
    }

    /**
     * 条件拼接
     * @return
     */
    public String getWhereJpql(){
        StringBuilder jpql =  new StringBuilder();
        if(beginDate!=null){
            jpql.append(" and o.bill.vdate >= ? ");
            params.add(beginDate);
        }
        if(endDate!=null){
            //返回新的值，就是加一天的值
            Date tempDate = DateUtils.addDays(endDate, 1);
            jpql.append(" and o.bill.vdate < ? ");
            params.add(tempDate);
        }
        if(status!=null){
            jpql.append(" and o.bill.status =? ");
            params.add(status);
        }
        return jpql.toString().replaceFirst("and","where");
    }

    public Date getBeginDate() {
        return beginDate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(Integer groupBy) {
        this.groupBy = groupBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Object> getParams() {
        return params;
    }

    public void setParams(List<Object> params) {
        this.params = params;
    }
}