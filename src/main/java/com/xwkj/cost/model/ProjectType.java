package com.xwkj.cost.model;

public class ProjectType {
    private Long id;

    /**
     * 对应字段：name，  字段含义：合同类型
     */
    private String name;

    /**
     * 对应字段：status，  字段含义：状态 0正常 1删除
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public ProjectType setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProjectType setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ProjectType setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
