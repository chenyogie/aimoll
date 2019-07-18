package com.yogie.repository;



import com.yogie.domain.Systemdictionarydetail;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * (Systemdictionarydetail)实体类
 *
 * @author Chenyogie
 * @since 2019-07-16 10:43:46
 */

public interface SystemdictionarydetailRepository extends BaseRepository<Systemdictionarydetail,Long>{

    @Query("select o from Systemdictionarydetail o where o.type.sn=?1")
    List<Systemdictionarydetail> findAllBySn(String sn);
}