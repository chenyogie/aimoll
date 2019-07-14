package com.yogie.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * (Menu)实体类
 *
 * @author Chenyogie
 * @since 2019-07-13 20:38:19
 */

@Entity
@Table(name = "menu")
public class Menu extends BaseDomain{
    
    private String name;
    
    private String url;
    
    private String icon;

    /**
     * 子菜单对于父菜单来说是多对一的关系
     * JsonIgnore : 生成json数据的时候，子菜单不再找父菜单
     * 解决了生成json数据的时候死循环应用的问题。
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    private Menu parent;

    /**
     * 父菜单对于子菜单来说是一对多的关系
     * 注意：
     *      1.这里不能配置OneToMany，否则会导致权限失效。
     *      2.这个子菜单项应该由我们手动控制。
     * Transient 临时属性（jpa会忽略这个属性，和数据库没有关系）
     */
    @Transient
    private List<Menu> children = new ArrayList<>();
    

    
    public String getName() {
        return name;
    }

    /**
     * 这里这么设计的原因是前台easyui框架接收的属性名必须是text
     */
    public String getText() {
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
    
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}