package com.yogie.repository;



import com.yogie.domain.Permission;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

/**
 * (Permission)实体类
 *
 * @author Chenyogie
 * @since 2019-07-12 17:18:04
 */

public interface PermissionRepository extends BaseRepository<Permission,Long>{

    @Query("select p.sn from Employee o join o.roles r join r.permissions p where o.id=?1")
    Set<String> findPermissionsByUserId(Long id);

}