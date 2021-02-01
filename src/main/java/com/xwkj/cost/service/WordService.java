package com.xwkj.cost.service;

import com.xwkj.cost.vo.SelectContractInfoVo;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description:TODO 生成word业务
 * @Author wanglei
 * @Create 2019-12-13 9:11
 * @Version 1.0
 */
public interface WordService {

	/**
	 * @description: 打印合同成本报表接口
	 * @methodName: printfContractWord
	 * @param: [contractIds, response]
	 * @return: void
	 * @exception:
	 * @date:  2019-12-13 21:58
	 * @author: wanglei
	 */
	void printfContractWord(String[] contractId,Integer type , HttpServletResponse response);

    void invoiceStatisticsExcel(SelectContractInfoVo selectContractInfoVo, HttpServletResponse response);

    /**
     * @Description  ：打印合同汇总报表接口
     * @methodName   : printfContractSummary
     * @param        : * @param contractId :
     * @param response :
     * @return       : void
     * @exception    :
     * @author       : 张童
     */

	void printfContractSummary(String[] contractId, HttpServletResponse response);

    void moneyBackStatisticsExcel(SelectContractInfoVo selectContractInfoVo, HttpServletResponse response);

    void printfYearSummary(String timeLimit, HttpServletResponse response);
}
