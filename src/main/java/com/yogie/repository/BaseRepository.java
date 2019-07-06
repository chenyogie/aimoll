package com.yogie.repository;

import com.yogie.query.BaseQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * @program: aimoll
 * @Date: 2019/7/5 9:21
 * @Author: Chenyogie
 * @Description:
 */
@NoRepositoryBean//告诉jpa不要实例化此接口
public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
    //根据Query拿到分页对象(分页)
    Page findPageByQuery(BaseQuery baseQuery);

    //根据Query拿到对应的所有数据(不分页)
    List<T> findByQuery(BaseQuery baseQuery);

    //根据jpql与对应的参数拿到数据
    List findByJpql(String jpql,Object... values);
}
