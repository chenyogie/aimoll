package com.yogie.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;

import javax.persistence.*;


/**
 * (Department)实体类
 *
 * @author Chenyogie
 * @since 2019-07-13 22:22:34
 */

@Entity
@Table(name = "department")
public class Department extends BaseDomain{

    @Excel(name = "部门名称")
    private String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}