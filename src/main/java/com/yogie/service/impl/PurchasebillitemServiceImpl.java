package com.yogie.service.impl;



import java.math.BigDecimal;
import com.yogie.domain.Purchasebillitem;
import com.yogie.repository.PurchasebillitemRepository;
import com.yogie.service.IPurchasebillitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Purchasebillitem)实体类
 *
 * @author Chenyogie
 * @since 2019-07-17 09:50:18
 */

@Service
public class PurchasebillitemServiceImpl extends BaseServiceImpl<Purchasebillitem,Long> implements IPurchasebillitemService {

    @Autowired
    private PurchasebillitemRepository purchasebillitemRepository;

}