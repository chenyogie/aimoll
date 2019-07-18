package com.yogie.repository;



import com.yogie.domain.PurchaseBill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * (Purchasebill)测试类
 *
 * @author Chenyogie
 * @since 2019-07-17 09:50:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PurchasebillRepositoryTest {

    @Autowired
    private PurchaseBillRepository purchasebillRepository;

    @Test
    public void testAdd() {
        PurchaseBill purchasebill = new PurchaseBill();
        //添加set方法
        
        purchasebillRepository.save(purchasebill);
    }
}