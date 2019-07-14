package com.yogie.service;


import com.yogie.domain.Permission;

import java.util.Set;

/**
 * (Permission)实体类
 *
 * @author Chenyogie
 * @since 2019-07-12 17:18:04
 */

public interface IPermissionService extends IBaseService<Permission,Long> {
    Set<String> findPermissionsByUserId(Long id);
}