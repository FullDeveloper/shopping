package com.emed.shopping.dao.model.admin.goods;

import java.io.Serializable;
import java.util.Date;

public class ShopGoodsSpecProperty implements Serializable {
    private Long id;

    /**
     * 商品规格属性值
     *
     * @mbg.generated
     */
    private String value;

    /**
     * 商品规格编号
     *
     * @mbg.generated
     */
    private Long specificationId;

    /**
     * 规格图片编号
     *
     * @mbg.generated
     */
    private Long specificationImageId;

    /**
     * 排序
     *
     * @mbg.generated
     */
    private Integer sort;

    /**
     * 删除状态
     *
     * @mbg.generated
     */
    private String deleteStatus;

    /**
     * 添加时间
     *
     * @mbg.generated
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
    }

    public Long getSpecificationImageId() {
        return specificationImageId;
    }

    public void setSpecificationImageId(Long specificationImageId) {
        this.specificationImageId = specificationImageId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", value=").append(value);
        sb.append(", specificationId=").append(specificationId);
        sb.append(", specificationImageId=").append(specificationImageId);
        sb.append(", sort=").append(sort);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", createTime=").append(createTime);
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
        ShopGoodsSpecProperty other = (ShopGoodsSpecProperty) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getSpecificationId() == null ? other.getSpecificationId() == null : this.getSpecificationId().equals(other.getSpecificationId()))
            && (this.getSpecificationImageId() == null ? other.getSpecificationImageId() == null : this.getSpecificationImageId().equals(other.getSpecificationImageId()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getDeleteStatus() == null ? other.getDeleteStatus() == null : this.getDeleteStatus().equals(other.getDeleteStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getSpecificationId() == null) ? 0 : getSpecificationId().hashCode());
        result = prime * result + ((getSpecificationImageId() == null) ? 0 : getSpecificationImageId().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getDeleteStatus() == null) ? 0 : getDeleteStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}