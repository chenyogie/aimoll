package com.yogie.web.controller;

import com.yogie.common.JsonResult;
import com.yogie.common.UIPage;
import com.yogie.domain.Employee;
import com.yogie.query.EmployeeQuery;
import com.yogie.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String index() {
        return "employee/employee";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @RequestMapping("/findPage")
    @ResponseBody
    public UIPage<Employee> findPage(EmployeeQuery baseQuery) {
        Page page = employeeService.findPageByQuery(baseQuery);
        return new UIPage(page);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(Long id) {
        try {
            employeeService.delete(id);
            return new JsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, e.getMessage());
        }

    }

    /**
     * 设计这个方法是为了解决在修改员工的时候会产生数据丢失的问题。
     * springmvc的@ModelAttribute注解会在每个controller的每个方法前面执行
     *
     * @param id
     * @param cmd
     * @return
     */
    @ModelAttribute("editEmployee")
    public Employee beforeEdit(Long id, String cmd) {
        if (id != null && "_update".equals(cmd)) {
            Employee employee = employeeService.findOne(id);
            /**
             * 这个方法的设计是为了解决当前台修改部门的时候，调教修改的时候会报错：n to n
             * 这个错误的原因是：当修改部门的时候，实际上是修改的employee对应的持久化对象的department持久化对象的oid
             * 解决办法就是：直接将员工关联的department对象设置为null
             * 然后springmvc会根据前台的department.id自动创建一个非持久的department对象
             */
            employee.setDepartment(null);
            return employee;
        }
        return null;
    }

    /**
     * 当在进行修改的时候，修改员工的时候会产生数据丢失现象
     * 然后将注解部分连同参数一起作为修饰参数的save方法
     *
     * @param employee
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@ModelAttribute("editEmployee") Employee employee) {
        try {
            employeeService.save(employee);
            return new JsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, e.getMessage());
        }
    }


    @RequestMapping("/save")
    @ResponseBody
    public JsonResult save(Employee employee) {
        try {
            employeeService.save(employee);
            return new JsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, e.getMessage());
        }
    }

    @RequestMapping("/checkName")
    @ResponseBody
    public Boolean checkName(Long id, String username) {
        //如果id不为空，那么前台就是在做修改
        if (id != null) {
            //根据id拿到对象
            Employee employee = employeeService.findOne(id);
            //如果前台的username与数据库中的username一致
            if (username.equals(employee.getUsername())) {
                //返回true，表示这个用户名是可以用的（修改可以不修改当前的用户名）
                return true;
            }
        }
        //如果id为空的话，就是在新增数据，这个时候正常验证
        return employeeService.checkName(username);
    }

}
