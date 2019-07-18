package com.yogie.domain;

import javax.persistence.*;


/**
 * (Producttype)实体类
 *
 * @author Chenyogie
 * @since 2019-07-16 10:43:45
 */

@Entity
@Table(name = "producttype")
public class Producttype extends BaseDomain{
    
    private String name;
    
    private String descs;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Producttype parent;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public Producttype getParent() {
        return parent;
    }

    public void setParent(Producttype parent) {
        this.parent = parent;
    }
}