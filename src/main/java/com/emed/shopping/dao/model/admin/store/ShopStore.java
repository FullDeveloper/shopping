package com.emed.shopping.dao.model.admin.store;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ShopStore implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 创建日期
     *
     * @mbg.generated
     */
    private Date addTime;

    /**
     * 删除状态
     *
     * @mbg.generated
     */
    private String deleteStatus;

    /**
     * 实名认证
     *
     * @mbg.generated
     */
    private String cardApprove;

    /**
     * 实体认证
     *
     * @mbg.generated
     */
    private String realstoreApprove;

    /**
     * 店铺地址
     *
     * @mbg.generated
     */
    private String storeAddress;

    /**
     * 店铺信誉
     *
     * @mbg.generated
     */
    private Integer storeCredit;

    /**
     * 店铺MSN
     *
     * @mbg.generated
     */
    private String storeMsn;

    /**
     * 店铺名称
     *
     * @mbg.generated
     */
    private String storeName;

    /**
     * 店铺主人
     *
     * @mbg.generated
     */
    private String storeOwer;

    /**
     * 店铺主人身份证号
     *
     * @mbg.generated
     */
    private String storeOwerCard;

    /**
     * 店铺qq
     *
     * @mbg.generated
     */
    private String storeQq;

    /**
     * 是否是商城推荐
     *
     * @mbg.generated
     */
    private String storeRecommend;

    /**
     * 商城推荐时间
     *
     * @mbg.generated
     */
    private Date storeRecommendTime;

    /**
     * 店铺状态
     *
     * @mbg.generated
     */
    private Integer storeStatus;

    /**
     * 店铺电话
     *
     * @mbg.generated
     */
    private String storeTelephone;

    /**
     * 店铺邮编
     *
     * @mbg.generated
     */
    private String storeZip;

    /**
     * 店铺主题颜色
     *
     * @mbg.generated
     */
    private String template;

    /**
     * 有效日期
     *
     * @mbg.generated
     */
    private Date validity;

    private Long areaId;

    private Long cardId;

    /**
     * 店铺等级id
     *
     * @mbg.generated
     */
    private Long gradeId;

    private Long scId;

    private Long storeBannerId;

    /**
     * 店铺执照id
     *
     * @mbg.generated
     */
    private Long storeLicenseId;

    /**
     * 店铺logo的id
     *
     * @mbg.generated
     */
    private Long storeLogoId;

    private Long updateGradeId;

    private Integer domainModifyCount;

    private String storeSecondDomain;

    /**
     * 收藏数量
     *
     * @mbg.generated
     */
    private Integer favoriteCount;

    private BigDecimal storeLat;

    private BigDecimal storeLng;

    private String storeWw;

    /**
     * 地图类型
     *
     * @mbg.generated
     */
    private String mapType;

    private Date deliveryBeginTime;

    private Date deliveryEndTime;

    private Date combinBeginTime;

    private Date combinEndTime;

    private Date weixinBeginTime;

    private Date weixinEndTime;

    /**
     * 微信付费状态
     *
     * @mbg.generated
     */
    private Integer weixinStatus;

    /**
     * 微信appId
     *
     * @mbg.generated
     */
    private String weixinAppid;

    private String weixinAppsecret;

    private String weixinToken;

    private Long weixinQrImgId;

    private String weixinAccount;

    private Long storeWeixinLogoId;

    private String weixinStoreName;

    /**
     * 店铺信息
     *
     * @mbg.generated
     */
    private String storeInfo;

    /**
     * 店铺搜索描述
     *
     * @mbg.generated
     */
    private String storeSeoDescription;

    /**
     * 店铺搜索关键字
     *
     * @mbg.generated
     */
    private String storeSeoKeywords;

    /**
     * 犯规理由
     *
     * @mbg.generated
     */
    private String violationReseaon;

    private String weixinWelecomeContent;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getCardApprove() {
        return cardApprove;
    }

    public void setCardApprove(String cardApprove) {
        this.cardApprove = cardApprove;
    }

    public String getRealstoreApprove() {
        return realstoreApprove;
    }

    public void setRealstoreApprove(String realstoreApprove) {
        this.realstoreApprove = realstoreApprove;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public Integer getStoreCredit() {
        return storeCredit;
    }

    public void setStoreCredit(Integer storeCredit) {
        this.storeCredit = storeCredit;
    }

    public String getStoreMsn() {
        return storeMsn;
    }

    public void setStoreMsn(String storeMsn) {
        this.storeMsn = storeMsn;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreOwer() {
        return storeOwer;
    }

    public void setStoreOwer(String storeOwer) {
        this.storeOwer = storeOwer;
    }

    public String getStoreOwerCard() {
        return storeOwerCard;
    }

    public void setStoreOwerCard(String storeOwerCard) {
        this.storeOwerCard = storeOwerCard;
    }

    public String getStoreQq() {
        return storeQq;
    }

    public void setStoreQq(String storeQq) {
        this.storeQq = storeQq;
    }

    public String getStoreRecommend() {
        return storeRecommend;
    }

    public void setStoreRecommend(String storeRecommend) {
        this.storeRecommend = storeRecommend;
    }

    public Date getStoreRecommendTime() {
        return storeRecommendTime;
    }

    public void setStoreRecommendTime(Date storeRecommendTime) {
        this.storeRecommendTime = storeRecommendTime;
    }

    public Integer getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(Integer storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getStoreTelephone() {
        return storeTelephone;
    }

    public void setStoreTelephone(String storeTelephone) {
        this.storeTelephone = storeTelephone;
    }

    public String getStoreZip() {
        return storeZip;
    }

    public void setStoreZip(String storeZip) {
        this.storeZip = storeZip;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getScId() {
        return scId;
    }

    public void setScId(Long scId) {
        this.scId = scId;
    }

    public Long getStoreBannerId() {
        return storeBannerId;
    }

    public void setStoreBannerId(Long storeBannerId) {
        this.storeBannerId = storeBannerId;
    }

    public Long getStoreLicenseId() {
        return storeLicenseId;
    }

    public void setStoreLicenseId(Long storeLicenseId) {
        this.storeLicenseId = storeLicenseId;
    }

    public Long getStoreLogoId() {
        return storeLogoId;
    }

    public void setStoreLogoId(Long storeLogoId) {
        this.storeLogoId = storeLogoId;
    }

    public Long getUpdateGradeId() {
        return updateGradeId;
    }

    public void setUpdateGradeId(Long updateGradeId) {
        this.updateGradeId = updateGradeId;
    }

    public Integer getDomainModifyCount() {
        return domainModifyCount;
    }

    public void setDomainModifyCount(Integer domainModifyCount) {
        this.domainModifyCount = domainModifyCount;
    }

    public String getStoreSecondDomain() {
        return storeSecondDomain;
    }

    public void setStoreSecondDomain(String storeSecondDomain) {
        this.storeSecondDomain = storeSecondDomain;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public BigDecimal getStoreLat() {
        return storeLat;
    }

    public void setStoreLat(BigDecimal storeLat) {
        this.storeLat = storeLat;
    }

    public BigDecimal getStoreLng() {
        return storeLng;
    }

    public void setStoreLng(BigDecimal storeLng) {
        this.storeLng = storeLng;
    }

    public String getStoreWw() {
        return storeWw;
    }

    public void setStoreWw(String storeWw) {
        this.storeWw = storeWw;
    }

    public String getMapType() {
        return mapType;
    }

    public void setMapType(String mapType) {
        this.mapType = mapType;
    }

    public Date getDeliveryBeginTime() {
        return deliveryBeginTime;
    }

    public void setDeliveryBeginTime(Date deliveryBeginTime) {
        this.deliveryBeginTime = deliveryBeginTime;
    }

    public Date getDeliveryEndTime() {
        return deliveryEndTime;
    }

    public void setDeliveryEndTime(Date deliveryEndTime) {
        this.deliveryEndTime = deliveryEndTime;
    }

    public Date getCombinBeginTime() {
        return combinBeginTime;
    }

    public void setCombinBeginTime(Date combinBeginTime) {
        this.combinBeginTime = combinBeginTime;
    }

    public Date getCombinEndTime() {
        return combinEndTime;
    }

    public void setCombinEndTime(Date combinEndTime) {
        this.combinEndTime = combinEndTime;
    }

    public Date getWeixinBeginTime() {
        return weixinBeginTime;
    }

    public void setWeixinBeginTime(Date weixinBeginTime) {
        this.weixinBeginTime = weixinBeginTime;
    }

    public Date getWeixinEndTime() {
        return weixinEndTime;
    }

    public void setWeixinEndTime(Date weixinEndTime) {
        this.weixinEndTime = weixinEndTime;
    }

    public Integer getWeixinStatus() {
        return weixinStatus;
    }

    public void setWeixinStatus(Integer weixinStatus) {
        this.weixinStatus = weixinStatus;
    }

    public String getWeixinAppid() {
        return weixinAppid;
    }

    public void setWeixinAppid(String weixinAppid) {
        this.weixinAppid = weixinAppid;
    }

    public String getWeixinAppsecret() {
        return weixinAppsecret;
    }

    public void setWeixinAppsecret(String weixinAppsecret) {
        this.weixinAppsecret = weixinAppsecret;
    }

    public String getWeixinToken() {
        return weixinToken;
    }

    public void setWeixinToken(String weixinToken) {
        this.weixinToken = weixinToken;
    }

    public Long getWeixinQrImgId() {
        return weixinQrImgId;
    }

    public void setWeixinQrImgId(Long weixinQrImgId) {
        this.weixinQrImgId = weixinQrImgId;
    }

    public String getWeixinAccount() {
        return weixinAccount;
    }

    public void setWeixinAccount(String weixinAccount) {
        this.weixinAccount = weixinAccount;
    }

    public Long getStoreWeixinLogoId() {
        return storeWeixinLogoId;
    }

    public void setStoreWeixinLogoId(Long storeWeixinLogoId) {
        this.storeWeixinLogoId = storeWeixinLogoId;
    }

    public String getWeixinStoreName() {
        return weixinStoreName;
    }

    public void setWeixinStoreName(String weixinStoreName) {
        this.weixinStoreName = weixinStoreName;
    }

    public String getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(String storeInfo) {
        this.storeInfo = storeInfo;
    }

    public String getStoreSeoDescription() {
        return storeSeoDescription;
    }

    public void setStoreSeoDescription(String storeSeoDescription) {
        this.storeSeoDescription = storeSeoDescription;
    }

    public String getStoreSeoKeywords() {
        return storeSeoKeywords;
    }

    public void setStoreSeoKeywords(String storeSeoKeywords) {
        this.storeSeoKeywords = storeSeoKeywords;
    }

    public String getViolationReseaon() {
        return violationReseaon;
    }

    public void setViolationReseaon(String violationReseaon) {
        this.violationReseaon = violationReseaon;
    }

    public String getWeixinWelecomeContent() {
        return weixinWelecomeContent;
    }

    public void setWeixinWelecomeContent(String weixinWelecomeContent) {
        this.weixinWelecomeContent = weixinWelecomeContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", addTime=").append(addTime);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", cardApprove=").append(cardApprove);
        sb.append(", realstoreApprove=").append(realstoreApprove);
        sb.append(", storeAddress=").append(storeAddress);
        sb.append(", storeCredit=").append(storeCredit);
        sb.append(", storeMsn=").append(storeMsn);
        sb.append(", storeName=").append(storeName);
        sb.append(", storeOwer=").append(storeOwer);
        sb.append(", storeOwerCard=").append(storeOwerCard);
        sb.append(", storeQq=").append(storeQq);
        sb.append(", storeRecommend=").append(storeRecommend);
        sb.append(", storeRecommendTime=").append(storeRecommendTime);
        sb.append(", storeStatus=").append(storeStatus);
        sb.append(", storeTelephone=").append(storeTelephone);
        sb.append(", storeZip=").append(storeZip);
        sb.append(", template=").append(template);
        sb.append(", validity=").append(validity);
        sb.append(", areaId=").append(areaId);
        sb.append(", cardId=").append(cardId);
        sb.append(", gradeId=").append(gradeId);
        sb.append(", scId=").append(scId);
        sb.append(", storeBannerId=").append(storeBannerId);
        sb.append(", storeLicenseId=").append(storeLicenseId);
        sb.append(", storeLogoId=").append(storeLogoId);
        sb.append(", updateGradeId=").append(updateGradeId);
        sb.append(", domainModifyCount=").append(domainModifyCount);
        sb.append(", storeSecondDomain=").append(storeSecondDomain);
        sb.append(", favoriteCount=").append(favoriteCount);
        sb.append(", storeLat=").append(storeLat);
        sb.append(", storeLng=").append(storeLng);
        sb.append(", storeWw=").append(storeWw);
        sb.append(", mapType=").append(mapType);
        sb.append(", deliveryBeginTime=").append(deliveryBeginTime);
        sb.append(", deliveryEndTime=").append(deliveryEndTime);
        sb.append(", combinBeginTime=").append(combinBeginTime);
        sb.append(", combinEndTime=").append(combinEndTime);
        sb.append(", weixinBeginTime=").append(weixinBeginTime);
        sb.append(", weixinEndTime=").append(weixinEndTime);
        sb.append(", weixinStatus=").append(weixinStatus);
        sb.append(", weixinAppid=").append(weixinAppid);
        sb.append(", weixinAppsecret=").append(weixinAppsecret);
        sb.append(", weixinToken=").append(weixinToken);
        sb.append(", weixinQrImgId=").append(weixinQrImgId);
        sb.append(", weixinAccount=").append(weixinAccount);
        sb.append(", storeWeixinLogoId=").append(storeWeixinLogoId);
        sb.append(", weixinStoreName=").append(weixinStoreName);
        sb.append(", storeInfo=").append(storeInfo);
        sb.append(", storeSeoDescription=").append(storeSeoDescription);
        sb.append(", storeSeoKeywords=").append(storeSeoKeywords);
        sb.append(", violationReseaon=").append(violationReseaon);
        sb.append(", weixinWelecomeContent=").append(weixinWelecomeContent);
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
        ShopStore other = (ShopStore) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getDeleteStatus() == null ? other.getDeleteStatus() == null : this.getDeleteStatus().equals(other.getDeleteStatus()))
            && (this.getCardApprove() == null ? other.getCardApprove() == null : this.getCardApprove().equals(other.getCardApprove()))
            && (this.getRealstoreApprove() == null ? other.getRealstoreApprove() == null : this.getRealstoreApprove().equals(other.getRealstoreApprove()))
            && (this.getStoreAddress() == null ? other.getStoreAddress() == null : this.getStoreAddress().equals(other.getStoreAddress()))
            && (this.getStoreCredit() == null ? other.getStoreCredit() == null : this.getStoreCredit().equals(other.getStoreCredit()))
            && (this.getStoreMsn() == null ? other.getStoreMsn() == null : this.getStoreMsn().equals(other.getStoreMsn()))
            && (this.getStoreName() == null ? other.getStoreName() == null : this.getStoreName().equals(other.getStoreName()))
            && (this.getStoreOwer() == null ? other.getStoreOwer() == null : this.getStoreOwer().equals(other.getStoreOwer()))
            && (this.getStoreOwerCard() == null ? other.getStoreOwerCard() == null : this.getStoreOwerCard().equals(other.getStoreOwerCard()))
            && (this.getStoreQq() == null ? other.getStoreQq() == null : this.getStoreQq().equals(other.getStoreQq()))
            && (this.getStoreRecommend() == null ? other.getStoreRecommend() == null : this.getStoreRecommend().equals(other.getStoreRecommend()))
            && (this.getStoreRecommendTime() == null ? other.getStoreRecommendTime() == null : this.getStoreRecommendTime().equals(other.getStoreRecommendTime()))
            && (this.getStoreStatus() == null ? other.getStoreStatus() == null : this.getStoreStatus().equals(other.getStoreStatus()))
            && (this.getStoreTelephone() == null ? other.getStoreTelephone() == null : this.getStoreTelephone().equals(other.getStoreTelephone()))
            && (this.getStoreZip() == null ? other.getStoreZip() == null : this.getStoreZip().equals(other.getStoreZip()))
            && (this.getTemplate() == null ? other.getTemplate() == null : this.getTemplate().equals(other.getTemplate()))
            && (this.getValidity() == null ? other.getValidity() == null : this.getValidity().equals(other.getValidity()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getCardId() == null ? other.getCardId() == null : this.getCardId().equals(other.getCardId()))
            && (this.getGradeId() == null ? other.getGradeId() == null : this.getGradeId().equals(other.getGradeId()))
            && (this.getScId() == null ? other.getScId() == null : this.getScId().equals(other.getScId()))
            && (this.getStoreBannerId() == null ? other.getStoreBannerId() == null : this.getStoreBannerId().equals(other.getStoreBannerId()))
            && (this.getStoreLicenseId() == null ? other.getStoreLicenseId() == null : this.getStoreLicenseId().equals(other.getStoreLicenseId()))
            && (this.getStoreLogoId() == null ? other.getStoreLogoId() == null : this.getStoreLogoId().equals(other.getStoreLogoId()))
            && (this.getUpdateGradeId() == null ? other.getUpdateGradeId() == null : this.getUpdateGradeId().equals(other.getUpdateGradeId()))
            && (this.getDomainModifyCount() == null ? other.getDomainModifyCount() == null : this.getDomainModifyCount().equals(other.getDomainModifyCount()))
            && (this.getStoreSecondDomain() == null ? other.getStoreSecondDomain() == null : this.getStoreSecondDomain().equals(other.getStoreSecondDomain()))
            && (this.getFavoriteCount() == null ? other.getFavoriteCount() == null : this.getFavoriteCount().equals(other.getFavoriteCount()))
            && (this.getStoreLat() == null ? other.getStoreLat() == null : this.getStoreLat().equals(other.getStoreLat()))
            && (this.getStoreLng() == null ? other.getStoreLng() == null : this.getStoreLng().equals(other.getStoreLng()))
            && (this.getStoreWw() == null ? other.getStoreWw() == null : this.getStoreWw().equals(other.getStoreWw()))
            && (this.getMapType() == null ? other.getMapType() == null : this.getMapType().equals(other.getMapType()))
            && (this.getDeliveryBeginTime() == null ? other.getDeliveryBeginTime() == null : this.getDeliveryBeginTime().equals(other.getDeliveryBeginTime()))
            && (this.getDeliveryEndTime() == null ? other.getDeliveryEndTime() == null : this.getDeliveryEndTime().equals(other.getDeliveryEndTime()))
            && (this.getCombinBeginTime() == null ? other.getCombinBeginTime() == null : this.getCombinBeginTime().equals(other.getCombinBeginTime()))
            && (this.getCombinEndTime() == null ? other.getCombinEndTime() == null : this.getCombinEndTime().equals(other.getCombinEndTime()))
            && (this.getWeixinBeginTime() == null ? other.getWeixinBeginTime() == null : this.getWeixinBeginTime().equals(other.getWeixinBeginTime()))
            && (this.getWeixinEndTime() == null ? other.getWeixinEndTime() == null : this.getWeixinEndTime().equals(other.getWeixinEndTime()))
            && (this.getWeixinStatus() == null ? other.getWeixinStatus() == null : this.getWeixinStatus().equals(other.getWeixinStatus()))
            && (this.getWeixinAppid() == null ? other.getWeixinAppid() == null : this.getWeixinAppid().equals(other.getWeixinAppid()))
            && (this.getWeixinAppsecret() == null ? other.getWeixinAppsecret() == null : this.getWeixinAppsecret().equals(other.getWeixinAppsecret()))
            && (this.getWeixinToken() == null ? other.getWeixinToken() == null : this.getWeixinToken().equals(other.getWeixinToken()))
            && (this.getWeixinQrImgId() == null ? other.getWeixinQrImgId() == null : this.getWeixinQrImgId().equals(other.getWeixinQrImgId()))
            && (this.getWeixinAccount() == null ? other.getWeixinAccount() == null : this.getWeixinAccount().equals(other.getWeixinAccount()))
            && (this.getStoreWeixinLogoId() == null ? other.getStoreWeixinLogoId() == null : this.getStoreWeixinLogoId().equals(other.getStoreWeixinLogoId()))
            && (this.getWeixinStoreName() == null ? other.getWeixinStoreName() == null : this.getWeixinStoreName().equals(other.getWeixinStoreName()))
            && (this.getStoreInfo() == null ? other.getStoreInfo() == null : this.getStoreInfo().equals(other.getStoreInfo()))
            && (this.getStoreSeoDescription() == null ? other.getStoreSeoDescription() == null : this.getStoreSeoDescription().equals(other.getStoreSeoDescription()))
            && (this.getStoreSeoKeywords() == null ? other.getStoreSeoKeywords() == null : this.getStoreSeoKeywords().equals(other.getStoreSeoKeywords()))
            && (this.getViolationReseaon() == null ? other.getViolationReseaon() == null : this.getViolationReseaon().equals(other.getViolationReseaon()))
            && (this.getWeixinWelecomeContent() == null ? other.getWeixinWelecomeContent() == null : this.getWeixinWelecomeContent().equals(other.getWeixinWelecomeContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getDeleteStatus() == null) ? 0 : getDeleteStatus().hashCode());
        result = prime * result + ((getCardApprove() == null) ? 0 : getCardApprove().hashCode());
        result = prime * result + ((getRealstoreApprove() == null) ? 0 : getRealstoreApprove().hashCode());
        result = prime * result + ((getStoreAddress() == null) ? 0 : getStoreAddress().hashCode());
        result = prime * result + ((getStoreCredit() == null) ? 0 : getStoreCredit().hashCode());
        result = prime * result + ((getStoreMsn() == null) ? 0 : getStoreMsn().hashCode());
        result = prime * result + ((getStoreName() == null) ? 0 : getStoreName().hashCode());
        result = prime * result + ((getStoreOwer() == null) ? 0 : getStoreOwer().hashCode());
        result = prime * result + ((getStoreOwerCard() == null) ? 0 : getStoreOwerCard().hashCode());
        result = prime * result + ((getStoreQq() == null) ? 0 : getStoreQq().hashCode());
        result = prime * result + ((getStoreRecommend() == null) ? 0 : getStoreRecommend().hashCode());
        result = prime * result + ((getStoreRecommendTime() == null) ? 0 : getStoreRecommendTime().hashCode());
        result = prime * result + ((getStoreStatus() == null) ? 0 : getStoreStatus().hashCode());
        result = prime * result + ((getStoreTelephone() == null) ? 0 : getStoreTelephone().hashCode());
        result = prime * result + ((getStoreZip() == null) ? 0 : getStoreZip().hashCode());
        result = prime * result + ((getTemplate() == null) ? 0 : getTemplate().hashCode());
        result = prime * result + ((getValidity() == null) ? 0 : getValidity().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getCardId() == null) ? 0 : getCardId().hashCode());
        result = prime * result + ((getGradeId() == null) ? 0 : getGradeId().hashCode());
        result = prime * result + ((getScId() == null) ? 0 : getScId().hashCode());
        result = prime * result + ((getStoreBannerId() == null) ? 0 : getStoreBannerId().hashCode());
        result = prime * result + ((getStoreLicenseId() == null) ? 0 : getStoreLicenseId().hashCode());
        result = prime * result + ((getStoreLogoId() == null) ? 0 : getStoreLogoId().hashCode());
        result = prime * result + ((getUpdateGradeId() == null) ? 0 : getUpdateGradeId().hashCode());
        result = prime * result + ((getDomainModifyCount() == null) ? 0 : getDomainModifyCount().hashCode());
        result = prime * result + ((getStoreSecondDomain() == null) ? 0 : getStoreSecondDomain().hashCode());
        result = prime * result + ((getFavoriteCount() == null) ? 0 : getFavoriteCount().hashCode());
        result = prime * result + ((getStoreLat() == null) ? 0 : getStoreLat().hashCode());
        result = prime * result + ((getStoreLng() == null) ? 0 : getStoreLng().hashCode());
        result = prime * result + ((getStoreWw() == null) ? 0 : getStoreWw().hashCode());
        result = prime * result + ((getMapType() == null) ? 0 : getMapType().hashCode());
        result = prime * result + ((getDeliveryBeginTime() == null) ? 0 : getDeliveryBeginTime().hashCode());
        result = prime * result + ((getDeliveryEndTime() == null) ? 0 : getDeliveryEndTime().hashCode());
        result = prime * result + ((getCombinBeginTime() == null) ? 0 : getCombinBeginTime().hashCode());
        result = prime * result + ((getCombinEndTime() == null) ? 0 : getCombinEndTime().hashCode());
        result = prime * result + ((getWeixinBeginTime() == null) ? 0 : getWeixinBeginTime().hashCode());
        result = prime * result + ((getWeixinEndTime() == null) ? 0 : getWeixinEndTime().hashCode());
        result = prime * result + ((getWeixinStatus() == null) ? 0 : getWeixinStatus().hashCode());
        result = prime * result + ((getWeixinAppid() == null) ? 0 : getWeixinAppid().hashCode());
        result = prime * result + ((getWeixinAppsecret() == null) ? 0 : getWeixinAppsecret().hashCode());
        result = prime * result + ((getWeixinToken() == null) ? 0 : getWeixinToken().hashCode());
        result = prime * result + ((getWeixinQrImgId() == null) ? 0 : getWeixinQrImgId().hashCode());
        result = prime * result + ((getWeixinAccount() == null) ? 0 : getWeixinAccount().hashCode());
        result = prime * result + ((getStoreWeixinLogoId() == null) ? 0 : getStoreWeixinLogoId().hashCode());
        result = prime * result + ((getWeixinStoreName() == null) ? 0 : getWeixinStoreName().hashCode());
        result = prime * result + ((getStoreInfo() == null) ? 0 : getStoreInfo().hashCode());
        result = prime * result + ((getStoreSeoDescription() == null) ? 0 : getStoreSeoDescription().hashCode());
        result = prime * result + ((getStoreSeoKeywords() == null) ? 0 : getStoreSeoKeywords().hashCode());
        result = prime * result + ((getViolationReseaon() == null) ? 0 : getViolationReseaon().hashCode());
        result = prime * result + ((getWeixinWelecomeContent() == null) ? 0 : getWeixinWelecomeContent().hashCode());
        return result;
    }
}