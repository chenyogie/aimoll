package com.yogie.service.impl;


import com.yogie.domain.Menu;
import com.yogie.repository.MenuRepository;
import com.yogie.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * (Menu)实体类
 *
 * @author Chenyogie
 * @since 2019-07-13 20:38:19
 */

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu,Long> implements IMenuService {

    @Autowired
    private MenuRepository menuRepository;

    /**
     * 根据当前登录用户的id拿到菜单菜单列表
     * @return
     */
    @Override
    public List<Menu> findMenusByUserId(Long id) {
        //拿到当前登录用户
        //Employee loginUser = UserContext.getUserInSession();
        //根据当前登录用户拿到所有的菜单项
        List<Menu> menuList = menuRepository.findMenusByUserId(id);
        //准备父菜单的集合
        List<Menu> parentMenus = new ArrayList<>();
        //循环遍历子菜单
        for (Menu menu : menuList) {
            //拿到当前菜单的父菜单
            Menu parent = menu.getParent();
            //如果子菜单的父菜单不在在父菜单的集合中
            if(!parentMenus.contains(parent)){
                parentMenus.add(parent);
            }
            //把子菜单放到父菜单的子菜单中去
            parent.getChildren().add(menu);

        }
        //将父菜单的集合返回[父菜单的集合已经包含了子菜单]
        return parentMenus;
    }
}