package com.yogie.repository;


import com.yogie.domain.Producttype;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * (Producttype)测试类
 *
 * @author Chenyogie
 * @since 2019-07-16 10:43:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProducttypeRepositoryTest {

    @Autowired
    private ProducttypeRepository producttypeRepository;

    @Test
    public void test() {
        List<Producttype> list = producttypeRepository.findTypeChildrenById(1L);
        list.forEach(e-> System.out.println(e.getName()));
    }

    @Test
    public void test01() {
        List<Producttype> list = producttypeRepository.findTypeParent();
        list.forEach(e-> System.out.println(e.getName()));
    }

}