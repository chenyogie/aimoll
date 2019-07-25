package com.yogie.service.impl;


import com.yogie.domain.Purchasebillitem;
import com.yogie.domain.vo.ItemChartVo;
import com.yogie.domain.vo.PurchaseBillItemVo;
import com.yogie.query.PurchasebillitemQuery;
import com.yogie.repository.PurchasebillitemRepository;
import com.yogie.service.IPurchasebillitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<PurchaseBillItemVo> findItems(PurchasebillitemQuery query) {
        //根据条件获取数据
        List<Purchasebillitem> items = purchasebillitemRepository.findByQuery(query);
        //封装成vo
        List<PurchaseBillItemVo> result = new ArrayList<>();
        for (Purchasebillitem item : items) {
            PurchaseBillItemVo vo = new PurchaseBillItemVo(item,query);
            result.add(vo);
        }
        return result;
    }

    @Override
    public List<ItemChartVo> findCharts(PurchasebillitemQuery query) {

        //获取到分组条件
        String groupByStr = query.getGroupByStr();
        //条件jpql
        String whereJpql = query.getWhereJpql();
        //获取参数
        List<Object> params = query.getParams();
        //这里要查询出[]
        String jpql = "select new com.yogie.domain.vo.ItemChartVo("+groupByStr
                +",sum(amount)) from Purchasebillitem o "+whereJpql+" group by "+groupByStr;
        List<ItemChartVo> result = findByJpql(jpql,params.toArray());
        return result;
    }
}