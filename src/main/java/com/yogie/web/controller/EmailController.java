package com.yogie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: aimoll
 * @Date: 2019/7/20 14:35
 * @Author: Chenyogie
 * @Description:
 */
@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private MailSender mailSender;

    @RequestMapping("/sendEmail")
    public void sendEmail(HttpServletRequest request){
        JavaMailSenderImpl sender = (JavaMailSenderImpl)mailSender;
        // 简单邮件对象
        SimpleMailMessage msg = new SimpleMailMessage();
        // 发送人:和配置一致
        msg.setFrom("chenyogie@163.com");
        // 收件人
        msg.setTo("cyjxhu@163.com");
        // 主题
        msg.setSubject("超级社区商城系统");
        // 内容
        String text = "您正在准备删除一个用户，如果不是您本人操作，可能密码已经泄露，请立即前往官网修改密码啊。\n";
        String code = getCode();
        //将code放入session中
        request.getSession().setAttribute("mailCode",code);
        String message = "如果要继续操作，请输入此验证码："+ code;
        System.out.println(text+message);
        msg.setText(text+message);
        // 设置固定回邮地址
        msg.setReplyTo("chenyogie@163.com");
        // 发送
        sender.send(msg);
    }

    public String getCode(){
        int code = (int)(Math.random()*(10000-1000+1))+1000;
        return Integer.toString(code);
    }
}
