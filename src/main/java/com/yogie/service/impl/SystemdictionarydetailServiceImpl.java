package com.yogie.service.impl;



import com.yogie.domain.Systemdictionarydetail;
import com.yogie.domain.Systemdictionarytype;
import com.yogie.repository.SystemdictionarydetailRepository;
import com.yogie.service.ISystemdictionarydetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Systemdictionarydetail)实体类
 *
 * @author Chenyogie
 * @since 2019-07-16 10:43:46
 */

@Service
public class SystemdictionarydetailServiceImpl extends BaseServiceImpl<Systemdictionarydetail,Long> implements ISystemdictionarydetailService {

    @Autowired
    private SystemdictionarydetailRepository detailRepository;

    @Override
    public List<Systemdictionarydetail> findAllUnitBySn() {
        List<Systemdictionarydetail> list = detailRepository.findAllBySn(Systemdictionarytype.PRODUCT_UNIT);
        return list;
    }

    @Override
    public List<Systemdictionarydetail> findAllBrandBySn() {
        return detailRepository.findAllBySn(Systemdictionarytype.PRODUCT_BRAND);
    }
}