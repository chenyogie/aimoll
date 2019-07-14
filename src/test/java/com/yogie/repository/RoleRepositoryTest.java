package com.yogie.repository;



import com.github.wenhao.jpa.Specifications;
import com.yogie.domain.Role;
import com.yogie.query.RoleQuery;
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
 * (Role)测试类
 *
 * @author Chenyogie
 * @since 2019-07-12 17:18:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testAdd() {
        Role role = new Role();
        //添加set方法
        
        roleRepository.save(role);
    }
}