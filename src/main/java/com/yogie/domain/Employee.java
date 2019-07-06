package com.yogie.domain;

import javax.persistence.*;

/**
 * @program: aimoll
 * @Date: 2019/7/4 10:30
 * @Author: Chenyogie
 * @Description:
 */
@Entity
@Table(name = "employee")
public class Employee extends BaseDomain {

    private String username;
    private String password;
    private String email;
    private String headImage;
    private Integer age;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

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
