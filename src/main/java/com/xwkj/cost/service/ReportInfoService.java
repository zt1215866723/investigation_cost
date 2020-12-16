package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.ReportInfo;
import com.xwkj.cost.util.PageUtil;

public interface ReportInfoService
{
    PageInfo<ReportInfo> getReportInfoList(PageUtil paramPageUtil, ReportInfo paramReportInfo);

    Boolean addReportInfo(ReportInfo paramReportInfo);

    void updateReportInfo(ReportInfo paramReportInfo);

    void deleteReportInfo(Long paramLong);

    ReportInfo getReportInfo(Long paramLong);
}
