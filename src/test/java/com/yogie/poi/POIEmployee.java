package com.yogie.poi;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @program: aimoll
 * @Date: 2019/7/14 10:36
 * @Author: Chenyogie
 * @Description:
 */
public class POIEmployee {

    @Excel(name = "序号")
    private Long id;
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "邮箱",width = 20)
    private String email;
    @Excel(name = "性别",replace = { "男_true", "女_false" })
    private Boolean sex = true;
    @Excel(name = "头像",type = 2 ,width = 10 , height = 20)
    private String headImg;
    private POIDepartment department;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}
