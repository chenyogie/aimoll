package com.yogie.web.shiro;

import com.yogie.domain.Permission;
import com.yogie.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: aimoll
 * @Date: 2019/7/10 18:26
 * @Author: Chenyogie
 * @Description: 配置shiro要拦截的路径、权限等
 */
public class FilterChainDefinitionMapFactory {

    @Autowired
    private IPermissionService permissionService;

    /**
     * 将要拦截的资源封装成map结构返回
     * @return
     */
    public Map<String,String> builderFilterChainDefinitionMap(){
        //使用LinkedHashMap -> 保证是有顺序的
        Map<String,String> map = new LinkedHashMap<>();
        map.put("/index.jsp","anon");
        map.put("/login","anon");

        //设置静态资源放行
        map.put("/css/**","anon");
        map.put("/easyui/**","anon");
        map.put("/error/**","anon");
        map.put("/images/**","anon");
        map.put("/js/**","anon");
        map.put("/json/**","anon");
        map.put("*.js","anon");
        map.put("*.css","anon");
        map.put("*.jpg","anon");
        map.put("*.png","anon");

        //设置权限拦截[从数据库读取所有要拦截的权限，并设置拦截]
        List<Permission> list = permissionService.findAll();
        //这种是shiro默认的方式
        //list.forEach(e->map.put(e.getUrl(),"perms["+e.getSn()+"]"));
        //以下是自定义的方式
        list.forEach(e->map.put(e.getUrl(),"aiMollPerms["+e.getSn()+"]"));

        /*map.put("/employee/index","perms[employee:index]");
        map.put("/dept/index","perms[dept:index]");*/
        //设置所有拦截
        map.put("/**","authc");
        return map;
    }

}
