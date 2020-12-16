package com.xwkj.cost.model;

import java.util.Date;

public class ReportEnclosureInfo
{
    private Long id;
    private String filePath;
    private Date createTime;
    private Long reportId;

    public Long getId()
    {
        return this.id;
    }

    public ReportEnclosureInfo setId(Long id)
    {
        this.id = id;
        return this;
    }

    public String getFilePath()
    {
        return this.filePath;
    }

    public ReportEnclosureInfo setFilePath(String filePath)
    {
        this.filePath = (filePath == null ? null : filePath.trim());
        return this;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public ReportEnclosureInfo setCreateTime(Date createTime)
    {
        this.createTime = createTime;
        return this;
    }

    public Long getReportId()
    {
        return this.reportId;
    }

    public ReportEnclosureInfo setReportId(Long reportId)
    {
        this.reportId = reportId;
        return this;
    }
}
