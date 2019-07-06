package com.yogie.repository;

import com.github.wenhao.jpa.Specifications;
import com.yogie.domain.Employee;
import com.yogie.query.EmployeeQuery;
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
 * @program: aimoll
 * @Date: 2019/7/4 10:50
 * @Author: Chenyogie
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testAdd() {
        Employee employee = new Employee();
        employee.setUsername("wang");
        employee.setPassword("123");
        employee.setAge(20);
        employee.setEmail("wang@qq.com");
        employeeRepository.save(employee);
    }

    @Test
    public void testDel() {
        employeeRepository.delete(274L);
    }

    @Test
    public void testUpdate() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setUsername("wang");
        employee.setPassword("123");
        employee.setAge(20);
        employee.setEmail("wang@qq.com");
        employeeRepository.save(employee);
    }

    @Test
    public void testFindOne() {
        Employee employee = employeeRepository.findOne(1L);
        System.out.println(employee);
    }

    @Test
    public void testFindAll() {
        List<Employee> list = employeeRepository.findAll();
        list.forEach(e -> System.out.println(e));
    }

    @Test
    public void testPage() {
        Page<Employee> list = employeeRepository.findAll(new PageRequest(0, 10));
        list.forEach(e -> System.out.println(e));
    }

    @Test
    public void testSort() {
        Sort sort = new Sort("age");
        List<Employee> list = employeeRepository.findAll(sort);
        list.forEach(e -> System.out.println(e));
    }

    @Test
    public void testPageAndSort() {
        Sort sort = new Sort("age");
        Pageable pageable = new PageRequest(0, 10, sort);
        Page<Employee> list = employeeRepository.findAll(pageable);
        list.forEach(e -> System.out.println(e));
    }

    @Test
    public void testRuleMethod01() {
        List<Employee> list = employeeRepository.findByAgeGreaterThan(80);
        list.forEach(e -> System.out.println(e));
    }

    @Test
    public void testRuleMethod02() {
        List<Employee> list = employeeRepository.findByUsernameLikeAndEmailLike("%1%", "%2%");
        list.forEach(e -> System.out.println(e));
    }

    @Test
    public void testRuleMethod03() {
        Employee employee = employeeRepository.findByUsername("wang");
        System.out.println(employee);
    }

    @Test
    public void testJpql() {
        List<Employee> list = employeeRepository.query01();
        list.forEach(e -> System.out.println(e));
    }

    @Test
    public void testNativeSql() {
        List<Employee> list = employeeRepository.query02();
        list.forEach(e -> System.out.println(e));
    }

    @Test
    public void testPredicate() {
        List<Employee> list = employeeRepository.findAll(new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                Path usernamePath = root.get("username");
                Predicate p1 = cb.like(usernamePath, "%a%");

                Path emailPath = root.get("email");
                Predicate p2 = cb.like(emailPath, "%a%");

                Path age = root.get("age");
                Predicate p3 = cb.gt(age, 10);

                Predicate predicate = cb.and(p1, p2, p3);
                return predicate;
            }
        });
        list.forEach(e -> System.out.println(e));
    }

    @Test
    public void testPredicate02() {
        List<Employee> list = employeeRepository.findAll((root, cq, cb) -> {
            Path usernamePath = root.get("username");
            Predicate p = cb.like(usernamePath, "%adm%");
            return p;
        });
        list.forEach(e -> System.out.println(e));
    }

    @Test
    public void testPredicatePageAndSort(){
        Sort sort = new Sort(Sort.Direction.ASC,"age");
        Pageable pageable = new PageRequest(0,10,sort);
        Page<Employee> page = employeeRepository.findAll((root, cq, cb) -> {
            Path username = root.get("username");
            Predicate predicate = cb.like(username, "%ad%");
            return predicate;
        }, pageable);
        page.forEach(e-> System.out.println(e));
    }


    @Test
    public void testJpaSpec(){
        Sort sort = new Sort(Sort.Direction.valueOf("DESC"),"age");
        Pageable pageable = new PageRequest(0,10,sort);
        Specification<Employee> spec = Specifications.<Employee>and()
                .like("username", "%ad%")
                .like("email","%a%").build();
        Page<Employee> page = employeeRepository.findAll(spec, pageable);
        page.forEach(e-> System.out.println(e));
    }

    /**
     *
     */
    @Test
    public void testCreateQuery(){
        EmployeeQuery query = new EmployeeQuery();
        query.setUsername("ad");
        query.setOrderName("age");
        Specification spec = query.createSpec();
        Sort sort = query.createSort();
        Pageable pageable = new PageRequest(query.getCurrentPage(),query.getPageSize(),sort);
        Page<Employee> page = employeeRepository.findAll(spec, pageable);
        page.forEach(e-> System.out.println(e));
    }


}