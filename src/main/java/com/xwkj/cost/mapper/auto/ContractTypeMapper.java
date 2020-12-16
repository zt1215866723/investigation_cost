package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.ContractType;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContractType record);

    int insertSelective(ContractType record);

    ContractType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContractType record);

    int updateByPrimaryKey(ContractType record);
}