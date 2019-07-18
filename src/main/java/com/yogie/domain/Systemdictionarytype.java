package com.yogie.domain;

import javax.persistence.*;


/**
 * (Systemdictionarytype)实体类
 *
 * @author Chenyogie
 * @since 2019-07-16 16:08:58
 */

@Entity
@Table(name = "systemdictionarytype")
public class Systemdictionarytype extends BaseDomain{

    public static final String PRODUCT_BRAND = "productBrand";
    public static final String PRODUCT_UNIT = "productUnit";

    //分类类型
    private String name;

    //分类字段
    @Column(updatable = false)
    private String sn;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}