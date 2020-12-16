package com.xwkj.cost.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class ContractAdjust {
    /**
     * 对应字段：id，  字段含义：主键
     */
    private Long id;

    /**
     * 对应字段：contract_id，  字段含义：合同主键
     */
    private Long contractId;

    /**
     * 对应字段：before_money，  字段含义：调整前金额
     */
    private BigDecimal beforeMoney;

    /**
     * 对应字段：money，  字段含义：调整金额
     */
    private BigDecimal money;

    /**
     * 对应字段：after_money，  字段含义：调整后金额
     */
    private BigDecimal afterMoney;

    /**
     * 对应字段：status，  字段含义：调整状态0减1加
     */
    private Integer status;

    /**
     * 对应字段：create_time，  字段含义：调整时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 对应字段：note，  字段含义：变动原因
     */
    private String note;

    public Long getId() {
        return id;
    }

    public ContractAdjust setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getContractId() {
        return contractId;
    }

    public ContractAdjust setContractId(Long contractId) {
        this.contractId = contractId;
        return this;
    }

    public BigDecimal getBeforeMoney() {
        return beforeMoney;
    }

    public ContractAdjust setBeforeMoney(BigDecimal beforeMoney) {
        this.beforeMoney = beforeMoney;
        return this;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public ContractAdjust setMoney(BigDecimal money) {
        this.money = money;
        return this;
    }

    public BigDecimal getAfterMoney() {
        return afterMoney;
    }

    public ContractAdjust setAfterMoney(BigDecimal afterMoney) {
        this.afterMoney = afterMoney;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ContractAdjust setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ContractAdjust setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getNote() {
        return note;
    }

    public ContractAdjust setNote(String note) {
        this.note = note == null ? null : note.trim();
        return this;
    }
}
