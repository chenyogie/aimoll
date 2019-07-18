package com.yogie.domain;

import javax.persistence.*;
import java.math.BigDecimal;


/**
 * (Product)实体类
 *
 * @author Chenyogie
 * @since 2019-07-16 10:36:55
 */

@Entity
@Table(name = "product")
public class Product extends BaseDomain{
    //产品名称
    private String name;
    //颜色
    private String color;
    //图片
    private String pic;
    //小图片
    private String smallpic;
    //成本价
    private BigDecimal costprice;
    //售价
    private BigDecimal saleprice;
    //产品类型
    @ManyToOne
    @JoinColumn(name = "types_id")
    private Producttype producttype;

    //单位：来自数据字典表
    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Systemdictionarydetail unit;

    //品牌：来自数据字典表
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Systemdictionarydetail brand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    
    public String getSmallpic() {
        return smallpic;
    }

    public void setSmallpic(String smallpic) {
        this.smallpic = smallpic;
    }
    
    public BigDecimal getCostprice() {
        return costprice;
    }

    public void setCostprice(BigDecimal costprice) {
        this.costprice = costprice;
    }
    
    public BigDecimal getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(BigDecimal saleprice) {
        this.saleprice = saleprice;
    }

    public Producttype getProducttype() {
        return producttype;
    }

    public void setProducttype(Producttype producttype) {
        this.producttype = producttype;
    }

    public Systemdictionarydetail getUnit() {
        return unit;
    }

    public void setUnit(Systemdictionarydetail unit) {
        this.unit = unit;
    }

    public Systemdictionarydetail getBrand() {
        return brand;
    }

    public void setBrand(Systemdictionarydetail brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", pic='" + pic + '\'' +
                ", smallpic='" + smallpic + '\'' +
                ", costprice=" + costprice +
                ", saleprice=" + saleprice +
                ", producttype=" + producttype +
                ", unit=" + unit +
                ", brand=" + brand +
                ", id=" + id +
                '}';
    }
}