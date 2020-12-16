package com.xwkj.cost.model;

public class ReportInfo
{
    private Long id;
    private Long contractId;
    private String reportNumber;
    private String reportName;
    private String signedWorkload;
    private String actualWorkload;
    private String measurementUnit;
    private Integer status;
    private String fileUploads;

    public String getFileUploads()
    {
        return this.fileUploads;
    }

    public ReportInfo setFileUploads(String fileUploads)
    {
        this.fileUploads = fileUploads;
        return this;
    }

    public Long getId()
    {
        return this.id;
    }

    public ReportInfo setId(Long id)
    {
        this.id = id;
        return this;
    }

    public Long getContractId()
    {
        return this.contractId;
    }

    public ReportInfo setContractId(Long contractId)
    {
        this.contractId = contractId;
        return this;
    }

    public String getReportNumber()
    {
        return this.reportNumber;
    }

    public ReportInfo setReportNumber(String reportNumber)
    {
        this.reportNumber = (reportNumber == null ? null : reportNumber.trim());
        return this;
    }

    public String getReportName()
    {
        return this.reportName;
    }

    public ReportInfo setReportName(String reportName)
    {
        this.reportName = (reportName == null ? null : reportName.trim());
        return this;
    }

    public String getSignedWorkload()
    {
        return this.signedWorkload;
    }

    public ReportInfo setSignedWorkload(String signedWorkload)
    {
        this.signedWorkload = (signedWorkload == null ? null : signedWorkload.trim());
        return this;
    }

    public String getActualWorkload()
    {
        return this.actualWorkload;
    }

    public ReportInfo setActualWorkload(String actualWorkload)
    {
        this.actualWorkload = (actualWorkload == null ? null : actualWorkload.trim());
        return this;
    }

    public String getMeasurementUnit()
    {
        return this.measurementUnit;
    }

    public ReportInfo setMeasurementUnit(String measurementUnit)
    {
        this.measurementUnit = (measurementUnit == null ? null : measurementUnit.trim());
        return this;
    }

    public Integer getStatus()
    {
        return this.status;
    }

    public ReportInfo setStatus(Integer status)
    {
        this.status = status;
        return this;
    }
}
