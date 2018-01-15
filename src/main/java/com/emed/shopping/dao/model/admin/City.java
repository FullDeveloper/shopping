package com.emed.shopping.dao.model.admin;

import javax.persistence.Id;

/**
 * @Author: 周润斌
 * @Date: create in 上午 16:47 2018/1/15 0015
 * @Description:
 */
public class City {
    @Id
    private String id;
    private String name;
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
