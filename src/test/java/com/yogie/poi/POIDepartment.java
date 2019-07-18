package com.yogie.poi;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @program: aimoll
 * @Date: 2019/7/14 14:09
 * @Author: Chenyogie
 * @Description:
 */
public class POIDepartment {

    @Excel(name = "序号")
    private Long id;

    @Excel(name = "部门名称")
    private String name;

    @Excel(name = "办公地址")
    private String address;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
