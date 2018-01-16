package com.emed.shopping.dao.model.admin;

import com.emed.shopping.base.BaseModel;

/**
 * @Author: 周润斌
 * @Date: create in 上午 10:53 2018/1/16 0016
 * @Description:
 */
public class ShopGoodsSpecification extends BaseModel {

    private String name;

    private Integer sort;

    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
