package com.xwkj.cost.mapper;

import com.xwkj.cost.model.ContractCostTypeRelated;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractCostTypeRelatedMapperManual {


    /**
     * @Description : 根据合同主键获取其他成本列表
     * @methodName : getContractCostTypeRelatedList
     * @param contractId :
     * @return : java.util.List<com.xwkj.cost.model.ContractCostTypeRelated>
     * @exception :
     * @author : zyh
     */
    List<ContractCostTypeRelated> getContractCostTypeRelatedListByContractId(Long contractId);
}