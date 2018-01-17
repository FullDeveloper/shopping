package com.emed.shopping.dao.model.admin.goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ShopGoods implements Serializable {
    private Long id;

    /**
     * 商品名称
     *
     * @mbg.generated
     */
    private String goodsName;

    /**
     * 商品价格
     *
     * @mbg.generated
     */
    private BigDecimal goodsPrice;

    /**
     * 商店价格
     *
     * @mbg.generated
     */
    private BigDecimal storePrice;

    /**
     * 库存数量
     *
     * @mbg.generated
     */
    private Integer goodsInventory;

    /**
     * 库存类型
     *
     * @mbg.generated
     */
    private String inventoryType;

    /**
     * 销售量
     *
     * @mbg.generated
     */
    private Integer goodsSales;

    /**
     * 序列号
     *
     * @mbg.generated
     */
    private String goodsSerial;

    /**
     * 货物重量
     *
     * @mbg.generated
     */
    private BigDecimal goodsWeight;

    /**
     * 货物量
     *
     * @mbg.generated
     */
    private BigDecimal goodsVolume;

    /**
     * 货物小费
     *
     * @mbg.generated
     */
    private String goodsFee;

    /**
     * 是否为推荐店铺
     *
     * @mbg.generated
     */
    private String storeRecommend;

    /**
     * 推荐店铺时间
     *
     * @mbg.generated
     */
    private Date storeRecommendTime;

    /**
     * 是否为推荐货物
     *
     * @mbg.generated
     */
    private String goodsRecommend;

    /**
     * 货物点击量
     *
     * @mbg.generated
     */
    private Integer goodsClick;

    /**
     * 货物收藏量
     *
     * @mbg.generated
     */
    private Integer goodsCollect;

    /**
     * 货物所属商店
     *
     * @mbg.generated
     */
    private Long goodsStoreId;

    /**
     * 货物状态
     *
     * @mbg.generated
     */
    private Integer goodsStatus;

    /**
     * 货物卖方时间
     *
     * @mbg.generated
     */
    private Date goodsSellerTime;

    /**
     * 货物转让
     *
     * @mbg.generated
     */
    private Integer goodsTransfer;

    /**
     * 货物所属分类
     *
     * @mbg.generated
     */
    private Long goodsClassId;

    /**
     * 货物主照片
     *
     * @mbg.generated
     */
    private Long goodsAccessoryId;

    /**
     * 货物品牌编号
     *
     * @mbg.generated
     */
    private Long goodsBrandId;

    private Integer ztcStatus;

    private Integer ztcPayStatus;

    private Integer ztcPrice;

    private Integer ztcDredgePrice;

    private Date ztcApplyTime;

    private Date ztcBeginTime;

    private Integer ztcGold;

    private Integer ztcClickNum;

    private Long ztcAdminId;

    private Long groupId;

    private Integer groupBuy;

    private Integer goodsChoiceType;

    private BigDecimal goodsCurrentPrice;

    private Integer bargainStatus;

    private Integer deliveryStatus;

    private Integer combinStatus;

    private Date combinBeginTime;

    private Date combinEndTime;

    private BigDecimal combinPrice;

    private Long deliveryId;

    private BigDecimal mailTransFee;

    private BigDecimal expressTransFee;

    private BigDecimal emsTransFee;

    private Long transportId;

    private BigDecimal descriptionEvaluate;

    private String wechatShopRecommend;

    private Date wechatShopRecommendTime;

    private String wechatShopHot;

    private Date wechatShopHotTime;

    /**
     * SEO关键字
     *
     * @mbg.generated
     */
    private String seoKeywords;

    /**
     * SEO描述
     *
     * @mbg.generated
     */
    private String seoDescription;

    /**
     * 商品详情
     *
     * @mbg.generated
     */
    private String goodsDetails;

    /**
     * 货物属性
     *
     * @mbg.generated
     */
    private String goodsProperty;

    /**
     * 货物库存详情
     *
     * @mbg.generated
     */
    private String goodsInventoryDetails;

    private String ztcAdminContent;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getStorePrice() {
        return storePrice;
    }

    public void setStorePrice(BigDecimal storePrice) {
        this.storePrice = storePrice;
    }

    public Integer getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(Integer goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public Integer getGoodsSales() {
        return goodsSales;
    }

    public void setGoodsSales(Integer goodsSales) {
        this.goodsSales = goodsSales;
    }

    public String getGoodsSerial() {
        return goodsSerial;
    }

    public void setGoodsSerial(String goodsSerial) {
        this.goodsSerial = goodsSerial;
    }

    public BigDecimal getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(BigDecimal goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public BigDecimal getGoodsVolume() {
        return goodsVolume;
    }

    public void setGoodsVolume(BigDecimal goodsVolume) {
        this.goodsVolume = goodsVolume;
    }

    public String getGoodsFee() {
        return goodsFee;
    }

    public void setGoodsFee(String goodsFee) {
        this.goodsFee = goodsFee;
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

    public String getGoodsRecommend() {
        return goodsRecommend;
    }

    public void setGoodsRecommend(String goodsRecommend) {
        this.goodsRecommend = goodsRecommend;
    }

    public Integer getGoodsClick() {
        return goodsClick;
    }

    public void setGoodsClick(Integer goodsClick) {
        this.goodsClick = goodsClick;
    }

    public Integer getGoodsCollect() {
        return goodsCollect;
    }

    public void setGoodsCollect(Integer goodsCollect) {
        this.goodsCollect = goodsCollect;
    }

    public Long getGoodsStoreId() {
        return goodsStoreId;
    }

    public void setGoodsStoreId(Long goodsStoreId) {
        this.goodsStoreId = goodsStoreId;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public Date getGoodsSellerTime() {
        return goodsSellerTime;
    }

    public void setGoodsSellerTime(Date goodsSellerTime) {
        this.goodsSellerTime = goodsSellerTime;
    }

    public Integer getGoodsTransfer() {
        return goodsTransfer;
    }

    public void setGoodsTransfer(Integer goodsTransfer) {
        this.goodsTransfer = goodsTransfer;
    }

    public Long getGoodsClassId() {
        return goodsClassId;
    }

    public void setGoodsClassId(Long goodsClassId) {
        this.goodsClassId = goodsClassId;
    }

    public Long getGoodsAccessoryId() {
        return goodsAccessoryId;
    }

    public void setGoodsAccessoryId(Long goodsAccessoryId) {
        this.goodsAccessoryId = goodsAccessoryId;
    }

    public Long getGoodsBrandId() {
        return goodsBrandId;
    }

    public void setGoodsBrandId(Long goodsBrandId) {
        this.goodsBrandId = goodsBrandId;
    }

    public Integer getZtcStatus() {
        return ztcStatus;
    }

    public void setZtcStatus(Integer ztcStatus) {
        this.ztcStatus = ztcStatus;
    }

    public Integer getZtcPayStatus() {
        return ztcPayStatus;
    }

    public void setZtcPayStatus(Integer ztcPayStatus) {
        this.ztcPayStatus = ztcPayStatus;
    }

    public Integer getZtcPrice() {
        return ztcPrice;
    }

    public void setZtcPrice(Integer ztcPrice) {
        this.ztcPrice = ztcPrice;
    }

    public Integer getZtcDredgePrice() {
        return ztcDredgePrice;
    }

    public void setZtcDredgePrice(Integer ztcDredgePrice) {
        this.ztcDredgePrice = ztcDredgePrice;
    }

    public Date getZtcApplyTime() {
        return ztcApplyTime;
    }

    public void setZtcApplyTime(Date ztcApplyTime) {
        this.ztcApplyTime = ztcApplyTime;
    }

    public Date getZtcBeginTime() {
        return ztcBeginTime;
    }

    public void setZtcBeginTime(Date ztcBeginTime) {
        this.ztcBeginTime = ztcBeginTime;
    }

    public Integer getZtcGold() {
        return ztcGold;
    }

    public void setZtcGold(Integer ztcGold) {
        this.ztcGold = ztcGold;
    }

    public Integer getZtcClickNum() {
        return ztcClickNum;
    }

    public void setZtcClickNum(Integer ztcClickNum) {
        this.ztcClickNum = ztcClickNum;
    }

    public Long getZtcAdminId() {
        return ztcAdminId;
    }

    public void setZtcAdminId(Long ztcAdminId) {
        this.ztcAdminId = ztcAdminId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Integer getGroupBuy() {
        return groupBuy;
    }

    public void setGroupBuy(Integer groupBuy) {
        this.groupBuy = groupBuy;
    }

    public Integer getGoodsChoiceType() {
        return goodsChoiceType;
    }

    public void setGoodsChoiceType(Integer goodsChoiceType) {
        this.goodsChoiceType = goodsChoiceType;
    }

    public BigDecimal getGoodsCurrentPrice() {
        return goodsCurrentPrice;
    }

    public void setGoodsCurrentPrice(BigDecimal goodsCurrentPrice) {
        this.goodsCurrentPrice = goodsCurrentPrice;
    }

    public Integer getBargainStatus() {
        return bargainStatus;
    }

    public void setBargainStatus(Integer bargainStatus) {
        this.bargainStatus = bargainStatus;
    }

    public Integer getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(Integer deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Integer getCombinStatus() {
        return combinStatus;
    }

    public void setCombinStatus(Integer combinStatus) {
        this.combinStatus = combinStatus;
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

    public BigDecimal getCombinPrice() {
        return combinPrice;
    }

    public void setCombinPrice(BigDecimal combinPrice) {
        this.combinPrice = combinPrice;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public BigDecimal getMailTransFee() {
        return mailTransFee;
    }

    public void setMailTransFee(BigDecimal mailTransFee) {
        this.mailTransFee = mailTransFee;
    }

    public BigDecimal getExpressTransFee() {
        return expressTransFee;
    }

    public void setExpressTransFee(BigDecimal expressTransFee) {
        this.expressTransFee = expressTransFee;
    }

    public BigDecimal getEmsTransFee() {
        return emsTransFee;
    }

    public void setEmsTransFee(BigDecimal emsTransFee) {
        this.emsTransFee = emsTransFee;
    }

    public Long getTransportId() {
        return transportId;
    }

    public void setTransportId(Long transportId) {
        this.transportId = transportId;
    }

    public BigDecimal getDescriptionEvaluate() {
        return descriptionEvaluate;
    }

    public void setDescriptionEvaluate(BigDecimal descriptionEvaluate) {
        this.descriptionEvaluate = descriptionEvaluate;
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

    public String getWechatShopHot() {
        return wechatShopHot;
    }

    public void setWechatShopHot(String wechatShopHot) {
        this.wechatShopHot = wechatShopHot;
    }

    public Date getWechatShopHotTime() {
        return wechatShopHotTime;
    }

    public void setWechatShopHotTime(Date wechatShopHotTime) {
        this.wechatShopHotTime = wechatShopHotTime;
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

    public String getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public String getGoodsProperty() {
        return goodsProperty;
    }

    public void setGoodsProperty(String goodsProperty) {
        this.goodsProperty = goodsProperty;
    }

    public String getGoodsInventoryDetails() {
        return goodsInventoryDetails;
    }

    public void setGoodsInventoryDetails(String goodsInventoryDetails) {
        this.goodsInventoryDetails = goodsInventoryDetails;
    }

    public String getZtcAdminContent() {
        return ztcAdminContent;
    }

    public void setZtcAdminContent(String ztcAdminContent) {
        this.ztcAdminContent = ztcAdminContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", storePrice=").append(storePrice);
        sb.append(", goodsInventory=").append(goodsInventory);
        sb.append(", inventoryType=").append(inventoryType);
        sb.append(", goodsSales=").append(goodsSales);
        sb.append(", goodsSerial=").append(goodsSerial);
        sb.append(", goodsWeight=").append(goodsWeight);
        sb.append(", goodsVolume=").append(goodsVolume);
        sb.append(", goodsFee=").append(goodsFee);
        sb.append(", storeRecommend=").append(storeRecommend);
        sb.append(", storeRecommendTime=").append(storeRecommendTime);
        sb.append(", goodsRecommend=").append(goodsRecommend);
        sb.append(", goodsClick=").append(goodsClick);
        sb.append(", goodsCollect=").append(goodsCollect);
        sb.append(", goodsStoreId=").append(goodsStoreId);
        sb.append(", goodsStatus=").append(goodsStatus);
        sb.append(", goodsSellerTime=").append(goodsSellerTime);
        sb.append(", goodsTransfer=").append(goodsTransfer);
        sb.append(", goodsClassId=").append(goodsClassId);
        sb.append(", goodsAccessoryId=").append(goodsAccessoryId);
        sb.append(", goodsBrandId=").append(goodsBrandId);
        sb.append(", ztcStatus=").append(ztcStatus);
        sb.append(", ztcPayStatus=").append(ztcPayStatus);
        sb.append(", ztcPrice=").append(ztcPrice);
        sb.append(", ztcDredgePrice=").append(ztcDredgePrice);
        sb.append(", ztcApplyTime=").append(ztcApplyTime);
        sb.append(", ztcBeginTime=").append(ztcBeginTime);
        sb.append(", ztcGold=").append(ztcGold);
        sb.append(", ztcClickNum=").append(ztcClickNum);
        sb.append(", ztcAdminId=").append(ztcAdminId);
        sb.append(", groupId=").append(groupId);
        sb.append(", groupBuy=").append(groupBuy);
        sb.append(", goodsChoiceType=").append(goodsChoiceType);
        sb.append(", goodsCurrentPrice=").append(goodsCurrentPrice);
        sb.append(", bargainStatus=").append(bargainStatus);
        sb.append(", deliveryStatus=").append(deliveryStatus);
        sb.append(", combinStatus=").append(combinStatus);
        sb.append(", combinBeginTime=").append(combinBeginTime);
        sb.append(", combinEndTime=").append(combinEndTime);
        sb.append(", combinPrice=").append(combinPrice);
        sb.append(", deliveryId=").append(deliveryId);
        sb.append(", mailTransFee=").append(mailTransFee);
        sb.append(", expressTransFee=").append(expressTransFee);
        sb.append(", emsTransFee=").append(emsTransFee);
        sb.append(", transportId=").append(transportId);
        sb.append(", descriptionEvaluate=").append(descriptionEvaluate);
        sb.append(", wechatShopRecommend=").append(wechatShopRecommend);
        sb.append(", wechatShopRecommendTime=").append(wechatShopRecommendTime);
        sb.append(", wechatShopHot=").append(wechatShopHot);
        sb.append(", wechatShopHotTime=").append(wechatShopHotTime);
        sb.append(", seoKeywords=").append(seoKeywords);
        sb.append(", seoDescription=").append(seoDescription);
        sb.append(", goodsDetails=").append(goodsDetails);
        sb.append(", goodsProperty=").append(goodsProperty);
        sb.append(", goodsInventoryDetails=").append(goodsInventoryDetails);
        sb.append(", ztcAdminContent=").append(ztcAdminContent);
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
        ShopGoods other = (ShopGoods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getGoodsPrice() == null ? other.getGoodsPrice() == null : this.getGoodsPrice().equals(other.getGoodsPrice()))
            && (this.getStorePrice() == null ? other.getStorePrice() == null : this.getStorePrice().equals(other.getStorePrice()))
            && (this.getGoodsInventory() == null ? other.getGoodsInventory() == null : this.getGoodsInventory().equals(other.getGoodsInventory()))
            && (this.getInventoryType() == null ? other.getInventoryType() == null : this.getInventoryType().equals(other.getInventoryType()))
            && (this.getGoodsSales() == null ? other.getGoodsSales() == null : this.getGoodsSales().equals(other.getGoodsSales()))
            && (this.getGoodsSerial() == null ? other.getGoodsSerial() == null : this.getGoodsSerial().equals(other.getGoodsSerial()))
            && (this.getGoodsWeight() == null ? other.getGoodsWeight() == null : this.getGoodsWeight().equals(other.getGoodsWeight()))
            && (this.getGoodsVolume() == null ? other.getGoodsVolume() == null : this.getGoodsVolume().equals(other.getGoodsVolume()))
            && (this.getGoodsFee() == null ? other.getGoodsFee() == null : this.getGoodsFee().equals(other.getGoodsFee()))
            && (this.getStoreRecommend() == null ? other.getStoreRecommend() == null : this.getStoreRecommend().equals(other.getStoreRecommend()))
            && (this.getStoreRecommendTime() == null ? other.getStoreRecommendTime() == null : this.getStoreRecommendTime().equals(other.getStoreRecommendTime()))
            && (this.getGoodsRecommend() == null ? other.getGoodsRecommend() == null : this.getGoodsRecommend().equals(other.getGoodsRecommend()))
            && (this.getGoodsClick() == null ? other.getGoodsClick() == null : this.getGoodsClick().equals(other.getGoodsClick()))
            && (this.getGoodsCollect() == null ? other.getGoodsCollect() == null : this.getGoodsCollect().equals(other.getGoodsCollect()))
            && (this.getGoodsStoreId() == null ? other.getGoodsStoreId() == null : this.getGoodsStoreId().equals(other.getGoodsStoreId()))
            && (this.getGoodsStatus() == null ? other.getGoodsStatus() == null : this.getGoodsStatus().equals(other.getGoodsStatus()))
            && (this.getGoodsSellerTime() == null ? other.getGoodsSellerTime() == null : this.getGoodsSellerTime().equals(other.getGoodsSellerTime()))
            && (this.getGoodsTransfer() == null ? other.getGoodsTransfer() == null : this.getGoodsTransfer().equals(other.getGoodsTransfer()))
            && (this.getGoodsClassId() == null ? other.getGoodsClassId() == null : this.getGoodsClassId().equals(other.getGoodsClassId()))
            && (this.getGoodsAccessoryId() == null ? other.getGoodsAccessoryId() == null : this.getGoodsAccessoryId().equals(other.getGoodsAccessoryId()))
            && (this.getGoodsBrandId() == null ? other.getGoodsBrandId() == null : this.getGoodsBrandId().equals(other.getGoodsBrandId()))
            && (this.getZtcStatus() == null ? other.getZtcStatus() == null : this.getZtcStatus().equals(other.getZtcStatus()))
            && (this.getZtcPayStatus() == null ? other.getZtcPayStatus() == null : this.getZtcPayStatus().equals(other.getZtcPayStatus()))
            && (this.getZtcPrice() == null ? other.getZtcPrice() == null : this.getZtcPrice().equals(other.getZtcPrice()))
            && (this.getZtcDredgePrice() == null ? other.getZtcDredgePrice() == null : this.getZtcDredgePrice().equals(other.getZtcDredgePrice()))
            && (this.getZtcApplyTime() == null ? other.getZtcApplyTime() == null : this.getZtcApplyTime().equals(other.getZtcApplyTime()))
            && (this.getZtcBeginTime() == null ? other.getZtcBeginTime() == null : this.getZtcBeginTime().equals(other.getZtcBeginTime()))
            && (this.getZtcGold() == null ? other.getZtcGold() == null : this.getZtcGold().equals(other.getZtcGold()))
            && (this.getZtcClickNum() == null ? other.getZtcClickNum() == null : this.getZtcClickNum().equals(other.getZtcClickNum()))
            && (this.getZtcAdminId() == null ? other.getZtcAdminId() == null : this.getZtcAdminId().equals(other.getZtcAdminId()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getGroupBuy() == null ? other.getGroupBuy() == null : this.getGroupBuy().equals(other.getGroupBuy()))
            && (this.getGoodsChoiceType() == null ? other.getGoodsChoiceType() == null : this.getGoodsChoiceType().equals(other.getGoodsChoiceType()))
            && (this.getGoodsCurrentPrice() == null ? other.getGoodsCurrentPrice() == null : this.getGoodsCurrentPrice().equals(other.getGoodsCurrentPrice()))
            && (this.getBargainStatus() == null ? other.getBargainStatus() == null : this.getBargainStatus().equals(other.getBargainStatus()))
            && (this.getDeliveryStatus() == null ? other.getDeliveryStatus() == null : this.getDeliveryStatus().equals(other.getDeliveryStatus()))
            && (this.getCombinStatus() == null ? other.getCombinStatus() == null : this.getCombinStatus().equals(other.getCombinStatus()))
            && (this.getCombinBeginTime() == null ? other.getCombinBeginTime() == null : this.getCombinBeginTime().equals(other.getCombinBeginTime()))
            && (this.getCombinEndTime() == null ? other.getCombinEndTime() == null : this.getCombinEndTime().equals(other.getCombinEndTime()))
            && (this.getCombinPrice() == null ? other.getCombinPrice() == null : this.getCombinPrice().equals(other.getCombinPrice()))
            && (this.getDeliveryId() == null ? other.getDeliveryId() == null : this.getDeliveryId().equals(other.getDeliveryId()))
            && (this.getMailTransFee() == null ? other.getMailTransFee() == null : this.getMailTransFee().equals(other.getMailTransFee()))
            && (this.getExpressTransFee() == null ? other.getExpressTransFee() == null : this.getExpressTransFee().equals(other.getExpressTransFee()))
            && (this.getEmsTransFee() == null ? other.getEmsTransFee() == null : this.getEmsTransFee().equals(other.getEmsTransFee()))
            && (this.getTransportId() == null ? other.getTransportId() == null : this.getTransportId().equals(other.getTransportId()))
            && (this.getDescriptionEvaluate() == null ? other.getDescriptionEvaluate() == null : this.getDescriptionEvaluate().equals(other.getDescriptionEvaluate()))
            && (this.getWechatShopRecommend() == null ? other.getWechatShopRecommend() == null : this.getWechatShopRecommend().equals(other.getWechatShopRecommend()))
            && (this.getWechatShopRecommendTime() == null ? other.getWechatShopRecommendTime() == null : this.getWechatShopRecommendTime().equals(other.getWechatShopRecommendTime()))
            && (this.getWechatShopHot() == null ? other.getWechatShopHot() == null : this.getWechatShopHot().equals(other.getWechatShopHot()))
            && (this.getWechatShopHotTime() == null ? other.getWechatShopHotTime() == null : this.getWechatShopHotTime().equals(other.getWechatShopHotTime()))
            && (this.getSeoKeywords() == null ? other.getSeoKeywords() == null : this.getSeoKeywords().equals(other.getSeoKeywords()))
            && (this.getSeoDescription() == null ? other.getSeoDescription() == null : this.getSeoDescription().equals(other.getSeoDescription()))
            && (this.getGoodsDetails() == null ? other.getGoodsDetails() == null : this.getGoodsDetails().equals(other.getGoodsDetails()))
            && (this.getGoodsProperty() == null ? other.getGoodsProperty() == null : this.getGoodsProperty().equals(other.getGoodsProperty()))
            && (this.getGoodsInventoryDetails() == null ? other.getGoodsInventoryDetails() == null : this.getGoodsInventoryDetails().equals(other.getGoodsInventoryDetails()))
            && (this.getZtcAdminContent() == null ? other.getZtcAdminContent() == null : this.getZtcAdminContent().equals(other.getZtcAdminContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getGoodsPrice() == null) ? 0 : getGoodsPrice().hashCode());
        result = prime * result + ((getStorePrice() == null) ? 0 : getStorePrice().hashCode());
        result = prime * result + ((getGoodsInventory() == null) ? 0 : getGoodsInventory().hashCode());
        result = prime * result + ((getInventoryType() == null) ? 0 : getInventoryType().hashCode());
        result = prime * result + ((getGoodsSales() == null) ? 0 : getGoodsSales().hashCode());
        result = prime * result + ((getGoodsSerial() == null) ? 0 : getGoodsSerial().hashCode());
        result = prime * result + ((getGoodsWeight() == null) ? 0 : getGoodsWeight().hashCode());
        result = prime * result + ((getGoodsVolume() == null) ? 0 : getGoodsVolume().hashCode());
        result = prime * result + ((getGoodsFee() == null) ? 0 : getGoodsFee().hashCode());
        result = prime * result + ((getStoreRecommend() == null) ? 0 : getStoreRecommend().hashCode());
        result = prime * result + ((getStoreRecommendTime() == null) ? 0 : getStoreRecommendTime().hashCode());
        result = prime * result + ((getGoodsRecommend() == null) ? 0 : getGoodsRecommend().hashCode());
        result = prime * result + ((getGoodsClick() == null) ? 0 : getGoodsClick().hashCode());
        result = prime * result + ((getGoodsCollect() == null) ? 0 : getGoodsCollect().hashCode());
        result = prime * result + ((getGoodsStoreId() == null) ? 0 : getGoodsStoreId().hashCode());
        result = prime * result + ((getGoodsStatus() == null) ? 0 : getGoodsStatus().hashCode());
        result = prime * result + ((getGoodsSellerTime() == null) ? 0 : getGoodsSellerTime().hashCode());
        result = prime * result + ((getGoodsTransfer() == null) ? 0 : getGoodsTransfer().hashCode());
        result = prime * result + ((getGoodsClassId() == null) ? 0 : getGoodsClassId().hashCode());
        result = prime * result + ((getGoodsAccessoryId() == null) ? 0 : getGoodsAccessoryId().hashCode());
        result = prime * result + ((getGoodsBrandId() == null) ? 0 : getGoodsBrandId().hashCode());
        result = prime * result + ((getZtcStatus() == null) ? 0 : getZtcStatus().hashCode());
        result = prime * result + ((getZtcPayStatus() == null) ? 0 : getZtcPayStatus().hashCode());
        result = prime * result + ((getZtcPrice() == null) ? 0 : getZtcPrice().hashCode());
        result = prime * result + ((getZtcDredgePrice() == null) ? 0 : getZtcDredgePrice().hashCode());
        result = prime * result + ((getZtcApplyTime() == null) ? 0 : getZtcApplyTime().hashCode());
        result = prime * result + ((getZtcBeginTime() == null) ? 0 : getZtcBeginTime().hashCode());
        result = prime * result + ((getZtcGold() == null) ? 0 : getZtcGold().hashCode());
        result = prime * result + ((getZtcClickNum() == null) ? 0 : getZtcClickNum().hashCode());
        result = prime * result + ((getZtcAdminId() == null) ? 0 : getZtcAdminId().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getGroupBuy() == null) ? 0 : getGroupBuy().hashCode());
        result = prime * result + ((getGoodsChoiceType() == null) ? 0 : getGoodsChoiceType().hashCode());
        result = prime * result + ((getGoodsCurrentPrice() == null) ? 0 : getGoodsCurrentPrice().hashCode());
        result = prime * result + ((getBargainStatus() == null) ? 0 : getBargainStatus().hashCode());
        result = prime * result + ((getDeliveryStatus() == null) ? 0 : getDeliveryStatus().hashCode());
        result = prime * result + ((getCombinStatus() == null) ? 0 : getCombinStatus().hashCode());
        result = prime * result + ((getCombinBeginTime() == null) ? 0 : getCombinBeginTime().hashCode());
        result = prime * result + ((getCombinEndTime() == null) ? 0 : getCombinEndTime().hashCode());
        result = prime * result + ((getCombinPrice() == null) ? 0 : getCombinPrice().hashCode());
        result = prime * result + ((getDeliveryId() == null) ? 0 : getDeliveryId().hashCode());
        result = prime * result + ((getMailTransFee() == null) ? 0 : getMailTransFee().hashCode());
        result = prime * result + ((getExpressTransFee() == null) ? 0 : getExpressTransFee().hashCode());
        result = prime * result + ((getEmsTransFee() == null) ? 0 : getEmsTransFee().hashCode());
        result = prime * result + ((getTransportId() == null) ? 0 : getTransportId().hashCode());
        result = prime * result + ((getDescriptionEvaluate() == null) ? 0 : getDescriptionEvaluate().hashCode());
        result = prime * result + ((getWechatShopRecommend() == null) ? 0 : getWechatShopRecommend().hashCode());
        result = prime * result + ((getWechatShopRecommendTime() == null) ? 0 : getWechatShopRecommendTime().hashCode());
        result = prime * result + ((getWechatShopHot() == null) ? 0 : getWechatShopHot().hashCode());
        result = prime * result + ((getWechatShopHotTime() == null) ? 0 : getWechatShopHotTime().hashCode());
        result = prime * result + ((getSeoKeywords() == null) ? 0 : getSeoKeywords().hashCode());
        result = prime * result + ((getSeoDescription() == null) ? 0 : getSeoDescription().hashCode());
        result = prime * result + ((getGoodsDetails() == null) ? 0 : getGoodsDetails().hashCode());
        result = prime * result + ((getGoodsProperty() == null) ? 0 : getGoodsProperty().hashCode());
        result = prime * result + ((getGoodsInventoryDetails() == null) ? 0 : getGoodsInventoryDetails().hashCode());
        result = prime * result + ((getZtcAdminContent() == null) ? 0 : getZtcAdminContent().hashCode());
        return result;
    }
}