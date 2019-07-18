package com.yogie.repository;



import java.math.BigDecimal;
import com.github.wenhao.jpa.Specifications;
import com.yogie.domain.Purchasebillitem;
import com.yogie.query.PurchasebillitemQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * (Purchasebillitem)测试类
 *
 * @author Chenyogie
 * @since 2019-07-17 09:50:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PurchasebillitemRepositoryTest {

    @Autowired
    private PurchasebillitemRepository purchasebillitemRepository;

    @Test
    public void testAdd() {
        Purchasebillitem purchasebillitem = new Purchasebillitem();
        //添加set方法
        
        purchasebillitemRepository.save(purchasebillitem);
    }
}