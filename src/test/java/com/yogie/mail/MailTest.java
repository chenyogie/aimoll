package com.yogie.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: aimoll
 * @Date: 2019/7/20 14:05
 * @Author: Chenyogie
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MailTest {

    @Autowired
    private MailSender mailSender;

    @Test
    public void test(){
        JavaMailSenderImpl sender = (JavaMailSenderImpl)mailSender;
        // 简单邮件对象
        SimpleMailMessage msg = new SimpleMailMessage();
        // 发送人:和配置一致
        msg.setFrom("chenyogie@163.com");
        // 收件人
        msg.setTo("cyjxhu@163.com");
        // 主题
        msg.setSubject("超级社区管理系统验证码系统");
        // 内容
        int code = (int)(Math.random()*(10000-1000+1))+1000;
        System.out.println("code === " + code);
        msg.setText("您的验证码为："+ code);
        // 设置固定回邮地址
        msg.setReplyTo("chenyogie@163.com");
        // 发送
        sender.send(msg);
    }
}
