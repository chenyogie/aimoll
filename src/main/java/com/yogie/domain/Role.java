package com.yogie.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * (Role)实体类
 *
 * @author Chenyogie
 * @since 2019-07-12 17:18:05
 */

@Entity
@Table(name = "role")
public class Role extends BaseDomain{
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色编码
     */
    private String sn;

    @ManyToMany
    @JoinTable(name = "role_permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<Permission> permissions = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}