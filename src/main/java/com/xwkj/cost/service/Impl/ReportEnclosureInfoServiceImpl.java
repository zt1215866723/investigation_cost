package com.xwkj.cost.service.Impl;

import com.xwkj.cost.mapper.ReportEnclosureInfoMapperManual;
import com.xwkj.cost.model.ReportEnclosureInfo;
import com.xwkj.cost.service.ReportEnclosureInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportEnclosureInfoServiceImpl
        implements ReportEnclosureInfoService
{
    @Autowired(required=false)
    ReportEnclosureInfoMapperManual reportEnclosureInfoMapperManual;

    public List<ReportEnclosureInfo> getReportEnclosureInfoById(Long id)
    {
        return this.reportEnclosureInfoMapperManual.selectReportEnclosureInfoById(id);
    }
}
