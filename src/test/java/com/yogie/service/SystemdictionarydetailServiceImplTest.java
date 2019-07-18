package com.yogie.service;

import com.yogie.domain.Systemdictionarydetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @program: aimoll
 * @Date: 2019/7/16 18:09
 * @Author: Chenyogie
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SystemdictionarydetailServiceImplTest {

    @Autowired
    private ISystemdictionarydetailService service;

    @Test
    public void findAllUnitBySn() {
        List<Systemdictionarydetail> list = service.findAllUnitBySn();
        list.forEach(e-> System.out.println(e.getName()));
    }

    @Test
    public void findAllBrandBySn() {
        List<Systemdictionarydetail> list = service.findAllBrandBySn();
        list.forEach(e-> System.out.println(e.getName()));
    }
}