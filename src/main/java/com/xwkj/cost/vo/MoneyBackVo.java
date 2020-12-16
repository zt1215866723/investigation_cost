package com.xwkj.cost.vo;

import java.math.BigDecimal;

/**
 * @ClassName:MoneyBackVo
 * @Description:
 * @Author:张童
 * @Date:
 **/
public class MoneyBackVo {
    /**
     * 金额总数
     */

    private BigDecimal moneySum;

    /*
     * 回款条数
     */
    private Integer countNum;

    //开票时间
    private String applyTime;
    private String moneyBackTime;

    public String getMoneyBackTime() {
        return moneyBackTime;
    }

    public MoneyBackVo setMoneyBackTime(String moneyBackTime) {
        this.moneyBackTime = moneyBackTime;
        return this;
    }

    public BigDecimal getMoneySum() {
        return moneySum;
    }

    public void setMoneySum(BigDecimal moneySum) {
        this.moneySum = moneySum;
    }

    public Integer getCountNum() {
        return countNum;
    }

    public void setCountNum(Integer countNum) {
        this.countNum = countNum;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public MoneyBackVo setApplyTime(String applyTime) {
        this.applyTime = applyTime;
        return this;
    }
}
