package com.xwkj.cost.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:TODO 合同包含回款信息
 * @Author wanglei
 * @Create 2019-12-11 14:35
 * @Version 1.0
 */
public class ContractInfoAndInvoiceInfoVo {
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
	 * 对应字段：signing_time，  字段含义：签约年份
	 */
	private String signingTime;

	/**
	 * 对应字段：type，  字段含义：类型
	 */
	private Integer type;

	//类型名
	private String typeName;

	//已开票金额
	private BigDecimal openMoneySum;
	//已收金额
	private BigDecimal moneySum;
	//开票未收
	private BigDecimal noOpenMoneySum;
	//未收金额
	private BigDecimal noMoneySum;
	//开票已收金额
	private BigDecimal yesOpenMoneySum;
	//未开票未收金额
	private BigDecimal noOpenNoMoneySum;
	//开票时间
	private String openTime;
	//签约状态 0是 1否
	private Integer signingStatus;

	//是否存档 0是 1否
	private Integer isArchive;

	private String managerName;
	private Long projectId;
	private String projectName;
	private Integer hasInvoice;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;

	public String getManagerName() {
		return managerName;
	}

	public ContractInfoAndInvoiceInfoVo setManagerName(String managerName) {
		this.managerName = managerName;
		return this;
	}

	public Long getProjectId() {
		return projectId;
	}

	public ContractInfoAndInvoiceInfoVo setProjectId(Long projectId) {
		this.projectId = projectId;
		return this;
	}

	public String getProjectName() {
		return projectName;
	}

	public ContractInfoAndInvoiceInfoVo setProjectName(String projectName) {
		this.projectName = projectName;
		return this;
	}

	public Integer getHasInvoice() {
		return hasInvoice;
	}

	public ContractInfoAndInvoiceInfoVo setHasInvoice(Integer hasInvoice) {
		this.hasInvoice = hasInvoice;
		return this;
	}

	public Date getStartTime() {
		return startTime;
	}

	public ContractInfoAndInvoiceInfoVo setStartTime(Date startTime) {
		this.startTime = startTime;
		return this;
	}

	public Date getEndTime() {
		return endTime;
	}

