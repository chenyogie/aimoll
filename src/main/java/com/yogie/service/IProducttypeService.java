package com.yogie.service;



import com.yogie.domain.Producttype;

import java.util.List;

/**
 * (Producttype)实体类
 *
 * @author Chenyogie
 * @since 2019-07-16 10:43:45
 */

public interface IProducttypeService extends IBaseService<Producttype,Long> {
    List<Producttype> findTypeParent();

    List<Producttype> findTypeChildrenById(Long id);
}