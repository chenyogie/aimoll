package com.yogie.repository;



import com.github.wenhao.jpa.Specifications;
import com.yogie.domain.Systemdictionarytype;
import com.yogie.query.SystemdictionarytypeQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * (Systemdictionarytype)测试类
 *
 * @author Chenyogie
 * @since 2019-07-16 16:09:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SystemdictionarytypeRepositoryTest {

    @Autowired
    private SystemdictionarytypeRepository systemdictionarytypeRepository;

    @Test
    public void testAdd() {
        Systemdictionarytype systemdictionarytype = new Systemdictionarytype();
        //添加set方法
        
        systemdictionarytypeRepository.save(systemdictionarytype);
    }
}