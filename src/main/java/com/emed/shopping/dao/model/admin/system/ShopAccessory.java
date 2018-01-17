package com.emed.shopping.dao.model.admin.system;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class ShopAccessory implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 附件名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 附件路径
     *
     * @mbg.generated
     */
    private String path;

    /**
     * 后缀名
     *
     * @mbg.generated
     */
    private String ext;

    /**
     * 大小
     *
     * @mbg.generated
     */
    private Integer size;

    /**
     * 高度
     *
     * @mbg.generated
     */
    private Integer height;

    /**
     * 宽度
     *
     * @mbg.generated
     */
    private Integer width;

    /**
     * 详情
     *
     * @mbg.generated
     */
    private String info;

    /**
     * 所属人
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     * 所属相册
     *
     * @mbg.generated
     */
    private Long albmId;

    /**
     * 系统配置
     *
     * @mbg.generated
     */
    private Long configId;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAlbmId() {
        return albmId;
    }

    public void setAlbmId(Long albmId) {
        this.albmId = albmId;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", path=").append(path);
        sb.append(", ext=").append(ext);
        sb.append(", size=").append(size);
        sb.append(", height=").append(height);
        sb.append(", width=").append(width);
        sb.append(", info=").append(info);
        sb.append(", userId=").append(userId);
        sb.append(", albmId=").append(albmId);
        sb.append(", configId=").append(configId);
        sb.append(", createTime=").append(createTime);
        sb.append(", deleteStatus=").append(deleteStatus);
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
        ShopAccessory other = (ShopAccessory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPath() == null ? other.getPath() == null : this.getPath().equals(other.getPath()))
            && (this.getExt() == null ? other.getExt() == null : this.getExt().equals(other.getExt()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth()))
            && (this.getInfo() == null ? other.getInfo() == null : this.getInfo().equals(other.getInfo()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAlbmId() == null ? other.getAlbmId() == null : this.getAlbmId().equals(other.getAlbmId()))
            && (this.getConfigId() == null ? other.getConfigId() == null : this.getConfigId().equals(other.getConfigId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDeleteStatus() == null ? other.getDeleteStatus() == null : this.getDeleteStatus().equals(other.getDeleteStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPath() == null) ? 0 : getPath().hashCode());
        result = prime * result + ((getExt() == null) ? 0 : getExt().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getWidth() == null) ? 0 : getWidth().hashCode());
        result = prime * result + ((getInfo() == null) ? 0 : getInfo().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAlbmId() == null) ? 0 : getAlbmId().hashCode());
        result = prime * result + ((getConfigId() == null) ? 0 : getConfigId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDeleteStatus() == null) ? 0 : getDeleteStatus().hashCode());
        return result;
    }
}