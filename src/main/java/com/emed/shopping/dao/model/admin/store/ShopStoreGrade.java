package com.emed.shopping.dao.model.admin.store;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class ShopStoreGrade {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private Date addTime;

    private Boolean deleteStatus;

    private String addFunciton;     //可用附加功能

    private Boolean audit;

    private Integer goodsCount;     //允许发布商品数

    private Integer gradeLevel;     //等级

    private String gradeName;       //等级名称

    private String price;           //收费标准

    private Integer sequence;

    private Float spacesize;        //可上传附件大小

    private Boolean sysgrade;       //系统等级

    private String templates;       //可选模板数量

    private Integer acountNum;      //子账号数量

    private String content;         //申请备注

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

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getAddFunciton() {
        return addFunciton;
    }

    public void setAddFunciton(String addFunciton) {
        this.addFunciton = addFunciton == null ? null : addFunciton.trim();
    }

    public Boolean getAudit() {
        return audit;
    }

    public void setAudit(Boolean audit) {
        this.audit = audit;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(Integer gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName == null ? null : gradeName.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Float getSpacesize() {
        return spacesize;
    }

    public void setSpacesize(Float spacesize) {
        this.spacesize = spacesize;
    }

    public Boolean getSysgrade() {
        return sysgrade;
    }

    public void setSysgrade(Boolean sysgrade) {
        this.sysgrade = sysgrade;
    }

    public String getTemplates() {
        return templates;
    }

    public void setTemplates(String templates) {
        this.templates = templates == null ? null : templates.trim();
    }

    public Integer getAcountNum() {
        return acountNum;
    }

    public void setAcountNum(Integer acountNum) {
        this.acountNum = acountNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}