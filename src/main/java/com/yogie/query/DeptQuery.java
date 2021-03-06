package com.yogie.query;


import com.github.wenhao.jpa.Specifications;
import com.yogie.domain.Dept;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

/**
 * (Dept)实体类
 *
 * @author Chenyogie
 * @since 2019-07-09 17:09:05
 */

public class DeptQuery extends BaseQuery {

    //查询条件需要的字段
    private String name;

    /**
     * 创建query查询条件
     */
    @Override
    public Specification createSpec() {
        /**
         * Specifications:是com.github.wenhao.jpa插件的类
         */
        Specification<Dept> spec = Specifications.<Dept>and()
                .like(StringUtils.isNotBlank(name), "name", "%" + name + "%")
                .build();
        return spec;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}