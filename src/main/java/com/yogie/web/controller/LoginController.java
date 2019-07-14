package com.yogie.web.controller;

import com.yogie.common.JsonResult;
import com.yogie.common.UserContext;
import com.yogie.domain.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: aimoll
 * @Date: 2019/7/10 19:01
 * @Author: Chenyogie
 * @Description:
 */
@Controller
public class LoginController {

    /**
     * 地址栏直接输入login路径，跳转到login页面
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 表单登录
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult login(String username,String password){
        //获取实例对象（当前用户->游客）
        Subject subject = SecurityUtils.getSubject();
        //将用户名和密码封装成token
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            System.out.println("用户名或密码出错出错");
            e.printStackTrace();
            return new JsonResult(false,"用户名或密码出错出错");
        } catch (IncorrectCredentialsException e) {
            System.out.println("用户名或者密码错误");
            e.printStackTrace();
            return new JsonResult(false,"用户名或密码出错出错");
        }catch (AuthenticationException e) {
            System.out.println("未知错误");
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
        //将当前登录的用户加入到session中
        UserContext.setUserInSession((Employee)subject.getPrincipal());
        return new JsonResult();
    }

    /**
     * 登录注销
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:login";
    }
}
