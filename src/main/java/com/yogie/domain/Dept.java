package com.yogie.domain;

import javax.persistence.*;


/**
 * (Dept)实体类
 *
 * @author Chenyogie
 * @since 2019-07-09 19:20:19
 */

@Entity
@Table(name = "dept")
public class Dept extends BaseDomain{
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}