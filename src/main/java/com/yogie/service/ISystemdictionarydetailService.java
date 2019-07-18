package com.yogie.service;



import com.yogie.domain.Systemdictionarydetail;

import java.util.List;

/**
 * (Systemdictionarydetail)实体类
 *
 * @author Chenyogie
 * @since 2019-07-16 10:43:46
 */

public interface ISystemdictionarydetailService extends IBaseService<Systemdictionarydetail,Long> {

    List<Systemdictionarydetail> findAllUnitBySn();

    List<Systemdictionarydetail> findAllBrandBySn();
}