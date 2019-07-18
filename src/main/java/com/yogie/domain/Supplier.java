package com.yogie.domain;

import javax.persistence.*;


/**
 * (Supplier)实体类
 *
 * @author Chenyogie
 * @since 2019-07-17 11:41:27
 */

@Entity
@Table(name = "supplier")
public class Supplier extends BaseDomain {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}