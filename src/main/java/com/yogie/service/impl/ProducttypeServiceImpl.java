package com.yogie.service.impl;



import com.yogie.domain.Producttype;
import com.yogie.repository.ProducttypeRepository;
import com.yogie.service.IProducttypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Producttype)实体类
 *
 * @author Chenyogie
 * @since 2019-07-16 10:43:45
 */

@Service
public class ProducttypeServiceImpl extends BaseServiceImpl<Producttype,Long> implements IProducttypeService {

    @Autowired
    private ProducttypeRepository producttypeRepository;

    @Override
    public List<Producttype> findTypeParent() {
        return producttypeRepository.findTypeParent();
    }

    @Override
    public List<Producttype> findTypeChildrenById(Long id) {
        return producttypeRepository.findTypeChildrenById(id);
    }
}