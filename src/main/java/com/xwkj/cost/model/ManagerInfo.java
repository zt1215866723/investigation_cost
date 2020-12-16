package com.xwkj.cost.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ManagerInfo {
    /**
     * 对应字段：id，  字段含义：业务员Id
     */
    private Long id;

    /**
     * 对应字段：name，  字段含义：业务员姓名
     */
    private String name;

    /**
     * 对应字段：phone，  字段含义：手机号
     */
    private Integer phone;

    /**
     * 对应字段：idCard，  字段含义：身份证号
     */
    private String idCard;

    /**
     * 对应字段：status，  字段含义：状态 1 正常 0删除
     */
    private Integer status;

    /**
     * 对应字段：gender，  字段含义：性别 0男 1女
     */
    private Integer gender;

    /**
     * 对应字段：birth_time，  字段含义：出生日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthTime;

    /**
     * 对应字段：create_time，  字段含义：创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public ManagerInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ManagerInfo setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public Integer getPhone() {
        return phone;
    }

    public ManagerInfo setPhone(Integer phone) {
        this.phone = phone;
        return this;
    }

    public String getIdCard() {
        return idCard;
    }

    public ManagerInfo setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ManagerInfo setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public ManagerInfo setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    public Date getBirthTime() {
        return birthTime;
    }

    public ManagerInfo setBirthTime(Date birthTime) {
        this.birthTime = birthTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ManagerInfo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}
