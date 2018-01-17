package com.emed.shopping.dao.model.admin.store;

import java.math.BigDecimal;
import java.util.Date;

public class ShopStoreClass {
    private Long id;

    private Date addTime;

    private String deleteStatus;

    private String className;

    private Integer level;

    private Integer sequence;

    private Long parentId;

    private BigDecimal descriptionEvaluate;

    private BigDecimal serviceEvaluate;

    private BigDecimal shipEvaluate;

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
        this.deleteStatus = deleteStatus == null ? null : deleteStatus.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public BigDecimal getDescriptionEvaluate() {
        return descriptionEvaluate;
    }

    public void setDescriptionEvaluate(BigDecimal descriptionEvaluate) {
        this.descriptionEvaluate = descriptionEvaluate;
    }

    public BigDecimal getServiceEvaluate() {
        return serviceEvaluate;
    }

    public void setServiceEvaluate(BigDecimal serviceEvaluate) {
        this.serviceEvaluate = serviceEvaluate;
    }

    public BigDecimal getShipEvaluate() {
        return shipEvaluate;
    }

    public void setShipEvaluate(BigDecimal shipEvaluate) {
        this.shipEvaluate = shipEvaluate;
    }
}