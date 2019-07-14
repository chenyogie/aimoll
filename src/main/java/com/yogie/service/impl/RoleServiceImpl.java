package com.yogie.service.impl;



import com.yogie.domain.Role;
import com.yogie.repository.RoleRepository;
import com.yogie.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Role)实体类
 *
 * @author Chenyogie
 * @since 2019-07-12 17:18:05
 */

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role,Long> implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

}