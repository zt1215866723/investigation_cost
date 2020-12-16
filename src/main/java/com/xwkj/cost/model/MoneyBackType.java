package com.xwkj.cost.model;

public class MoneyBackType {
    private Long id;

    /**
     * 对应字段：name，  字段含义：回款方式
     */
    private String name;

    /**
     * 对应字段：status，  字段含义：状态0 正常 1 删除
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public MoneyBackType setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MoneyBackType setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public MoneyBackType setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
