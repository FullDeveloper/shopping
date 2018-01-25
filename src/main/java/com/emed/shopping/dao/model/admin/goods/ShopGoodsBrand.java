package com.emed.shopping.dao.model.admin.goods;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class ShopGoodsBrand implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 品牌logo
     *
     * @mbg.generated
     */
    private Long accessoryId;

    /**
     * 是否推荐
     *
     * @mbg.generated
     */
    private String recommend;

    /**
     * 审计
     *
     * @mbg.generated
     */
    private Integer audit;

    /**
     * 使用者身份
     */
    private Integer userStatus;

    /**
     * 所属用户
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     * 品牌所属种类
     *
     * @mbg.generated
     */
    private Long categoryId;

    /**
     * 是否在微信店铺推荐
     *
     * @mbg.generated
     */
    private String wechatShopRecommend;

    /**
     * 微信店铺推荐时间
     *
     * @mbg.generated
     */
    private Date wechatShopRecommendTime;

    /**
     * 排序
     *
     * @mbg.generated
     */
    private Integer sort;

    /**
     * 首字母
     *
     * @mbg.generated
     */
    private String firstWord;

    /**
     * 添加时间
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 删除状态
     *
     * @mbg.generated
     */
    private String deleteStatus;

    /**
     * 评论
     *
     * @mbg.generated
     */
    private String remark;

    private Boolean checked;

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(Long accessoryId) {
        this.accessoryId = accessoryId;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", accessoryId=").append(accessoryId);
        sb.append(", recommend=").append(recommend);
        sb.append(", audit=").append(audit);
        sb.append(", userId=").append(userId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", wechatShopRecommend=").append(wechatShopRecommend);
        sb.append(", wechatShopRecommendTime=").append(wechatShopRecommendTime);
        sb.append(", sort=").append(sort);
        sb.append(", firstWord=").append(firstWord);
        sb.append(", createTime=").append(createTime);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ShopGoodsBrand other = (ShopGoodsBrand) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAccessoryId() == null ? other.getAccessoryId() == null : this.getAccessoryId().equals(other.getAccessoryId()))
            && (this.getRecommend() == null ? other.getRecommend() == null : this.getRecommend().equals(other.getRecommend()))
            && (this.getAudit() == null ? other.getAudit() == null : this.getAudit().equals(other.getAudit()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getWechatShopRecommend() == null ? other.getWechatShopRecommend() == null : this.getWechatShopRecommend().equals(other.getWechatShopRecommend()))
            && (this.getWechatShopRecommendTime() == null ? other.getWechatShopRecommendTime() == null : this.getWechatShopRecommendTime().equals(other.getWechatShopRecommendTime()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getFirstWord() == null ? other.getFirstWord() == null : this.getFirstWord().equals(other.getFirstWord()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDeleteStatus() == null ? other.getDeleteStatus() == null : this.getDeleteStatus().equals(other.getDeleteStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAccessoryId() == null) ? 0 : getAccessoryId().hashCode());
        result = prime * result + ((getRecommend() == null) ? 0 : getRecommend().hashCode());
        result = prime * result + ((getAudit() == null) ? 0 : getAudit().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getWechatShopRecommend() == null) ? 0 : getWechatShopRecommend().hashCode());
        result = prime * result + ((getWechatShopRecommendTime() == null) ? 0 : getWechatShopRecommendTime().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getFirstWord() == null) ? 0 : getFirstWord().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDeleteStatus() == null) ? 0 : getDeleteStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}