package com.yogie.domain.vo;

/**
 * @program: aimoll
 * @Date: 2019/7/19 18:49
 * @Author: Chenyogie
 * @Description:
 */
public class ItemChartVo {

    private Object name;
    private Object y;

    public ItemChartVo() {}

    public ItemChartVo(Object name, Object y) {
        this.name = name;
        this.y = y;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getY() {
        return y;
    }

    public void setY(Object y) {
        this.y = y;
    }
}
