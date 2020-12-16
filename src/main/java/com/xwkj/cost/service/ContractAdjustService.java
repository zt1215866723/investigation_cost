package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.ContractAdjust;
import com.xwkj.cost.util.PageUtil;

/**
 * @program: electricity_cost
 * @description: 后期维护服务层
 * @author: 张永辉
 * @create: 2020-06-30 09:46
 **/
public interface ContractAdjustService {

    PageInfo<ContractAdjust> getAdjustmentList(PageUtil pageUtil, ContractAdjust adjustment);

    void addAdjustment(ContractAdjust adjustment);

    void editAdjustment(ContractAdjust paramContractAdjust);
}
