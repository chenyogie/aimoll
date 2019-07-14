package com.yogie.repository;


import com.yogie.domain.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * (Menu)测试类
 *
 * @author Chenyogie
 * @since 2019-07-13 20:38:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MenuRepositoryTest {

    @Autowired
    private MenuRepository menuRepository;

    @Test
    public void testAdd() {
        Menu menu = new Menu();
        //添加set方法
        
        menuRepository.save(menu);
    }

    @Test
    public void testJpql(){
        List<Menu> list = menuRepository.findMenusByUserId(1L);
        list.forEach(e-> System.out.println(e.getName()));
    }
}