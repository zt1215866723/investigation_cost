package com.xwkj.cost.mapper;

import com.xwkj.cost.model.ReportInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportInfoMapperManual
{
    List<ReportInfo> getReportInfoList(ReportInfo paramReportInfo);
}
