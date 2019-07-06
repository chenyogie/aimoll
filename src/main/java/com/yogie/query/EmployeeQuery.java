package com.yogie.query;

import com.github.wenhao.jpa.Specifications;
import com.yogie.domain.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

/**
 * @program: aimoll
 * @Date: 2019/7/4 22:43
 * @Author: Chenyogie
 * @Description:
 */
public class EmployeeQuery extends BaseQuery {

    //查询条件需要的字段
    private String username;
    private String email;
    private Integer age;

    /**
     * 创建query查询条件
     */
    @Override
    public Specification createSpec() {
        Specification<Employee> spec = Specifications.<Employee>and()
                .like(StringUtils.isNotBlank(username), "username", "%" + username + "%")
                .like(StringUtils.isNotBlank(email), "email", "%" + email + "%")
                .gt(age != null, "age", age)
                .build();
        return spec;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
