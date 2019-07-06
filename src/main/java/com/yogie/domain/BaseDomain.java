package com.yogie.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @program: aimoll
 * @Date: 2019/7/4 10:29
 * @Author: Chenyogie
 * @Description: 针对每个实体类的id字段，抽取一个公共的父类
 * MappedSuperclass： 此注解是防止jpa将这个类与数据库连接
 */
@MappedSuperclass
public class BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
