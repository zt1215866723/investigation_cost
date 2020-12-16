package com.xwkj.cost.mapper;

import com.xwkj.cost.model.SubContractInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubContractInfoMapperManual {


    /**
     * @Description : 根据合同主键获取成本合同列表信息
     * @methodName : getSubContractInfoListByContractId
     * @param contractId : 
     * @return : java.util.List<com.xwkj.cost.model.SubContractInfo>
     * @exception : 
     * @author : zyh
     */
    List<SubContractInfo> getSubContractInfoListByContractId(Long contractId);
}