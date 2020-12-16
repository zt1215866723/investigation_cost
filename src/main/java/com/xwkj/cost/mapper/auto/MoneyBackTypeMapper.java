package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.MoneyBackType;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyBackTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MoneyBackType record);

    int insertSelective(MoneyBackType record);

    MoneyBackType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MoneyBackType record);

    int updateByPrimaryKey(MoneyBackType record);
}