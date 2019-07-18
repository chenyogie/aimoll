package com.yogie.web.controller;

import com.yogie.common.UserContext;
import com.yogie.domain.*;
import com.yogie.service.*;
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

    @Autowired
    private IMenuService menuService;

    @Autowired
    private ISystemdictionarydetailService systemdictionarydetailService;

    @Autowired
    private IProducttypeService producttypeService;

    @Autowired
    private ISupplierService supplierService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IProductService productService;

    /**
     * @return 返回employee.jsp页面中搜索框的部门下拉框数据
     */
    @RequestMapping("/findDepts")
    @ResponseBody
    public List<Department> findDept(){
        return departmentService.findAll();
    }

    /**
     * 根据登录用户的权限展示主页菜单项
     * @return
     */
    @RequestMapping("/findMenusByUser")
    @ResponseBody
    public List<Menu> findMenusByuser(){
        Employee loginUser = UserContext.getUserInSession();
        List<Menu> list = menuService.findMenusByUserId(loginUser.getId());
        return list;
    }

    @RequestMapping("/findUnits")
    @ResponseBody
    public List<Systemdictionarydetail> findUnits(){
        //根据字典：查找
        List<Systemdictionarydetail> list =  systemdictionarydetailService.findAllUnitBySn();
        return list;
    }

    @RequestMapping("/findBrands")
    @ResponseBody
    public List<Systemdictionarydetail> findBrands(){
        //根据字典：查找
        return systemdictionarydetailService.findAllBrandBySn();
    }

    @RequestMapping("/findTypeParent")
    @ResponseBody
    public List<Producttype> findTypeParent(){
        //根据字典：查找
        return producttypeService.findTypeParent();
    }

    @RequestMapping("/findTypeChildren")
    @ResponseBody
    public List<Producttype> findTypeChildren(Long id){
        //根据字典：查找
        return producttypeService.findTypeChildrenById(id);
    }

    @RequestMapping("/findAllSupplier")
    @ResponseBody
    public List<Supplier> findAllSupplier(){
        //根据字典：查找
        return supplierService.findAll();
    }

    @RequestMapping("/findBuyer")
    @ResponseBody
    public List<Employee> findBuyer(){
        //根据字典：查找
        return employeeService.findByDeptName("采购部");
    }

    @RequestMapping("/findProduct")
    @ResponseBody
    public List<Product> findProduct(){
        //根据字典：查找
        return productService.findAll();
    }

}
