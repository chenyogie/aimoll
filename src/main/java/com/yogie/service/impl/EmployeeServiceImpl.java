package com.yogie.service.impl;

import com.yogie.common.Md5Util;
import com.yogie.domain.Employee;
import com.yogie.repository.EmployeeRepository;
import com.yogie.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public Employee findByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }


    /**
     * 在添加员工的时候，应该对密码进行加密
     * 但是在jpa中新增保存与修改调用的都是这个save方法，
     * 所以要做一定的判断(保存和修改的区别就是实体是否携带id)
     * @param employee
     */
    @Override
    @Transactional
    public void save(Employee employee) {
        if(employee.getId()==null){
            String password = Md5Util.getMd5Result(employee.getPassword());
            employee.setPassword(password);
        }
        super.save(employee);
    }


    @Override
    public List<Employee> findByDeptName(String deptName) {
        return employeeRepository.findByDeptName(deptName);
    }
}
