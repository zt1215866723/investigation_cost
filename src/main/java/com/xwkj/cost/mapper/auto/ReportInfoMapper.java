package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.ReportInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportInfoMapper
{
    int deleteByPrimaryKey(Long paramLong);

    int insert(ReportInfo paramReportInfo);

    int insertSelective(ReportInfo paramReportInfo);

    ReportInfo selectByPrimaryKey(Long paramLong);

    int updateByPrimaryKeySelective(ReportInfo paramReportInfo);

    int updateByPrimaryKey(ReportInfo paramReportInfo);
}
