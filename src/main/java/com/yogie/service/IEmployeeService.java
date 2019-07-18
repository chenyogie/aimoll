package com.yogie.service;

import com.yogie.domain.Employee;

import java.util.List;

/**
 * @program: aimoll
 * @Date: 2019/7/5 12:04
 * @Author: Chenyogie
 * @Description:
 */
public interface IEmployeeService extends IBaseService<Employee,Long> {
    Boolean checkName(String username);
    Employee findByUsername(String username);
    List<Employee> findByDeptName(String deptName);
}
