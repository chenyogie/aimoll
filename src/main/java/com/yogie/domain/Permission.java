package com.yogie.domain;

import javax.persistence.*;


/**
 * (Permission)实体类
 *
 * @author Chenyogie
 * @since 2019-07-12 17:18:04
 */

@Entity
@Table(name = "permission")
public class Permission extends BaseDomain{
    
    private String name;

    /**
     * 权限对应的资源
     */
    private String url;
    
    private String descs;

    /**
     * 对象的权限名称
     */
    private String sn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;
    
    /*private Long menuId;*/

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }
    
    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}