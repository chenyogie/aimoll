package com.yogie.domain;

import javax.persistence.*;


/**
 * (Systemdictionarydetail)实体类
 *
 * @author Chenyogie
 * @since 2019-07-16 10:43:46
 */

@Entity
@Table(name = "systemdictionarydetail")
public class Systemdictionarydetail extends BaseDomain{
    
    private String name;

    @ManyToOne
    @JoinColumn(name = "types_id")
    private Systemdictionarytype type;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Systemdictionarytype getType() {
        return type;
    }

    public void setType(Systemdictionarytype type) {
        this.type = type;
    }
}