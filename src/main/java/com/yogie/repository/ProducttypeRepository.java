package com.yogie.repository;



import com.yogie.domain.Producttype;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * (Producttype)实体类
 *
 * @author Chenyogie
 * @since 2019-07-16 10:43:45
 */

public interface ProducttypeRepository extends BaseRepository<Producttype,Long>{

    @Query("select o from Producttype o where o.parent is null")
    List<Producttype> findTypeParent();

    @Query("select o from Producttype o where o.parent.id=?1")
    List<Producttype> findTypeChildrenById(Long id);
}