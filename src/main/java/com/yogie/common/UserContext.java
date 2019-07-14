package com.yogie.common;

import com.yogie.domain.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @program: aimoll
 * @Date: 2019/7/13 11:53
 * @Author: Chenyogie
 * @Description: 将登录的用户存入shiro的session中[httpsession中也会有值]
 */
public class UserContext {

    private static final String USER_IN_SESSION = "loginUser";

    /**
     * 从session中取值
     * @return
     */
    public static Employee getUserInSession(){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Employee loginUser = (Employee)session.getAttribute(USER_IN_SESSION);
        return loginUser;
    }

    /**
     * 将数据存入session中
     * @param loginUser
     */
    public static void setUserInSession(Employee loginUser){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute(USER_IN_SESSION,loginUser);
    }

}
