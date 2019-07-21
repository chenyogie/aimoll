package com.yogie.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

/**
 * @program: aimoll
 * @Date: 2019/7/20 21:55
 * @Author: Chenyogie
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OnlineUserTest {

    @Test
    public void test(){
        MemorySessionDAO dao = new MemorySessionDAO();
        Collection<Session> sessions = dao.getActiveSessions();
        System.out.println(sessions);
    }
}
