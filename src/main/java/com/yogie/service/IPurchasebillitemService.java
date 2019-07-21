package com.yogie.service;


import com.yogie.domain.Purchasebillitem;
import com.yogie.domain.vo.ItemChartVo;
import com.yogie.domain.vo.PurchaseBillItemVo;
import com.yogie.query.PurchasebillitemQuery;

import java.util.List;

/**
 * (Purchasebillitem)实体类
 *
 * @author Chenyogie
 * @since 2019-07-17 09:50:18
 */

public interface IPurchasebillitemService extends IBaseService<Purchasebillitem,Long> {

    //获取表格数据
    List<PurchaseBillItemVo> findItems(PurchasebillitemQuery query);

    //获取图表数据
    List<ItemChartVo> findCharts(PurchasebillitemQuery query);
}