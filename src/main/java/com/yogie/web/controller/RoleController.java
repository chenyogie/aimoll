package com.yogie.web.controller;



import com.yogie.common.JsonResult;
import com.yogie.common.UIPage;
import com.yogie.domain.Role;
import com.yogie.query.RoleQuery;
import com.yogie.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * (Role)实体类
 *
 * @author Chenyogie
 * @since 2019-07-12 17:18:05
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/index")
    public String index() {
        return "role/role";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @RequestMapping("/findPage")
    @ResponseBody
    public UIPage<Role> findPage(RoleQuery baseQuery) {
        Page page = roleService.findPageByQuery(baseQuery);
        return new UIPage(page);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(Long id) {
        try {
            roleService.delete(id);
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
    @ModelAttribute("editRole")
    public Role beforeEdit(Long id, String cmd) {
        if (id != null && "_update".equals(cmd)) {
            Role role = roleService.findOne(id);
            /**
             * 这里清除list集合中的数据的原因是：当前台修改或删除当前角色的权限时，
             * 如果这里不清除list集合中的数据会导致两种情况：
             * 1. 不能正常删除某个角色的权限。
             * 2. 删除或修改时报n-to-n错误。
             */
            role.getPermissions().clear();
            return role;
        }
        return null;
    }

    /**
     * 当在进行修改的时候，修改员工的时候会产生数据丢失现象
     * 然后将注解部分连同参数一起作为修饰参数的save方法
     *
     * @param role
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@ModelAttribute("editRole") Role role) {
        try {
            roleService.save(role);
            return new JsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, e.getMessage());
        }
    }


    @RequestMapping("/save")
    @ResponseBody
    public JsonResult save(Role role) {
        try {
            roleService.save(role);
            return new JsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, e.getMessage());
        }
    }
}