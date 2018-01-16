package com.emed.shopping.dao.model.admin;

import com.emed.shopping.base.BaseModel;

/**
 * @Author: 周润斌
 * @Date: create in 上午 13:37 2018/1/16 0016
 * @Description:
 */
public class ShopAccessory extends BaseModel{

    private String name;

    private String path;

    private String ext;

    private Integer size;

    private Integer height;

    private Integer width;

    private String info;

    private Long userId;

    private Long albmId;

    private Long configId;

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
}
