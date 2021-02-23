package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.LoginUserInfoManager;
import com.xwkj.cost.mapper.ApplyBackRelactionMapperManual;
import com.xwkj.cost.mapper.ApplyInvoiceInfoMapperManual;
import com.xwkj.cost.mapper.MoneyBackInfoMapperManual;
import com.xwkj.cost.mapper.auto.ApplyBackRelactionMapper;
import com.xwkj.cost.mapper.auto.ApplyInvoiceInfoMapper;
import com.xwkj.cost.mapper.auto.MoneyBackInfoMapper;
import com.xwkj.cost.model.ApplyBackRelaction;
import com.xwkj.cost.model.ApplyInvoiceInfo;
import com.xwkj.cost.model.MoneyBackInfo;
import com.xwkj.cost.service.MoneyBackInfoService;
import com.xwkj.cost.util.PageUtil;
import com.xwkj.cost.vo.ContractInfoAndInvoiceInfoVo;
import com.xwkj.cost.vo.InvoiceStatisticsVo;
import com.xwkj.cost.vo.MoneyBackVo;
import com.xwkj.cost.vo.SelectContractInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class MoneyBackInfoServiceImpl implements MoneyBackInfoService {

    @Autowired
    MoneyBackInfoMapper moneyBackInfoMapper;
    @Autowired
    MoneyBackInfoMapperManual moneyBackInfoMapperManual;
    @Autowired
    ApplyInvoiceInfoMapper applyInvoiceInfoMapper;
    @Autowired
    ApplyInvoiceInfoMapperManual applyInvoiceInfoMapperManual;
    @Autowired
    ApplyBackRelactionMapper applyBackRelactionMapper;
    @Autowired
    ApplyBackRelactionMapperManual applyBackRelactionMapperManual;

    /**
     * @param :          * @param pageUtil :
     * @param contractId :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.MoneyBackInfo>
     * @throws :
     * @Description ：获取回款信息列表
     * @methodName : getMoneyBackInfoList
     * @author : 张童
     */

    @Override
    public PageInfo<MoneyBackInfo> getMoneyBackInfoList(PageUtil pageUtil, Long contractId) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getLimit());
        List<MoneyBackInfo> list = moneyBackInfoMapperManual.getMoneyBackInfoList(contractId);
        return new PageInfo<>(list);
    }

    /**
     * @param :
     * @return : java.util.List<com.xwkj.cost.vo.MoneyBackVo>
     * @throws :
     * @Description ：获取总额和总数
     * @methodName : getSumAndCount
     * @author : 张童
     */
    @Override
    public MoneyBackVo getSumAndCount(Long contractId) {
        ContractInfoAndInvoiceInfoVo contractInfoAndInvoiceInfoVo = new ContractInfoAndInvoiceInfoVo();
        contractInfoAndInvoiceInfoVo.setId(contractId);
        MoneyBackVo moneyBackVo = this.moneyBackInfoMapperManual.getSumAndCount(contractInfoAndInvoiceInfoVo);
        if ((moneyBackVo != null) &&
                (moneyBackVo.getMoneySum() == null)) {
            moneyBackVo.setMoneySum(BigDecimal.valueOf(0L));
        }
        return moneyBackVo;
    }

    /**
     * @param : * @param moneyBackInfo :
     * @return : com.xwkj.cost.common.ResponseResult
     * @throws :
     * @Description ：插入回款
     * @methodName : insertMoneyBackInfo
     * @author : 张童
     */
    @Override
    public void insertMoneyBackInfo(MoneyBackInfo moneyBackInfo) {
//            String[] split = moneyBackInfo.getCertificateNumber().split("\\.");
//            Date date = DateUtil.stringToDate(split[0] + "-" + split[1] + "-01", "yyyy-MM-dd");
//            moneyBackInfo.setArrivalMoney(date);
        moneyBackInfo.setCreateTime(new Date()).setCreator(LoginUserInfoManager.getUserInfo().getId()).setStatus(Integer.valueOf(1));
        if (moneyBackInfo.getHasInvoice().intValue() == 0) {
            moneyBackInfo.setInvoiceType(Integer.valueOf(0));
        }
        this.moneyBackInfoMapper.insertSelective(moneyBackInfo);
        if (moneyBackInfo.getHasInvoice().intValue() != 0) {
            this.applyBackRelactionMapper.insertSelective(new ApplyBackRelaction().setMoneybackid(moneyBackInfo.getId()).setApplyid(moneyBackInfo.getApplyInvoiceId()));
        }
    }

    /**
     * @param : * @param moneyBackInfo :
     * @return : com.xwkj.cost.common.ResponseResult
     * @throws :
     * @Description ：修改回款信息
     * @methodName : updateMoneyBackInfo
     * @author : 张童
     */
    @Override
    public void updateMoneyBackInfo(MoneyBackInfo moneyBackInfo) {
//            String[] split = moneyBackInfo.getCertificateNumber().split("\\.");
//            Date date = DateUtil.stringToDate(split[0] + "-" + split[1] + "-01", "yyyy-MM-dd");
//            moneyBackInfo.setArrivalMoney(date);
        ApplyBackRelaction applyBackRelaction = this.applyBackRelactionMapperManual.selectByConditions(new ApplyBackRelaction().setMoneybackid(moneyBackInfo.getId()));
        if (moneyBackInfo.getHasInvoice().intValue() == 0) {
            moneyBackInfo.setInvoiceType(Integer.valueOf(0)).setApplyInvoiceId(null);
            if (applyBackRelaction != null) {
                this.applyBackRelactionMapper.deleteByPrimaryKey(applyBackRelaction.getId());
            }
        } else if (applyBackRelaction != null) {
            this.applyBackRelactionMapper.updateByPrimaryKeySelective(applyBackRelaction.setApplyid(moneyBackInfo.getApplyInvoiceId()));
        } else {
            this.applyBackRelactionMapper.insertSelective(new ApplyBackRelaction().setMoneybackid(moneyBackInfo.getId()).setApplyid(moneyBackInfo.getApplyInvoiceId()));
        }
        this.moneyBackInfoMapper.updateByPrimaryKeySelective(moneyBackInfo);
    }

    /**
     * @param : * @param moneyBackId :
     * @return : com.xwkj.cost.model.MoneyBackInfo
     * @throws :
     * @Description ：获得该条回款记录的详细信息
     * @methodName : findMoneyBackById
     * @author : 张童
     */

    @Override
    public MoneyBackInfo findMoneyBackById(Long moneyBackId) {
        return moneyBackInfoMapperManual.findMoneyBackById(moneyBackId);
    }

    @Override
    public void deleteMoneyBackInfo(Long id) {
        MoneyBackInfo moneyBackInfo = new MoneyBackInfo();
        moneyBackInfo.setId(id).setStatus(Integer.valueOf(2));
        this.moneyBackInfoMapper.updateByPrimaryKeySelective(moneyBackInfo);

        ApplyBackRelaction applyBackRelaction = new ApplyBackRelaction();
        applyBackRelaction.setMoneybackid(id);
        ApplyBackRelaction applyBackRelaction1 = this.applyBackRelactionMapperManual.selectByConditions(applyBackRelaction);
        this.applyBackRelactionMapper.deleteByPrimaryKey(applyBackRelaction1.getId());
    }

    public ApplyInvoiceInfo findApplyByMoneyBackId(Long moneyBackId) {
        ApplyBackRelaction applyBackRelaction = this.applyBackRelactionMapperManual.selectByConditions(new ApplyBackRelaction().setMoneybackid(moneyBackId));
        if (applyBackRelaction != null) {
            ApplyInvoiceInfo applyInvoiceInfo = this.applyInvoiceInfoMapper.selectByPrimaryKey(applyBackRelaction.getApplyid());
            return applyInvoiceInfo;
        }
        return null;
    }

    @Override
    public PageInfo<InvoiceStatisticsVo> getMoneyBackStatistics(PageUtil pageUtil, SelectContractInfoVo selectContractInfoVo) {
        if (pageUtil.getLimit() != null && pageUtil.getPage() != null) {
            PageHelper.startPage(pageUtil.getPage(), pageUtil.getLimit());
        }
        List<InvoiceStatisticsVo> list = moneyBackInfoMapperManual.getMoneyBackStatistics(selectContractInfoVo);
        return new PageInfo<>(list);
    }
}
