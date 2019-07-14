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
    private Long department_id;
    private Boolean status = true; //默认为true，显示可用的账户

    /**
     * 创建query查询条件
     */
    @Override
    public Specification createSpec() {
        /**
         * Specifications:是com.github.wenhao.jpa插件的类
         */
        Specification<Employee> spec = Specifications.<Employee>and()
                .eq(status!=null,"status",status)
                .like(StringUtils.isNotBlank(username), "username", "%" + username + "%")
                .like(StringUtils.isNotBlank(email), "email", "%" + email + "%")
                .gt(age != null, "age", age)
                .eq(department_id != null, "department.id", department_id)
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

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
