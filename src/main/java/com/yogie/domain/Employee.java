package com.yogie.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: aimoll
 * @Date: 2019/7/4 10:30
 * @Author: Chenyogie
 * @Description:
 */
@Entity
@Table(name = "employee")
public class Employee extends BaseDomain {

    @Excel(name = "用户名")
    @NotNull(message = "用户名不能为空。")
    private String username;
    private String password;
    @Excel(name = "邮箱",width = 25)
    private String email;
    @Excel(name = "头像",type = 2,width = 10,height = 20)
    private String headImage;
    @Excel(name = "年龄")
    private Integer age;
    private Boolean status;//true：代表可用；false：代表禁用

    /**
     * 员工与部门之间的关系是多对一
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @ExcelEntity
    private Department department;

    /**
     * 员工与权限之间的关系是多对多
     * @return
     */
    @ManyToMany
    @JoinTable(name = "employee_role",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", headImage='" + headImage + '\'' +
                ", age=" + age +
                ", department=" + department +
                ", id=" + id +
                '}';
    }
}
