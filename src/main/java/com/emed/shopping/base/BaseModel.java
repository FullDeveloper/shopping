package com.emed.shopping.base;

import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @Author: 周润斌
 * @Date: create in 上午 17:48 2018/1/15 0015
 * @Description:
 */
public class BaseModel {

    @Id
    private Long id;

    private Timestamp createTime;

    private String deleteStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}
