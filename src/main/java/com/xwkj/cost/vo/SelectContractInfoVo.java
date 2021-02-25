package com.xwkj.cost.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:TODO 合同查询VO
 * @Author wanglei
 * @Create 2019-12-11 16:09
 * @Version 1.0
 */
@Data
public class SelectContractInfoVo {

	/**
	 * 对应字段：contract_num，  字段含义：合同编号
	 */
	private String contractNum;

	/**
	 * 对应字段：item_name，  字段含义：项目名称
	 */
	private String itemName;

	/**
	 * 开始时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start;

	/**
	 * 截止时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date end;

	/**
	 * 状态
	 */
	private Integer status;

	//业务员
	private String itemManager;

	private Integer contractType;

	//业务员Id
	private Long managerId;

	//年份
	private String signingTime;

	private Long projectId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endTime;
	private Integer signingStatus;
	private Integer isArchive;
	private BigDecimal applyMoney;

	private String timeLimit;

	private String endT;
	private String startT;
}
