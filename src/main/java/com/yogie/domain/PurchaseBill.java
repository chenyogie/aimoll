package com.yogie.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 采购订单实体类
 * purchase:采购，购买
 * bill：订单
 * @author Chenyogie
 * @since 2019-07-17 09:50:16
 */

@Entity
@Table(name = "purchasebill")
public class PurchaseBill extends BaseDomain{

    //采购日期
    private Date vdate;
    //采购总价格
    private BigDecimal totalamount;
    //总数量
    private BigDecimal totalnum;
    //录入时间:当前系统时间
    private Date inputtime = new Date();
    //审核时间
    private Date auditortime;
    //审核状态:默认待审
    private Integer status = 0;

    //供应商
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    //审核人
    @ManyToOne
    @JoinColumn(name = "auditor_id")
    private Employee auditor;

    //录入员
    @ManyToOne
    @JoinColumn(name = "inputUser_id")
    private Employee inputUser;

    //采购员
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Employee buyer;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bill",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Purchasebillitem> items = new ArrayList<>();

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getVdate() {
        return vdate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setVdate(Date vdate) {
        this.vdate = vdate;
    }
    
    public BigDecimal getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(BigDecimal totalamount) {
        this.totalamount = totalamount;
    }
    
    public BigDecimal getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(BigDecimal totalnum) {
        this.totalnum = totalnum;
    }

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getInputtime() {
        return inputtime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }
    
    public Date getAuditortime() {
        return auditortime;
    }

    public void setAuditortime(Date auditortime) {
        this.auditortime = auditortime;
    }
    
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Employee getAuditor() {
        return auditor;
    }

    public void setAuditor(Employee auditor) {
        this.auditor = auditor;
    }

    public Employee getInputUser() {
        return inputUser;
    }

    public void setInputUser(Employee inputUser) {
        this.inputUser = inputUser;
    }

    public Employee getBuyer() {
        return buyer;
    }

    public void setBuyer(Employee buyer) {
        this.buyer = buyer;
    }

    public List<Purchasebillitem> getItems() {
        return items;
    }

    public void setItems(List<Purchasebillitem> items) {
        this.items = items;
    }
}