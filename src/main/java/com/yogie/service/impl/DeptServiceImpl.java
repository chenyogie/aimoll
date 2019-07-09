package com.yogie.service.impl;


import com.yogie.domain.Dept;
import com.yogie.repository.DeptRepository;
import com.yogie.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Dept)实体类
 *
 * @author Chenyogie
 * @since 2019-07-09 17:20:47
 */

@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept,Long> implements IDeptService {

    @Autowired
    private DeptRepository deptRepository;

}