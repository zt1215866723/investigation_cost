package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.ApplyInvoiceInfo;
import com.xwkj.cost.service.ApplyInvoiceInfoService;
import com.xwkj.cost.service.WordService;
import com.xwkj.cost.util.PageUtil;
import com.xwkj.cost.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description:TODO
 * @Author wanglei
 * @Create 2020-01-11 11:36
 * @Version 1.0
 */
@RestController
@Slf4j
public class ApplyInvoiceInfoController {

	@Autowired
	ApplyInvoiceInfoService applyInvoiceInfoService;
	@Autowired
	WordService wordService;
	/**
	 * @description: 添加申请开票信息接口
	 * @methodName: addApplyInvoiceInfo
	 * @param: [applyInvoiceVo]
	 * @return: com.xwkj.cost.common.ResponseResult
	 * @exception:
	 * @date:  2020-01-11 14:07
	 * @author: wanglei
	 */
	@PostMapping("addApplyInvoiceInfo")
	public ResponseResult addApplyInvoiceInfo(ApplyInvoiceVo applyInvoiceVo){
		try{
			Boolean flag = applyInvoiceInfoService.addApplyInvoiceInfo(applyInvoiceVo);
			if (flag){
				log.info("添加申请开票信息成功！");
				return ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"添加申请开票信息成功！");
			}else{
				log.info("开票申请附件上传失败！");
				return ResponseResult.failure(ResponseResultEnum.FAILURE.getCode(),"开票申请附件上传失败！");
			}
		}catch (Exception e){
			log.error("添加申请开票信息失败！");
			e.printStackTrace();
			return ResponseResult.failure(ResponseResultEnum.FAILURE.getCode(),"添加申请开票信息失败！");
		}
	}

	/**
	 * @description: 修改申请开票信息
	 * @methodName: editApplyInvoiceInfo
	 * @param: [applyInvoiceInfo]
	 * @return: com.xwkj.cost.common.ResponseResult
	 * @exception:
	 * @date:  2020-01-13 9:33
	 * @author: wanglei
	 */
	@PostMapping("editApplyInvoiceInfo")
	public ResponseResult editApplyInvoiceInfo(ApplyInvoiceInfo applyInvoiceInfo){
		try{
			Boolean flag = applyInvoiceInfoService.editApplyInvoiceInfo(applyInvoiceInfo);
			if (flag) {
				log.info("修改申请开票信息成功！");
				return ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改申请开票信息成功！");
			}else{
				log.info("修改申请开票信息失败！");
				return ResponseResult.failure("修改开票申请生效的回款信息失败！");
			}
		}catch (Exception e){
			log.error("修改申请开票信息失败！");
			e.printStackTrace();
			return ResponseResult.failure(ResponseResultEnum.FAILURE.getCode(),"修改申请开票信息失败！");
		}
	}

	@PostMapping("getApplyInvoiceInfo")
	public ResponseResult getApplyInvoiceInfo(ApplyInvoiceInfo applyInvoiceInfo){
		try{
			List<ApplyInvoiceInfo> list = applyInvoiceInfoService.getApplyInvoiceInfo(applyInvoiceInfo);
			log.info("查询申请开票信息成功！");
			return ResponseResult.success(ResponseResultEnum.FAILURE.getCode(),list,"查询申请开票信息成功！");
		}catch (Exception e){
			log.error("查询申请开票信息失败！");
			e.printStackTrace();
			return ResponseResult.failure(ResponseResultEnum.FAILURE.getCode(),"查询申请开票信息失败！");
		}
	}

	/**
	 * @description: 分页查询申请发票信息
	 * @methodName: getApplyInvoiceInfoList
	 * @param: [pageUtil, id]
	 * @return: com.xwkj.cost.common.ResponseResult
	 * @exception:
	 * @date:  2020-01-11 16:38
	 * @author: wanglei
	 */
	@PostMapping("getApplyInvoiceInfoList")
	public ResponseResult getApplyInvoiceInfoList(PageUtil pageUtil, Long id) {
		ResponseResult responseResult = null;
		try {
			PageInfo<ApplyInvoiceInfo> page = applyInvoiceInfoService.getApplyInvoiceInfoList(pageUtil,id);
			log.info("分页查询申请发票信息成功！");
			responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),page,"分页查询申请发票信息成功！");
		}catch (Exception e) {
			e.printStackTrace();
			log.error("分页查询申请发票信息失败！");
			responseResult = ResponseResult.failure("分页查询申请发票信息失败！");
		}
		return responseResult;
	}

	/**
	 * @description: 删除申请发票信息
	 * @methodName: deleteApplyInvoiceInfo
	 * @param: [id]
	 * @return: com.xwkj.cost.common.ResponseResult
	 * @exception:
	 * @date:  2020-01-11 17:39
	 * @author: wanglei
	 */
	@DeleteMapping("/deleteApplyInvoiceInfo/{id}")
	public ResponseResult deleteApplyInvoiceInfo(@PathVariable Long id) {
		ResponseResult responseResult = null;
		try {
			Boolean flag = applyInvoiceInfoService.deleteApplyInvoiceInfo(id);
			if (flag){
				log.info("删除申请发票信息成功");
				responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除申请发票信息成功");
			}else{
				log.info("删除申请发票信息失败");
				responseResult = ResponseResult.failure("申请以生效，删除失败!");
			}
		} catch(Exception e){
			e.printStackTrace();
			log.error("删除申请发票信息失败");
			responseResult = ResponseResult.failure("删除申请发票信息失败");
		}
		return responseResult;
	}

	/**
	 * @description: 查询发票统计
	 * @methodName: getContractInfo
	 * @param: [pageUtil, selectContractInfoVo]
	 * @return: com.xwkj.cost.common.ResponseResult
	 * @exception:
	 * @date:  2019-12-11 15:05
	 * @author: wanglei
	 */
	@PostMapping("getInvoiceStatistics")
	public ResponseResult getInvoiceStatistics(PageUtil pageUtil, SelectContractInfoVo selectContractInfoVo) {
		ResponseResult responseResult = null;
		try {
			PageInfo<InvoiceStatisticsVo> page = applyInvoiceInfoService.getInvoiceStatistics(pageUtil,selectContractInfoVo);
			log.info("查询合同信息成功！");
			responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),page,"查询合同信息成功！");
		}catch (Exception e) {
			e.printStackTrace();
			log.error("查询合同信息失败！");
			responseResult = ResponseResult.failure("查询合同信息失败！");
		}
		return responseResult;
	}

	/***
	 * @description: 打印发票统计
	 * @methodName: printfContractWord
	 * @param: [contractIds, response]
	 * @return: com.xwkj.cost.common.ResponseResult
	 * @exception:
	 * @date:  2019-12-13 21:58
	 * @author: wanglei
	 */
	@GetMapping("invoiceStatisticsExcel")
	public ResponseResult invoiceStatisticsExcel(SelectContractInfoVo selectContractInfoVo, HttpServletResponse response) {
		ResponseResult responseResult = null;
		try {
			wordService.invoiceStatisticsExcel(selectContractInfoVo,response);
			log.info("打印发票统计成功！");
			responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"打印发票统计成功！");
		}catch (Exception e) {
			e.printStackTrace();
			log.error("打印发票统计失败！");
			responseResult = ResponseResult.failure("打印发票统计失败！");
		}
		return responseResult;
	}
}
