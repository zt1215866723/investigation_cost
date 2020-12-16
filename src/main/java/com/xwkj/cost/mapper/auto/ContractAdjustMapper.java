package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.ContractAdjust;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractAdjustMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContractAdjust record);

    int insertSelective(ContractAdjust record);

    ContractAdjust selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContractAdjust record);

    int updateByPrimaryKey(ContractAdjust record);
}