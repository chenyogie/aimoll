package com.yogie.web.controller;

import com.yogie.domain.Department;
import com.yogie.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: aimoll
 * @Date: 2019/7/6 21:57
 * @Author: Chenyogie
 * @Description: 这个controller专门为前台页面的下拉框的数据而设计
 */
@Controller
@RequestMapping("/util")
public class UtilController {

    @Autowired
    private IDepartmentService departmentService;

    /**
     * @return 返回employee.jsp页面中搜索框的部门下拉框数据
     */
    @RequestMapping("/findDepts")
    @ResponseBody
    public List<Department> findDept(){
        return departmentService.findAll();
    }

}
