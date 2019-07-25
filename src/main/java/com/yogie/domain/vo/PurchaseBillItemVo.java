package com.yogie.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yogie.domain.Purchasebillitem;
import com.yogie.query.PurchasebillitemQuery;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: aimoll
 * @Date: 2019/7/19 17:48
 * @Author: Chenyogie
 * @Description: vo 用于前台展示的实体
 */
public class PurchaseBillItemVo {

    private Long id;
    private String supplierName;
    private String buyerName;
    private String productName;
    private String productTypeName;
    private Date vdate;
    private BigDecimal price;
    private BigDecimal num;
    private BigDecimal amount;
    private Integer status;

    private String groupField;

    /**
     * 构造方法
     * @param item
     */
    public PurchaseBillItemVo(Purchasebillitem item, PurchasebillitemQuery query){

        this.id = item.getId();
        this.supplierName = item.getBill().getSupplier().getName();
        this.buyerName = item.getBill().getBuyer().getUsername();
        this.productName = item.getProduct().getName();
        this.productTypeName = item.getProduct().getProducttype().getName();
        this.vdate = item.getBill().getVdate();
        this.price = item.getPrice();
        this.num = item.getNum();
        this.amount = item.getAmount();
        this.status = item.getBill().getStatus();

        //获取前台的分组条件[默认是按照供应商分组]
        Integer groupBy = query.getGroupBy();

        //设置分类的字段
        if(groupBy==1){
            //按照采购员分组
            this.groupField = buyerName;
        }else if(groupBy==2){
            //按照月份分组
            Calendar cal = Calendar.getInstance();
            cal.setTime(vdate);
            String month = (cal.get(Calendar.MONTH)+1) + "";
            this.groupField = month;
        }else{
            //按照供应商分组
            this.groupField = supplierName;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getVdate() {
        return vdate;
    }

    public void setVdate(Date vdate) {
        this.vdate = vdate;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getGroupField() {
        return groupField;
    }

    public void setGroupField(String groupField) {
        this.groupField = groupField;
    }


}
