package com.emed.shopping.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 周润斌
 * @Date: create in 上午 14:01 2018/1/18 0018
 * @Description:
 */
public class TreeResult {

    private Long id;

    private Long parentId;

    private String text;

    private Integer level;

    private List<TreeResult> nodes = new ArrayList<>();

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<TreeResult> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeResult> nodes) {
        this.nodes = nodes;
    }
}
