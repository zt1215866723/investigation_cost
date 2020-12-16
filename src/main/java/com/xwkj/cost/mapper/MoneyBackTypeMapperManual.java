package com.xwkj.cost.mapper;

import com.xwkj.cost.model.MoneyBackType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoneyBackTypeMapperManual {

    /**
     * @Description : 获取回款类型列表
     * @methodName : getMoneyBackTypeList
     * @param moneyBackType :
     * @return : java.util.List<com.xwkj.cost.model.MoneyBackType>
     * @exception :
     * @author : 张永辉
     */
    List<MoneyBackType> getMoneyBackTypeList(MoneyBackType moneyBackType);

}