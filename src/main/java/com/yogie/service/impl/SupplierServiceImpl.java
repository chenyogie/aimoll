package com.yogie.service.impl;



import com.yogie.domain.Supplier;
import com.yogie.repository.SupplierRepository;
import com.yogie.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Supplier)实体类
 *
 * @author Chenyogie
 * @since 2019-07-17 11:41:27
 */

@Service
public class SupplierServiceImpl extends BaseServiceImpl<Supplier,Long> implements ISupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

}