package com.xwkj.cost.mapper;

import com.xwkj.cost.model.ContractAdjust;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractAdjustMapperManual {
    List<ContractAdjust> getAdjustmentList(ContractAdjust adjustment);
}