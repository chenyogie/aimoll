package com.yogie.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;


/**
 * (Purchasebillitem)实体类
 *
 * @author Chenyogie
 * @since 2019-07-17 09:50:18
 */

@Entity
@Table(name = "purchasebillitem")
public class Purchasebillitem extends BaseDomain{

    //采购价格
    private BigDecimal price;
    //采购数量
    private BigDecimal num;
    //采购小计
    private BigDecimal amount;
    //备注
    private String descs;

    @ManyToOne(optional = false)//非空
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "bill_id")
    @JsonIgnore //生成json的时候忽略这个字段
    private PurchaseBill bill; //组合关系

    
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PurchaseBill getBill() {
        return bill;
    }

    public void setBill(PurchaseBill bill) {
        this.bill = bill;
    }
}