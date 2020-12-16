package com.xwkj.cost.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xwkj.cost.model.ContractInfo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:TODO 合同包含附件路径
 * @Author wanglei
 * @Create 2019-12-11 9:39
 * @Version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContractInfoVo {
	/**
	 * 对应字段：id，  字段含义：合同主键
	 */
	private Long id;

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
	 * 对应字段：item_manager，  字段含义：项目经理
	 */
	private String itemManager;

	/**
	 * 对应字段：customer，  字段含义：客户姓名
	 */
	private String customer;

	/**
	 * 对应字段：company，  字段含义：客户单位
	 */
	private String company;

	/**
	 * 对应字段：customer_tel，  字段含义：客户电话
	 */
	private String customerTel;

	/**
	 * 对应字段：creat_time，  字段含义：创建时间
	 */
	private Date creatTime;

	/**
	 * 对应字段：last_modified_time，  字段含义：最后修改时间
	 */
	private Date lastModifiedTime;

	/**
	 * 对应字段：creator，  字段含义：创建人
	 */
	private Long creator;

	/**
	 * 对应字段：last_modifier，  字段含义：最后修改人
	 */
	private Long lastModifier;

	/**
	 * 对应字段：contract_cost，  字段含义：合同总成本
	 */
	private BigDecimal contractCost;

	/**
	 * 对应字段：contract_money，  字段含义：合同金额
	 */
	private BigDecimal contractMoney;

	/**
	 * 对应字段：special_instructions，  字段含义：特殊说明
	 */
	private String specialInstructions;

	/**
	 * 对应字段：premium，  字段含义：质保金说明
	 */
	private String premium;

	/**
	 * 对应字段：conclusion，  字段含义：结论
	 */
	private String conclusion;

	/**
	 * 对应字段：status，  字段含义：状态  1：未完成  2：已完成  0：已删除
	 */
	private Integer status;

	/**
	 * 多文件上传路径
	 */
	private String fileUploads;

	/**
	 * 对应字段：signing_time，  字段含义：签约年份
	 */
	private String signingTime;

	/**
	 * 对应字段：type，  字段含义：类型
	 */
	private String type;

	//签约状态 0是 1否
	private Integer signingStatus;

	//是否存档 0是 1否
	private Integer isArchive;

	public Integer getSigningStatus() {
		return signingStatus;
	}

	public ContractInfoVo setSigningStatus(Integer signingStatus) {
		this.signingStatus = signingStatus;
		return this;
	}

	public Integer getIsArchive() {
		return isArchive;
	}

	public ContractInfoVo setIsArchive(Integer isArchive) {
		this.isArchive = isArchive;
		return this;
	}

	public Long getId() {
		return id;
	}

	public ContractInfoVo setId(Long id) {
		this.id = id;
		return this;
	}

	public String getContractName() {
		return contractName;
	}

	public ContractInfoVo setContractName(String contractName) {
		this.contractName = contractName == null ? null : contractName.trim();
		return this;
	}

	public String getContractNum() {
		return contractNum;
	}

	public ContractInfoVo setContractNum(String contractNum) {
		this.contractNum = contractNum == null ? null : contractNum.trim();
		return this;
	}

	public String getItemName() {
		return itemName;
	}

	public ContractInfoVo setItemName(String itemName) {
		this.itemName = itemName == null ? null : itemName.trim();
		return this;
	}

	public String getCustomer() {
		return customer;
	}

	public ContractInfoVo setCustomer(String customer) {
		this.customer = customer == null ? null : customer.trim();
		return this;
	}

	public String getCompany() {
		return company;
	}

	public ContractInfoVo setCompany(String company) {
		this.company = company == null ? null : company.trim();
		return this;
	}

	public String getCustomerTel() {
		return customerTel;
	}

	public ContractInfoVo setCustomerTel(String customerTel) {
		this.customerTel = customerTel == null ? null : customerTel.trim();
		return this;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public ContractInfoVo setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
		return this;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public ContractInfoVo setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
		return this;
	}

	public Long getCreator() {
		return creator;
	}

	public ContractInfoVo setCreator(Long creator) {
		this.creator = creator;
		return this;
	}

	public Long getLastModifier() {
		return lastModifier;
	}

	public ContractInfoVo setLastModifier(Long lastModifier) {
		this.lastModifier = lastModifier;
		return this;
	}

	public BigDecimal getContractCost() {
		return contractCost;
	}

	public ContractInfoVo setContractCost(BigDecimal contractCost) {
		this.contractCost = contractCost;
		return this;
	}

	public BigDecimal getContractMoney() {
		return contractMoney;
	}

	public ContractInfoVo setContractMoney(BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
		return this;
	}

	public String getSpecialInstructions() {
		return specialInstructions;
	}

	public ContractInfoVo setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions == null ? null : specialInstructions.trim();
		return this;
	}

	public String getPremium() {
		return premium;
	}

	public ContractInfoVo setPremium(String premium) {
		this.premium = premium == null ? null : premium.trim();
		return this;
	}

	public String getConclusion() {
		return conclusion;
	}

	public ContractInfoVo setConclusion(String conclusion) {
		this.conclusion = conclusion == null ? null : conclusion.trim();
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public ContractInfoVo setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public String getFileUploads() {
		return fileUploads;
	}

	public ContractInfoVo setFileUploads(String fileUploads) {
		this.fileUploads = fileUploads == null ? null : fileUploads.trim();
		return this;
	}

	public String getItemManager() {
		return itemManager;
	}

	public ContractInfoVo setItemManager(String itemManager) {
		this.itemManager = itemManager == null ? null : itemManager.trim();
		return this;
	}

	public String getSigningTime() {
		return signingTime;
	}

	public ContractInfoVo setSigningTime(String signingTime) {
		this.signingTime = signingTime;
		return this;
	}

	public String getType() {
		return type;
	}

	public ContractInfoVo setType(String type) {
		this.type = type;
		return this;
	}
}
