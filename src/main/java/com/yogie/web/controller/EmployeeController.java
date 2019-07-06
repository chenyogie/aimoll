package com.yogie.web.controller;

import com.yogie.common.UIPage;
import com.yogie.domain.Employee;
import com.yogie.query.EmployeeQuery;
import com.yogie.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: aimoll
 * @Date: 2019/7/5 14:00
 * @Author: Chenyogie
 * @Description:
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/index")
    public String index(){
        return "employee/employee";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @RequestMapping("findPage")
    @ResponseBody
    public UIPage<Employee> findPage(EmployeeQuery baseQuery){
        Page page = employeeService.findPageByQuery(baseQuery);
        return new UIPage(page);
    }

}
