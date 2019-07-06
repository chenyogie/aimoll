package com.yogie.web.controller;

import com.yogie.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: aimoll
 * @Date: 2019/7/5 14:00
 * @Author: Chenyogie
 * @Description:
 */
@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

}
