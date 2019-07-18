package com.yogie.repository;



import com.yogie.domain.Systemdictionarydetail;
import com.yogie.domain.Systemdictionarytype;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * (Systemdictionarydetail)测试类
 *
 * @author Chenyogie
 * @since 2019-07-16 10:43:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SystemdictionarydetailRepositoryTest {

    @Autowired
    private SystemdictionarydetailRepository systemdictionarydetailRepository;

    @Test
    public void testAdd() {

        List<Systemdictionarydetail> list = systemdictionarydetailRepository.findAllBySn(Systemdictionarytype.PRODUCT_UNIT);
        list.forEach(e-> System.out.println(e.getName()));
    }
}