package com.yogie.service;


import com.yogie.domain.Menu;

import java.util.List;

/**
 * (Menu)实体类
 *
 * @author Chenyogie
 * @since 2019-07-13 20:38:19
 */

public interface IMenuService extends IBaseService<Menu,Long> {
    List<Menu> findMenusByUserId(Long id);
}