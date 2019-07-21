package com.yogie.web.controller;

import com.yogie.domain.Employee;
import com.yogie.domain.vo.OnlineUser;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.web.subject.support.DefaultWebSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @program: aimoll
 * @Date: 2019/7/20 21:37
 * @Author: Chenyogie
 * @Description:
 */
@Controller
@RequestMapping("/onlineuser")
public class OnlineUserController {

    @Autowired
    private SessionDAO sessionDAO;

    @RequestMapping("/index")
    public String index() {
        return "onlineuser/onlineuser";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<OnlineUser> findAllUserInSession(){
        List<OnlineUser> list = new ArrayList<>();
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        for (Session session : sessions) {
            Object obj = session.getAttribute(DefaultWebSubjectContext.PRINCIPALS_SESSION_KEY);
            if(obj!=null){

                /**
                 * 1.org.apache.shiro.subject.SimplePrincipalCollection cannot be cast to com.yogie.domain.Employee
                 * //上面的obj实际上是一个SimplePrincipalCollection对象
                 */
                SimplePrincipalCollection conn = (SimplePrincipalCollection)obj;
                Employee emp = (Employee)conn.getPrimaryPrincipal();


                /**
                 * 2.org.hibernate.LazyInitializationException: failed to lazily initialize a collection  --- no session
                 * 错误代码描述：
                 *  list.add(new OnlineUser(session.getId(), session.getHost(), emp, session.getLastAccessTime()));
                 *  原本我的OnlineUser实体类的username字段为Employee实体对象，
                 *  但是一旦将Principal转换成Employee，并通过OnlineUser构造函数设置到其成员变量中去的时候，就会报：懒加载-no session异常
                **/
                list.add(new OnlineUser(session.getId(), session.getHost(), emp.getUsername(), session.getLastAccessTime()));

            }
        }
        return list;
    }
}
