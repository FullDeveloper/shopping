package com.emed.shopping.dao.model.admin;

import com.emed.shopping.base.BaseModel;

/**
 * @Author: 周润斌
 * @Date: create in 上午 13:35 2018/1/16 0016
 * @Description:
 */
public class ShopGoodsClass extends BaseModel {

    private String className;

    private Integer level;

    private String display;

    private String recommend;

    private String seoKeywords;

    private String seoDescription;

    private Integer iconType;

    private String iconSys;

    private Long iconAccessoryId;

    private Long goodsTypeId;

    private Long parentId;

    private Integer sort;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getSeoKeywords() {
        return seoKeywords;
    }

    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    public Integer getIconType() {
        return iconType;
    }

    public void setIconType(Integer iconType) {
        this.iconType = iconType;
    }

    public String getIconSys() {
        return iconSys;
    }

    public void setIconSys(String iconSys) {
        this.iconSys = iconSys;
    }

    public Long getIconAccessoryId() {
        return iconAccessoryId;
    }

    public void setIconAccessoryId(Long iconAccessoryId) {
        this.iconAccessoryId = iconAccessoryId;
    }

    public Long getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Long goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
