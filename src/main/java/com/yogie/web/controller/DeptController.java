package com.yogie.web.controller;


import com.yogie.common.JsonResult;
import com.yogie.common.UIPage;
import com.yogie.domain.Dept;
import com.yogie.query.DeptQuery;
import com.yogie.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * (Dept)实体类
 *
 * @author Chenyogie
 * @since 2019-07-09 17:24:31
 */
@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private IDeptService deptService;

    @RequestMapping("/index")
    public String index() {
        return "dept/dept";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Dept> findAll() {
        return deptService.findAll();
    }

    @RequestMapping("/findPage")
    @ResponseBody
    public UIPage<Dept> findPage(DeptQuery baseQuery) {
        Page page = deptService.findPageByQuery(baseQuery);
        return new UIPage(page);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(Long id) {
        try {
            deptService.delete(id);
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
    @ModelAttribute("editDept")
    public Dept beforeEdit(Long id, String cmd) {
        if (id != null && "_update".equals(cmd)) {
            Dept dept = deptService.findOne(id);
            /**
             * 这个方法的设计是为了解决当前台修改部门的时候，调教修改的时候会报错：n to n
             * 这个错误的原因是：当修改部门的时候，实际上是修改的dept对应的持久化对象的department持久化对象的oid
             * 解决办法就是：直接将员工关联的department对象设置为null
             * 然后springmvc会根据前台的department.id自动创建一个非持久的department对象
             */
            //dept.setDepartment(null);
            return dept;
        }
        return null;
    }

    /**
     * 当在进行修改的时候，修改员工的时候会产生数据丢失现象
     * 然后将注解部分连同参数一起作为修饰参数的save方法
     *
     * @param dept
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@ModelAttribute("editDept") Dept dept) {
        try {
            deptService.save(dept);
            return new JsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, e.getMessage());
        }
    }


    @RequestMapping("/save")
    @ResponseBody
    public JsonResult save(Dept dept) {
        try {
            deptService.save(dept);
            return new JsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, e.getMessage());
        }
    }
}