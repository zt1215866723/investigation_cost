package com.xwkj.cost.vo;

import com.xwkj.cost.model.MoneyBackInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description:TODO 合同汇总返回Vo
 * @Author zt
 * @Version 1.0
 */
public class ContractSummaryVo {


	private Long contractId;
	/**
	 * 对应字段：contract_name，  字段含义：合同名称
	 */
	private String contractName;

	/**
	 * 对应字段：contract_num，  字段含义：合同编号
	 */
	private String contractNum;

	/**
	 * 对应字段：item_name，  字段含义：项目名称
	 */
	private String itemName;

	/**
	 * 对应字段：company，  字段含义：客户单位
	 */
	private String company;

	/**
	 * 对应字段：creat_time，  字段含义：创建时间
	 */
	private Date creatTime;

	/**
	 * 对应字段：contract_money，  字段含义：合同金额
	 */
	private BigDecimal contractMoney;

	/**
	 * 对应字段：conclusion，  字段含义：结论
	 */
	private String conclusion;

	//调整
	private String adjustment;
	//已收金额
	private BigDecimal moneySum;
	//开票未收
	private BigDecimal noOpenMoneySum;
	//未收金额
	private BigDecimal noMoneySum;

	private String managerName;

	private BigDecimal arriveMoney;
	private Long projectId;
	private String signingTime;

	//开票情况
	private List<ApplyInvoiceVo> applyList;
	//回款情况
	private List<MoneyBackInfo> moneyBackList;

	public BigDecimal getArriveMoney() {
		return arriveMoney;
	}

	public ContractSummaryVo setArriveMoney(BigDecimal arriveMoney) {
		this.arriveMoney = arriveMoney;
		return this;
	}

	public Long getProjectId() {
		return projectId;
	}

	public ContractSummaryVo setProjectId(Long projectId) {
		this.projectId = projectId;
		return this;
	}

	public String getSigningTime() {
		return signingTime;
	}

	public ContractSummaryVo setSigningTime(String signingTime) {
		this.signingTime = signingTime;
		return this;
	}

	public String getManagerName() {
		return managerName;
	}

	public ContractSummaryVo setManagerName(String managerName) {
		this.managerName = managerName;
		return this;
	}

	public Long getContractId() {
		return contractId;
	}

	public ContractSummaryVo setContractId(Long contractId) {
		this.contractId = contractId;
		return this;
	}

	public String getContractName() {
		return contractName;
	}

	public ContractSummaryVo setContractName(String contractName) {
		this.contractName = contractName;
		return this;
	}

	public String getContractNum() {
		return contractNum;
	}

	public ContractSummaryVo setContractNum(String contractNum) {
		this.contractNum = contractNum;
		return this;
	}

	public String getItemName() {
		return itemName;
	}

	public ContractSummaryVo setItemName(String itemName) {
		this.itemName = itemName;
		return this;
	}

	public String getCompany() {
		return company;
	}

	public ContractSummaryVo setCompany(String company) {
		this.company = company;
		return this;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public ContractSummaryVo setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
		return this;
	}

	public BigDecimal getContractMoney() {
		return contractMoney;
	}

	public ContractSummaryVo setContractMoney(BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
		return this;
	}

	public String getConclusion() {
		return conclusion;
	}

	public ContractSummaryVo setConclusion(String conclusion) {
		this.conclusion = conclusion;
		return this;
	}

	public String getAdjustment() {
		return adjustment;
	}

	public ContractSummaryVo setAdjustment(String adjustment) {
		this.adjustment = adjustment;
		return this;
	}

	public BigDecimal getMoneySum() {
		return moneySum;
	}

	public ContractSummaryVo setMoneySum(BigDecimal moneySum) {
		this.moneySum = moneySum;
		return this;
	}

	public BigDecimal getNoOpenMoneySum() {
		return noOpenMoneySum;
	}

	public ContractSummaryVo setNoOpenMoneySum(BigDecimal noOpenMoneySum) {
		this.noOpenMoneySum = noOpenMoneySum;
		return this;
	}

	public BigDecimal getNoMoneySum() {
		return noMoneySum;
	}

	public ContractSummaryVo setNoMoneySum(BigDecimal noMoneySum) {
		this.noMoneySum = noMoneySum;
		return this;
	}

	public List<ApplyInvoiceVo> getApplyList() {
		return applyList;
	}

	public ContractSummaryVo setApplyList(List<ApplyInvoiceVo> applyList) {
		this.applyList = applyList;
		return this;
	}

	public List<MoneyBackInfo> getMoneyBackList() {
		return moneyBackList;
	}

	public ContractSummaryVo setMoneyBackList(List<MoneyBackInfo> moneyBackList) {
		this.moneyBackList = moneyBackList;
		return this;
	}
}
