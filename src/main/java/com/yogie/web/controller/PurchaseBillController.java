package com.yogie.web.controller;


import com.yogie.common.JsonResult;
import com.yogie.common.UIPage;
import com.yogie.common.UserContext;
import com.yogie.domain.Employee;
import com.yogie.domain.PurchaseBill;
import com.yogie.domain.Purchasebillitem;
import com.yogie.query.PurchaseBillQuery;
import com.yogie.service.IPurchaseBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * (PurchaseBill)实体类
 *
 * @author Chenyogie
 * @since 2019-07-17 09:50:16
 */
@Controller
@RequestMapping("/purchasebill")
public class PurchaseBillController {

    @Autowired
    private IPurchaseBillService purchaseBillService;

    @RequestMapping("/index")
    public String index() {
        return "purchasebill/purchasebill";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<PurchaseBill> findAll() {
        return purchaseBillService.findAll();
    }

    @RequestMapping("/findPage")
    @ResponseBody
    public UIPage<PurchaseBill> findPage(PurchaseBillQuery baseQuery) {
        Page page = purchaseBillService.findPageByQuery(baseQuery);
        return new UIPage(page);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(Long id) {
        try {
            purchaseBillService.delete(id);
            return new JsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, e.getMessage());
        }

    }

    /**
     * 设计这个方法是为了解决在修改员工的时候会产生数据丢失的问题。
     * springmvc的@ModelAttribute注解会在每个controller的每个方法前面执行
     *
     * @param id
     * @param cmd
     * @return
     */
    @ModelAttribute("editPurchaseBill")
    public PurchaseBill beforeEdit(Long id, String cmd) {
        if (id != null && "_update".equals(cmd)) {
            PurchaseBill purchaseBill = purchaseBillService.findOne(id);
            //把要传过来的关联对象都清空，就可以解决n-to-n的问题
            purchaseBill.setSupplier(null);
            purchaseBill.setBuyer(null);
            purchaseBill.getItems().clear();
            return purchaseBill;
        }
        return null;
    }

    /**
     * 当在进行修改的时候，修改员工的时候会产生数据丢失现象
     * 然后将注解部分连同参数一起作为修饰参数的save方法
     *
     * @param purchaseBill
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@ModelAttribute("editPurchaseBill") PurchaseBill purchaseBill) {
        return saveOrUpdate(purchaseBill);
    }


    @RequestMapping("/save")
    @ResponseBody
    public JsonResult save(PurchaseBill purchaseBill) {
        return saveOrUpdate(purchaseBill);
    }

    private JsonResult saveOrUpdate(PurchaseBill purchasebill){
        try {
            //拿到采购订单的所有明细
            List<Purchasebillitem> items = purchasebill.getItems();
            //准备总金额与总数量
            BigDecimal totalamount = new BigDecimal("0");
            BigDecimal totalnum = new BigDecimal("0");
            for (Purchasebillitem item : items) {
                //设置明细对应的订单
                item.setBill(purchasebill);
                //计算每一个明细的小计[decaimal类型的数值之间的计算需要通过调用方法来进行，具体查看jdk文档]
                item.setAmount(item.getNum().multiply(item.getPrice()));
                //总金额与总数量进行累加
                totalamount = totalamount.add(item.getAmount());
                totalnum = totalnum.add(item.getNum());
            }
            //把值设置到订单中去
            purchasebill.setTotalamount(totalamount);
            purchasebill.setTotalnum(totalnum);
            purchaseBillService.save(purchasebill);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
        return new JsonResult();
    }
}