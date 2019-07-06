package com.yogie.repository;

import com.yogie.domain.Employee;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @program: aimoll
 * @Date: 2019/7/4 10:35
 * @Author: Chenyogie
 * @Description:
 */
public interface EmployeeRepository extends BaseRepository<Employee,Long>{

    Employee findByUsername(String username);
    List<Employee> findByUsernameLikeAndEmailLike(String username,String email);
    List<Employee> findByAgeGreaterThan(Integer age);

    //jpql
    @Query("select o from Employee o")
    List<Employee> query01();

    //原生sql
    @Query(nativeQuery = true,value = "select * from employee")
    List<Employee> query02();
}
