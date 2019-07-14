package com.yogie.domain;

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
    
    private String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}