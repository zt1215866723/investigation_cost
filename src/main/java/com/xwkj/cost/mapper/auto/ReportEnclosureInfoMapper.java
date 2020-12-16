package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.ReportEnclosureInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportEnclosureInfoMapper
{
    int deleteByPrimaryKey(Long paramLong);

    int insert(ReportEnclosureInfo paramReportEnclosureInfo);

    int insertSelective(ReportEnclosureInfo paramReportEnclosureInfo);

    ReportEnclosureInfo selectByPrimaryKey(Long paramLong);

    int updateByPrimaryKeySelective(ReportEnclosureInfo paramReportEnclosureInfo);

    int updateByPrimaryKey(ReportEnclosureInfo paramReportEnclosureInfo);
}
