package com.yogie.service.impl;



import com.yogie.domain.Department;
import com.yogie.repository.DepartmentRepository;
import com.yogie.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Department)实体类
 *
 * @author Chenyogie
 * @since 2019-07-13 22:22:39
 */

@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department,Long> implements IDepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

}