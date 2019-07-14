package com.yogie.repository;



import com.yogie.domain.Permission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * (Permission)测试类
 *
 * @author Chenyogie
 * @since 2019-07-12 17:18:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PermissionRepositoryTest {

    @Autowired
    private PermissionRepository permissionRepository;

    @Test
    public void testAdd() {
        Permission permission = new Permission();
        //添加set方法

        permissionRepository.save(permission);
    }


    @Test
    public void testJpql(){
        Set<String> set = permissionRepository.findPermissionsByUserId(1L);
        System.out.println(set.size());
        set.forEach(e-> System.out.println(e));
    }
}