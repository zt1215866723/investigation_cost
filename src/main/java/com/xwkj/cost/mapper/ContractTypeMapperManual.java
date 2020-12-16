package com.xwkj.cost.mapper;

import com.xwkj.cost.model.ContractType;
import com.xwkj.cost.model.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractTypeMapperManual {

    List<ContractType> getPageContractTypeList(ContractType contractType);
}