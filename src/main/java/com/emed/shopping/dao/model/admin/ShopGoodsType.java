package com.emed.shopping.dao.model.admin;

import com.emed.shopping.base.BaseModel;

/**
 * @Author: 周润斌
 * @Date: create in 上午 17:48 2018/1/15 0015
 * @Description:
 */
public class ShopGoodsType extends BaseModel{

    private String name; //类别名称

    private Integer sort; //排序

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
