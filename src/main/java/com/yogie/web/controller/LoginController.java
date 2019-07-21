package com.yogie.web.controller;

import com.yogie.common.JsonResult;
import com.yogie.common.UserContext;
import com.yogie.domain.Employee;
import com.yogie.service.IEmployeeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @program: aimoll
 * @Date: 2019/7/10 19:01
 * @Author: Chenyogie
 * @Description:
 */
@Controller
public class LoginController {

    @Autowired
    private IEmployeeService employeeService;

    /**
     * 地址栏直接输入login路径，跳转到login页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 表单登录
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult login(String username, String password,String activeCode,HttpServletRequest request) {

        //首先验证验证码
        String validate = (String) request.getSession().getAttribute("validate");
        //System.out.println("sessionCode:"+validate);
        if(validate!=null && !validate.equals(activeCode.toUpperCase())){
            return new JsonResult(false,"验证码错误");
        }
        //验证用户状态[是否被禁用]
        Employee user = employeeService.findByUsername(username);
        if(!user.getStatus()){
            return new JsonResult(false,"您的账户已被禁用，请联系管理员！");
        }
        //如果是第一次登陆，强制修改密码
        if(!user.isFirstln()){
            return new JsonResult(false,"您是第一次登陆，为了账户的安全，请修改密码!");
        }

        //获取实例对象（当前用户->游客）
        Subject subject = SecurityUtils.getSubject();

        //将用户名和密码封装成token
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            //System.out.println("用户名或密码出错出错");
            e.printStackTrace();
            return new JsonResult(false, "用户名或密码出错出错");
        } catch (IncorrectCredentialsException e) {
            //System.out.println("用户名或者密码错误");
            e.printStackTrace();
            return new JsonResult(false, "用户名或密码出错出错");
        } catch (AuthenticationException e) {
            //System.out.println("未知错误");
            e.printStackTrace();
            return new JsonResult(false, e.getMessage());
        }
        //将当前登录的用户加入到session中
        UserContext.setUserInSession((Employee) subject.getPrincipal());
        return new JsonResult();
    }

    Random random = new Random();

    @RequestMapping("/getImg")
    public void setImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /**
         * 设置响应消息头， 不让浏览器缓存图片
         */
        response.setDateHeader("Expires", -1);
        response.setHeader("Cache-Control", "no-Cache");
        response.setHeader("pragma", "no-Cache");
        int width = 150;
        int height = 40;
        // 画图片
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取到画笔
        Graphics2D g = (Graphics2D) img.getGraphics();
        // 设置"画笔", 画出矩形
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        // 画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);
        // 画干扰线
        int r = random.nextInt(256);
        int gg = random.nextInt(256);
        int b = random.nextInt(256);
        g.setColor(new Color(r, gg, b));
        for (int i = 0; i < 5; i++) {
            g.drawLine(getRandomInt(0, width), getRandomInt(0, height), getRandomInt(0, width),
                    getRandomInt(0, height));
        }
        // 产生随机的文字放入到图片上
        String str = "CHENYOGIE1234567890";
        // 设置字体
        g.setFont(new Font("楷体", Font.BOLD, 20));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            double c = getRandomInt(-45, 45) / 180F * Math.PI;
            g.rotate(c, 5 + width / 4 * i, 20);
            String s = str.charAt(getRandomInt(0, str.length() - 1)) + "";
            sb.append(s);
            g.drawString(s, 5 + width / 4 * i, 20);
            g.rotate(-c, 5 + width / 4 * i, 20);
        }

        System.out.println(sb.toString());

        // 保存在Session中
        request.getSession().setAttribute("validate", sb.toString());

        g.dispose();
        ImageIO.write(img, "jpg", response.getOutputStream());
    }

    private int getRandomInt(int begin, int end) {

        return random.nextInt(end - begin) + begin;
    }

    /**
     * 登录注销
     *
     * @return
     */
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:login";
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping("/turnToUpdatePassword")
    public String turnToUpdatePassword(){
        return "updatePassword";
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public JsonResult updatePassword(String username,String password){
        //System.out.println(username+"---"+password);
        try{
            Employee emp = employeeService.findByUsername(username);
            emp.setPassword(password);
            emp.setFirstln(true);//设置非第一次登陆
            ByteSource salt = ByteSource.Util.bytes("chenyogie");
            SimpleHash hash = new SimpleHash("MD5",password,salt,10);
            emp.setPassword(hash.toHex());
            employeeService.save(emp);
        }catch (Exception e){
            return new JsonResult(false,"密码修改失败!");
        }
        return new JsonResult(true,"密码修改成功！");
    }
}
