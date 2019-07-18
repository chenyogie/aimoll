package com.yogie.repository;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * (Product)测试类
 *
 * @author Chenyogie
 * @since 2019-07-16 10:36:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void test() {

    }
}