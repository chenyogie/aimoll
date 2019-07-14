package com.yogie.repository;


import com.yogie.domain.Menu;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * (Menu)实体类
 *
 * @author Chenyogie
 * @since 2019-07-13 20:38:19
 */

public interface MenuRepository extends BaseRepository<Menu,Long>{

    /**
     * 根据用户id拿到对应的菜单项
     * @param id
     * @return
     */
    @Query("select distinct m from Employee e join e.roles r join r.permissions p join p.menu m where e.id = ?1")
    List<Menu> findMenusByUserId(Long id);
}