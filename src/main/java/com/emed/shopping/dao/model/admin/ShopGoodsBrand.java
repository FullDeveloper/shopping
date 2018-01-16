package com.emed.shopping.dao.model.admin;

import com.emed.shopping.base.BaseModel;

import java.util.Date;

/**
 * @Author: 周润斌
 * @Date: create in 上午 11:36 2018/1/16 0016
 * @Description:
 */
public class ShopGoodsBrand extends BaseModel {

    private String name;

    private Long Accessory_id;

    private String recommend;

    private String audit;

    private Long userId;

    private Long categoryId;

    private String wechatShopRecommend;

    private Date wechatShopRecommendTime;

    private Integer sort;

    private String firstWord;

    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAccessory_id() {
        return Accessory_id;
    }

    public void setAccessory_id(Long accessory_id) {
        Accessory_id = accessory_id;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getWechatShopRecommend() {
        return wechatShopRecommend;
    }

    public void setWechatShopRecommend(String wechatShopRecommend) {
        this.wechatShopRecommend = wechatShopRecommend;
    }

    public Date getWechatShopRecommendTime() {
        return wechatShopRecommendTime;
    }

    public void setWechatShopRecommendTime(Date wechatShopRecommendTime) {
        this.wechatShopRecommendTime = wechatShopRecommendTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
