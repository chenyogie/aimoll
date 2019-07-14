package com.yogie.common;

import com.yogie.domain.Employee;
import com.yogie.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @program: aimoll
 * @Date: 2019/7/11 11:36
 * @Author: Chenyogie
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Md5UtilTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void getMd5Result() {
        List<Employee> list = employeeRepository.findAll();
        list.forEach((e)->{
            String username = e.getUsername();
            String password = Md5Util.getMd5Result(username);
            e.setPassword(password);
            employeeRepository.save(e);
        });
    }
}