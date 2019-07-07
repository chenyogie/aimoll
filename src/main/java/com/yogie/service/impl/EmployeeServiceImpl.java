package com.yogie.service.impl;

import com.yogie.domain.Employee;
import com.yogie.repository.EmployeeRepository;
import com.yogie.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: aimoll
 * @Date: 2019/7/5 12:04
 * @Author: Chenyogie
 * @Description:
 */
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee,Long> implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Boolean checkName(String username) {
        //如果查询结果大于0条，说明当前用户名已经被注册，返回false
        return !(employeeRepository.getCountByUsername(username)>0);
    }
}
