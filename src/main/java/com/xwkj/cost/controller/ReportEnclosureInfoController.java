package com.xwkj.cost.controller;

import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.ReportEnclosureInfo;
import com.xwkj.cost.service.ReportEnclosureInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportEnclosureInfoController
{
    private static final Logger log = LoggerFactory.getLogger(ReportEnclosureInfoController.class);
    @Autowired
    ReportEnclosureInfoService reportEnclosureInfoService;

    @GetMapping({"getReportEnclosureInfoById"})
    public ResponseResult getReportEnclosureInfoById(Long id)
    {
        ResponseResult responseResult = null;
        try
        {
            List<ReportEnclosureInfo> list = this.reportEnclosureInfoService.getReportEnclosureInfoById(id);
            log.info("查询报告附件信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), list, "查询报告附件信息成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("查询报告附件信息失败");
            responseResult = ResponseResult.failure("查询报告附件信息失败");
        }
        return responseResult;
    }
}
