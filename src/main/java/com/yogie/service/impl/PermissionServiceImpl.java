package com.yogie.service.impl;



import com.yogie.domain.Permission;
import com.yogie.repository.PermissionRepository;
import com.yogie.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * (Permission)实体类
 *
 * @author Chenyogie
 * @since 2019-07-12 17:18:04
 */

@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission,Long> implements IPermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Set<String> findPermissionsByUserId(Long id) {
        return permissionRepository.findPermissionsByUserId(id);
    }
}