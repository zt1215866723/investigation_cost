package com.xwkj.cost.model;

public class ContractType {
    private Long id;

    /**
     * 对应字段：name，  字段含义：名称
     */
    private String name;

    /**
     * 对应字段：status，  字段含义：0删除 1正常
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public ContractType setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ContractType setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ContractType setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
