package com.yogie.query;


import com.github.wenhao.jpa.Specifications;
import com.yogie.domain.PurchaseBill;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * (Purchasebill)实体类
 *
 * @author Chenyogie
 * @since 2019-07-17 09:50:16
 */

public class PurchaseBillQuery extends BaseQuery {

    //查询条件需要的字段
    private Integer status;
    private Date beginDate;
    private Date endDate;

    /**
     * 创建query查询条件
     */
    @Override
    public Specification createSpec() {

        Date tempDate = null;
        //时间区间，结束时间要加上一天
        if(endDate!=null){
            tempDate = DateUtils.addDays(endDate, 1);
        }

        /**
         * Specifications:是com.github.wenhao.jpa插件的类
         */
        Specification<PurchaseBill> spec = Specifications.<PurchaseBill>and()
                .eq(status!=null, "status", status)
                .ge(beginDate!=null,"vdate",beginDate)
                .le(endDate!=null,"vdate",tempDate)
                .build();
        return spec;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}