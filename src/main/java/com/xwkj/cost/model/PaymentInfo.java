package com.xwkj.cost.model;

public class PaymentInfo {
    private Long id;

    /**
     * 对应字段：contractId，  字段含义：合同主键
     */
    private Long contractId;

    /**
     * 对应字段：batch_num，  字段含义：批次号
     */
    private String batchNum;

    /**
     * 对应字段：proportion，  字段含义：比例
     */
    private Float proportion;

    /**
     * 对应字段：note，  字段含义：描述
     */
    private String note;

    /**
     * 对应字段：status，  字段含义：状态 0正常 1删除
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public PaymentInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getContractId() {
        return contractId;
    }

    public PaymentInfo setContractId(Long contractId) {
        this.contractId = contractId;
        return this;
    }

    public String getBatchNum() {
        return batchNum;
    }

    public PaymentInfo setBatchNum(String batchNum) {
        this.batchNum = batchNum == null ? null : batchNum.trim();
        return this;
    }

    public Float getProportion() {
        return proportion;
    }

    public PaymentInfo setProportion(Float proportion) {
        this.proportion = proportion;
        return this;
    }

    public String getNote() {
        return note;
    }

    public PaymentInfo setNote(String note) {
        this.note = note == null ? null : note.trim();
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public PaymentInfo setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
