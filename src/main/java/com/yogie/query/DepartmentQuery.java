package com.yogie.query;

import com.github.wenhao.jpa.Specifications;
import com.yogie.domain.Department;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

/**
 * @program: aimoll
 * @Date: 2019/7/6 22:00
 * @Author: Chenyogie
 * @Description:
 */
public class DepartmentQuery extends BaseQuery {

    private String name;

    @Override
    public Specification createSpec() {
        Specification<Department> spec = Specifications.<Department>and()
                .like(StringUtils.isNotBlank(this.name), "name", "%" + this.name + "%")
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
