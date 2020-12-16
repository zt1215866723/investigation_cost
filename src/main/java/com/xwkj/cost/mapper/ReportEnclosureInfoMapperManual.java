package com.xwkj.cost.mapper;

import com.xwkj.cost.model.ReportEnclosureInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportEnclosureInfoMapperManual
{
    List<ReportEnclosureInfo> selectReportEnclosureInfoById(Long paramLong);
}
