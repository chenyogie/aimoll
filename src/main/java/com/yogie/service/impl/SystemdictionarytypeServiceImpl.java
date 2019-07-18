package com.yogie.service.impl;



import com.yogie.domain.Systemdictionarytype;
import com.yogie.repository.SystemdictionarytypeRepository;
import com.yogie.service.ISystemdictionarytypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Systemdictionarytype)实体类
 *
 * @author Chenyogie
 * @since 2019-07-16 16:08:58
 */

@Service
public class SystemdictionarytypeServiceImpl extends BaseServiceImpl<Systemdictionarytype,Long> implements ISystemdictionarytypeService {

    @Autowired
    private SystemdictionarytypeRepository systemdictionarytypeRepository;

}