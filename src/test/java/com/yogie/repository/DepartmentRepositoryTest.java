package com.yogie.repository;



import com.github.wenhao.jpa.Specifications;
import com.yogie.domain.Department;
import com.yogie.query.DepartmentQuery;
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
 * (Department)测试类
 *
 * @author Chenyogie
 * @since 2019-07-13 22:22:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testAdd() {
        Department department = new Department();
        //添加set方法
        
        departmentRepository.save(department);
    }
}