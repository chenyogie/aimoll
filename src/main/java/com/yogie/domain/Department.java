package com.yogie.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @program: aimoll
 * @Date: 2019/7/6 19:06
 * @Author: Chenyogie
 * @Description:
 */
@Entity
@Table(name = "department")
public class Department extends BaseDomain {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
