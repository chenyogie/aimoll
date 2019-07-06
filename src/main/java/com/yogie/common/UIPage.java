package com.yogie.common;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @program: aimoll
 * @Date: 2019/7/6 14:15
 * @Author: Chenyogie
 * @Description: 这个类主要是根据前端easyui分页插件接收的参数设计
 */

public class UIPage<T> {

    /**
     * 总记录数
     */
    private Long total;
    /**
     * 当前页的数据
     */
    private List<T> rows;

    public UIPage(){}

    public UIPage(Page page){
        this.total = page.getTotalElements();
        this.rows = page.getContent();
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
