package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.mapper.ContractAdjustMapperManual;
import com.xwkj.cost.mapper.auto.ContractAdjustMapper;
import com.xwkj.cost.mapper.auto.ContractInfoMapper;
import com.xwkj.cost.model.ContractAdjust;
import com.xwkj.cost.model.ContractInfo;
import com.xwkj.cost.service.ContractAdjustService;
import com.xwkj.cost.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: electricity_cost
 * @description: 后期维护服务层
 * @author: 张永辉
 * @create: 2020-06-30 09:47
 **/
@Service
public class ContractAdjustServiceImpl implements ContractAdjustService {

    @Autowired
    private ContractAdjustMapper contractAdjustMapper;

    @Autowired
    private ContractAdjustMapperManual contractAdjustMapperManual;

    @Autowired
    private ContractInfoMapper contractInfoMapper;

    @Override
    public PageInfo<ContractAdjust> getAdjustmentList(PageUtil pageUtil, ContractAdjust adjustment) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getLimit());
        List<ContractAdjust> list = contractAdjustMapperManual.getAdjustmentList(adjustment);
        return new PageInfo<>(list);
    }

    @Override
    public void addAdjustment(ContractAdjust adjustment) {
        //查询合同信息
        ContractInfo contractInfo = contractInfoMapper.selectByPrimaryKey(adjustment.getContractId());
        //赋值
        adjustment.setBeforeMoney(contractInfo.getContractMoney());
        //status为0代表下调，为1代表上调
        if (adjustment.getStatus() == 0){
            adjustment.setAfterMoney(contractInfo.getContractMoney().subtract(adjustment.getMoney()));
        }else if (adjustment.getStatus() == 1){
            adjustment.setAfterMoney(contractInfo.getContractMoney().add(adjustment.getMoney()));
        }
        adjustment.setCreateTime(new Date());
        contractInfo.setContractMoney(adjustment.getAfterMoney());
        contractInfoMapper.updateByPrimaryKeySelective(contractInfo);
        contractAdjustMapper.insertSelective(adjustment);
    }

    public void editAdjustment(ContractAdjust contractAdjust)
    {
        this.contractAdjustMapper.updateByPrimaryKeySelective(contractAdjust);
    }
}
