package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.mapper.ReportInfoMapperManual;
import com.xwkj.cost.mapper.auto.ReportEnclosureInfoMapper;
import com.xwkj.cost.mapper.auto.ReportInfoMapper;
import com.xwkj.cost.model.ReportEnclosureInfo;
import com.xwkj.cost.model.ReportInfo;
import com.xwkj.cost.service.ReportInfoService;
import com.xwkj.cost.util.PageUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ReportInfoServiceImpl
        implements ReportInfoService
{
    @Autowired
    ReportInfoMapper reportInfoMapper;
    @Autowired
    ReportInfoMapperManual reportInfoMapperManual;
    @Autowired
    ReportEnclosureInfoMapper reportEnclosureInfoMapper;

    public PageInfo<ReportInfo> getReportInfoList(PageUtil pageUtil, ReportInfo reportInfo)
    {
        PageHelper.startPage(pageUtil.getPage().intValue(), pageUtil.getLimit().intValue());
        List<ReportInfo> list = this.reportInfoMapperManual.getReportInfoList(reportInfo);
        return new PageInfo(list);
    }

    @Transactional
    public Boolean addReportInfo(ReportInfo reportInfo)
    {
        reportInfo.setStatus(Integer.valueOf(1));
        this.reportInfoMapper.insertSelective(reportInfo);
        Long id = reportInfo.getId();
        if (id != null)
        {
            String fileUploads = reportInfo.getFileUploads();
            if ((fileUploads != null) && (StringUtils.isNotBlank(fileUploads)))
            {
                String[] filePaths = fileUploads.split(",");
                for (String filePath : filePaths) {
                    if (StringUtils.isNotBlank(filePath))
                    {
                        ReportEnclosureInfo enclosureInfo = new ReportEnclosureInfo();
                        enclosureInfo.setReportId(id);
                        enclosureInfo.setFilePath(filePath);
                        enclosureInfo.setCreateTime(new Date());
                        this.reportEnclosureInfoMapper.insertSelective(enclosureInfo);
                    }
                }
            }
        }
        return Boolean.valueOf(true);
    }

    public void updateReportInfo(ReportInfo reportInfo)
    {
        this.reportInfoMapper.updateByPrimaryKeySelective(reportInfo);

        String fileUploads = reportInfo.getFileUploads();
        if ((fileUploads != null) && (StringUtils.isNotBlank(fileUploads)))
        {
            String[] filePaths = fileUploads.split(",");
            for (String filePath : filePaths) {
                if (StringUtils.isNotBlank(filePath))
                {
                    ReportEnclosureInfo enclosureInfo = new ReportEnclosureInfo();
                    enclosureInfo.setReportId(reportInfo.getId());
                    enclosureInfo.setFilePath(filePath);
                    enclosureInfo.setCreateTime(new Date());
                    this.reportEnclosureInfoMapper.insertSelective(enclosureInfo);
                }
            }
        }
    }

    public void deleteReportInfo(Long id)
    {
        ReportInfo reportInfo = new ReportInfo();
        reportInfo.setId(id).setStatus(Integer.valueOf(0));
        this.reportInfoMapper.updateByPrimaryKeySelective(reportInfo);
    }

    public ReportInfo getReportInfo(Long id)
    {
        return this.reportInfoMapper.selectByPrimaryKey(id);
    }
}
