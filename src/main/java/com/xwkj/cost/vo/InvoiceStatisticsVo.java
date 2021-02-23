package com.xwkj.cost.vo;

import java.math.BigDecimal;

/**
 * @ClassName:MoneyBackVo
 * @Description:
 * @Author:张童
 * @Date:
 **/
public class InvoiceStatisticsVo {

    //开票金额
    private BigDecimal applyMoney;
    //回款金额
    private BigDecimal backMoney;
    //年份
    private String signingTime;
    //开票时间
    private String applyTime;
    //单位名称
    private String company;
    //项目名称
    private String itemName;
    //业务员
    private String itemManager;

    private String managerName;

    //回款时间
    private String arrivalTime;

    //凭证号
    private String applyName;
    //备注
    private String invaiceRemark;

    private String certificateNumber;

    public String getManagerName() {
        return managerName;
    }

    public InvoiceStatisticsVo setManagerName(String managerName) {
        this.managerName = managerName;
        return this;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public InvoiceStatisticsVo setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
        return this;
    }

    public BigDecimal getApplyMoney() {
        return applyMoney;
    }

    public InvoiceStatisticsVo setApplyMoney(BigDecimal applyMoney) {
        this.applyMoney = applyMoney;
        return this;
    }

    public BigDecimal getBackMoney() {
        return backMoney;
    }

    public InvoiceStatisticsVo setBackMoney(BigDecimal backMoney) {
        this.backMoney = backMoney;
        return this;
    }

    public String getSigningTime() {
        return signingTime;
    }

    public InvoiceStatisticsVo setSigningTime(String signingTime) {
        this.signingTime = signingTime;
        return this;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public InvoiceStatisticsVo setApplyTime(String applyTime) {
        this.applyTime = applyTime;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public InvoiceStatisticsVo setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public String getItemManager() {
        return itemManager;
    }

    public InvoiceStatisticsVo setItemManager(String itemManager) {
        this.itemManager = itemManager;
        return this;
    }

    public String getApplyName() {
        return applyName;
    }

    public InvoiceStatisticsVo setApplyName(String applyName) {
        this.applyName = applyName;
        return this;
    }

    public String getInvaiceRemark() {
        return invaiceRemark;
    }

    public InvoiceStatisticsVo setInvaiceRemark(String invaiceRemark) {
        this.invaiceRemark = invaiceRemark;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public InvoiceStatisticsVo setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public InvoiceStatisticsVo setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }
}
