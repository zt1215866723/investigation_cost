package com.xwkj.cost.model;

public class ApplyBackRelaction
{
    private Long id;
    private Long applyid;
    private Long moneybackid;

    public Long getId()
    {
        return this.id;
    }

    public ApplyBackRelaction setId(Long id)
    {
        this.id = id;
        return this;
    }

    public Long getApplyid()
    {
        return this.applyid;
    }

    public ApplyBackRelaction setApplyid(Long applyid)
    {
        this.applyid = applyid;
        return this;
    }

    public Long getMoneybackid()
    {
        return this.moneybackid;
    }

    public ApplyBackRelaction setMoneybackid(Long moneybackid)
    {
        this.moneybackid = moneybackid;
        return this;
    }
}
