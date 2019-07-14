package com.yogie.repository;


import com.yogie.domain.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * (Dept)测试类
 *
 * @author Chenyogie
 * @since 2019-07-09 19:18:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DeptRepositoryTest {

    @Autowired
    private DeptRepository deptRepository;

    @Test
    public void testAdd() {
        Dept dept = new Dept();
        //添加set方法
        dept.setName("new");
        deptRepository.save(dept);
    }

    @Test
    public void test(){
        System.out.println("解决中文乱码问题");
    }
}