package com.yogie.service.impl;



import java.math.BigDecimal;
import com.yogie.domain.Product;
import com.yogie.repository.ProductRepository;
import com.yogie.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Product)实体类
 *
 * @author Chenyogie
 * @since 2019-07-16 10:36:55
 */

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product,Long> implements IProductService {

    @Autowired
    private ProductRepository productRepository;

}