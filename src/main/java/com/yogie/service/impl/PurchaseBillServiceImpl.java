package com.yogie.service.impl;


import com.yogie.domain.PurchaseBill;
import com.yogie.repository.PurchaseBillRepository;
import com.yogie.service.IPurchaseBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Purchasebill)实体类
 *
 * @author Chenyogie
 * @since 2019-07-17 09:50:16
 */

@Service
public class PurchaseBillServiceImpl extends BaseServiceImpl<PurchaseBill,Long> implements IPurchaseBillService {

    @Autowired
    private PurchaseBillRepository purchaseBillRepository;

}