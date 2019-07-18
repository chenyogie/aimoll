package com.yogie.repository;



import com.github.wenhao.jpa.Specifications;
import com.yogie.domain.Supplier;
import com.yogie.query.SupplierQuery;
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
 * (Supplier)测试类
 *
 * @author Chenyogie
 * @since 2019-07-17 11:41:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SupplierRepositoryTest {

    @Autowired
    private SupplierRepository supplierRepository;

    @Test
    public void testAdd() {
        Supplier supplier = new Supplier();
        //添加set方法
        
        supplierRepository.save(supplier);
    }
}