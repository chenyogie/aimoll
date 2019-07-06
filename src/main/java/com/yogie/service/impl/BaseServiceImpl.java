package com.yogie.service.impl;

import com.yogie.query.BaseQuery;
import com.yogie.repository.BaseRepository;
import com.yogie.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @program: aimoll
 * @Date: 2019/7/5 11:57
 * @Author: Chenyogie
 * @Description: 在service层，查询多于增删改
 */
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public abstract class BaseServiceImpl<T,ID extends Serializable> implements IBaseService<T, ID> {

    @Autowired
    private BaseRepository<T,ID> baseRepository;

    @Override
    @Transactional
    public void save(T t) {
        baseRepository.save(t);
    }

    @Override
    @Transactional
    public void delete(ID id) {
        baseRepository.delete(id);
    }

    @Override
    public T findOne(ID id) {
        return baseRepository.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public Page findPageByQuery(BaseQuery baseQuery) {
        return baseRepository.findPageByQuery(baseQuery);
    }

    @Override
    public List<T> findByQuery(BaseQuery baseQuery) {
        return baseRepository.findByQuery(baseQuery);
    }

    @Override
    public List findByJpql(String jpql, Object... values) {
        return baseRepository.findByJpql(jpql,values);
    }
}
