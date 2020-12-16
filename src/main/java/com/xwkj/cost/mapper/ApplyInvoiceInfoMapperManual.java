package com.xwkj.cost.mapper;

import com.xwkj.cost.model.ApplyInvoiceInfo;
import com.xwkj.cost.vo.ContractInfoAndInvoiceInfoVo;
import com.xwkj.cost.vo.InvoiceStatisticsVo;
import com.xwkj.cost.vo.MoneyBackVo;
import com.xwkj.cost.vo.SelectContractInfoVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyInvoiceInfoMapperManual {

    int insert(ApplyInvoiceInfo record);

    List<ApplyInvoiceInfo> selectByContractId(Long id);

    List<ApplyInvoiceInfo> getApplyInvoiceInfo(ApplyInvoiceInfo applyInvoiceInfo);

    /**
     * @Description  ：获取总额和总数
     * @methodName   : getSumAndCount
     * @param        :
     * @return       : java.util.List<com.xwkj.cost.vo.MoneyBackVo>
     * @exception    :
     * @author       : 张童
     */

    MoneyBackVo getSumAndCount(ContractInfoAndInvoiceInfoVo paramContractInfoAndInvoiceInfoVo);

    /**
     * @Description  ：获取开票时间
     * @methodName   : getApplyTime
     * @param        : * @param contractId :
     * @return       : com.xwkj.cost.vo.MoneyBackVo
     * @exception    :
     * @author       : 张童
     */

    List<MoneyBackVo> getApplyTime(Long contractId);

    List<InvoiceStatisticsVo> getInvoiceStatistics(SelectContractInfoVo selectContractInfoVo);
}