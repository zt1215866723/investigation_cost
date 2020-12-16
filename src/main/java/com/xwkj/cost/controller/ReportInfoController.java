package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.ReportInfo;
import com.xwkj.cost.service.ReportInfoService;
import com.xwkj.cost.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportInfoController
{
    private static final Logger log = LoggerFactory.getLogger(ReportInfoController.class);
    @Autowired
    ReportInfoService reportInfoService;

    @GetMapping({"/getReportInfoList"})
    public ResponseResult getReportInfoList(PageUtil pageUtil, ReportInfo reportInfo)
    {
        ResponseResult responseResult = null;
        try
        {
            PageInfo<ReportInfo> pageInfo = this.reportInfoService.getReportInfoList(pageUtil, reportInfo);
            log.info("获取报告信息列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), pageInfo, "获取报告信息列表成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("获取报告信息列表失败");
            responseResult = ResponseResult.failure("获取报告信息列表失败");
        }
        return responseResult;
    }

    @PostMapping({"/addReportInfo"})
    public ResponseResult addReportInfo(ReportInfo reportInfo)
    {
        ResponseResult responseResult = null;
        try
        {
            Boolean b = this.reportInfoService.addReportInfo(reportInfo);
            if (b.booleanValue())
            {
                log.info("添加报告信息成功");
                responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), null, "添加报告信息成功");
            }
            else
            {
                log.error("添加报告信息失败，报告名重复");
                responseResult = ResponseResult.failure("添加报告信息失败，报告名重复");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("添加报告信息失败");
            responseResult = ResponseResult.failure("添加报告信息失败");
        }
        return responseResult;
    }

    @PutMapping({"/updateReportInfo"})
    public ResponseResult updateReportInfo(ReportInfo reportInfo)
    {
        ResponseResult responseResult = null;
        try
        {
            this.reportInfoService.updateReportInfo(reportInfo);
            log.info("修改报告信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), null, "修改报告信息成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("修改报告信息失败");
            responseResult = ResponseResult.failure("修改报告信息失败");
        }
        return responseResult;
    }

    @DeleteMapping({"/deleteReportInfo"})
    public ResponseResult deleteReportInfo(Long id)
    {
        ResponseResult responseResult = null;
        try
        {
            this.reportInfoService.deleteReportInfo(id);
            log.info("删除报告信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), null, "删除报告信息成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("删除报告信息失败");
            responseResult = ResponseResult.failure("删除报告信息失败");
        }
        return responseResult;
    }

    @GetMapping({"/getReportInfoById"})
    public ResponseResult getReportInfoById(Long id)
    {
        ResponseResult responseResult = null;
        try
        {
            ReportInfo reportInfo = this.reportInfoService.getReportInfo(id);
            log.info("根据报告主键获取报告信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), reportInfo, "根据报告主键获取报告信息成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("根据报告主键获取报告信息失败");
            responseResult = ResponseResult.failure("根据报告主键获取报告信息失败");
        }
        return responseResult;
    }
}