	public ContractInfoAndInvoiceInfoVo setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}

	public Integer getSigningStatus() {
		return signingStatus;
	}

	public ContractInfoAndInvoiceInfoVo setSigningStatus(Integer signingStatus) {
		this.signingStatus = signingStatus;
		return this;
	}

	public Integer getIsArchive() {
		return isArchive;
	}

	public ContractInfoAndInvoiceInfoVo setIsArchive(Integer isArchive) {
		this.isArchive = isArchive;
		return this;
	}

	public BigDecimal getNoOpenNoMoneySum() {
		return noOpenNoMoneySum;
	}

	public ContractInfoAndInvoiceInfoVo setNoOpenNoMoneySum(BigDecimal noOpenNoMoneySum) {
		this.noOpenNoMoneySum = noOpenNoMoneySum;
		return this;
	}

	public Long getId() {
		return id;
	}

	public ContractInfoAndInvoiceInfoVo setId(Long id) {
		this.id = id;
		return this;
	}

	public String getContractName() {
		return contractName;
	}

	public ContractInfoAndInvoiceInfoVo setContractName(String contractName) {
		this.contractName = contractName == null ? null : contractName.trim();
		return this;
	}

	public String getContractNum() {
		return contractNum;
	}

	public ContractInfoAndInvoiceInfoVo setContractNum(String contractNum) {
		this.contractNum = contractNum == null ? null : contractNum.trim();
		return this;
	}

	public String getItemName() {
		return itemName;
	}

	public ContractInfoAndInvoiceInfoVo setItemName(String itemName) {
		this.itemName = itemName == null ? null : itemName.trim();
		return this;
	}

	public String getCustomer() {
		return customer;
	}

	public ContractInfoAndInvoiceInfoVo setCustomer(String customer) {
		this.customer = customer == null ? null : customer.trim();
		return this;
	}

	public String getCompany() {
		return company;
	}

	public ContractInfoAndInvoiceInfoVo setCompany(String company) {
		this.company = company == null ? null : company.trim();
		return this;
	}

	public String getCustomerTel() {
		return customerTel;
	}

	public ContractInfoAndInvoiceInfoVo setCustomerTel(String customerTel) {
		this.customerTel = customerTel == null ? null : customerTel.trim();
		return this;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public ContractInfoAndInvoiceInfoVo setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
		return this;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public ContractInfoAndInvoiceInfoVo setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
		return this;
	}

	public Long getCreator() {
		return creator;
	}

	public ContractInfoAndInvoiceInfoVo setCreator(Long creator) {
		this.creator = creator;
		return this;
	}

	public Long getLastModifier() {
		return lastModifier;
	}

	public ContractInfoAndInvoiceInfoVo setLastModifier(Long lastModifier) {
		this.lastModifier = lastModifier;
		return this;
	}

	public BigDecimal getContractCost() {
		return contractCost;
	}

	public ContractInfoAndInvoiceInfoVo setContractCost(BigDecimal contractCost) {
		this.contractCost = contractCost;
		return this;
	}

	public BigDecimal getContractMoney() {
		return contractMoney;
	}

	public ContractInfoAndInvoiceInfoVo setContractMoney(BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
		return this;
	}

	public String getSpecialInstructions() {
		return specialInstructions;
	}

	public ContractInfoAndInvoiceInfoVo setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions == null ? null : specialInstructions.trim();
		return this;
	}

	public String getPremium() {
		return premium;
	}

	public ContractInfoAndInvoiceInfoVo setPremium(String premium) {
		this.premium = premium == null ? null : premium.trim();
		return this;
	}

	public String getConclusion() {
		return conclusion;
	}

	public ContractInfoAndInvoiceInfoVo setConclusion(String conclusion) {
		this.conclusion = conclusion == null ? null : conclusion.trim();
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public ContractInfoAndInvoiceInfoVo setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public BigDecimal getMoneySum() {
		return moneySum;
	}

	public void setMoneySum(BigDecimal moneySum) {
		this.moneySum = moneySum;
	}

	public String getItemManager() {
		return itemManager;
	}

	public ContractInfoAndInvoiceInfoVo setItemManager(String itemManager) {
		this.itemManager = itemManager == null ? null : itemManager.trim();
		return this;
	}

	public BigDecimal getOpenMoneySum() {
		return openMoneySum;
	}

	public ContractInfoAndInvoiceInfoVo setOpenMoneySum(BigDecimal openMoneySum) {
		this.openMoneySum = openMoneySum;
		return this;
	}

	public BigDecimal getNoOpenMoneySum() {
		return noOpenMoneySum;
	}

	public ContractInfoAndInvoiceInfoVo setNoOpenMoneySum(BigDecimal noOpenMoneySum) {
		this.noOpenMoneySum = noOpenMoneySum;
		return this;
	}

	public BigDecimal getNoMoneySum() {
		return noMoneySum;
	}

	public ContractInfoAndInvoiceInfoVo setNoMoneySum(BigDecimal noMoneySum) {
		this.noMoneySum = noMoneySum;
		return this;
	}

	public String getSigningTime() {
		return signingTime;
	}

	public ContractInfoAndInvoiceInfoVo setSigningTime(String signingTime) {
		this.signingTime = signingTime;
		return this;
	}

	public Integer getType() {
		return type;
	}

	public ContractInfoAndInvoiceInfoVo setType(Integer type) {
		this.type = type;
		return this;
	}

	public String getTypeName() {
		return typeName;
	}

	public ContractInfoAndInvoiceInfoVo setTypeName(String typeName) {
		this.typeName = typeName;
		return this;
	}

	public String getOpenTime() {
		return openTime;
	}

	public ContractInfoAndInvoiceInfoVo setOpenTime(String openTime) {
		this.openTime = openTime;
		return this;
	}

	public BigDecimal getYesOpenMoneySum() {
		return yesOpenMoneySum;
	}

	public ContractInfoAndInvoiceInfoVo setYesOpenMoneySum(BigDecimal yesOpenMoneySum) {
		this.yesOpenMoneySum = yesOpenMoneySum;
		return this;
	}
}
