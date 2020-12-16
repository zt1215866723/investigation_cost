package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.MoneyBackType;
import com.xwkj.cost.util.PageUtil;

import java.util.List;

/**
 * @program: investigation_cost
 * @description: 回款类型服务层
 * @author: 张永辉
 * @create: 2020-07-15 11:52
 **/
public interface MoneyBackTypeService {

    /**
     * @Description : 获取回款类型列表
     * @methodName : getMoneyBackTypeList
     * @param pageUtil :
     * @param moneyBackType :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.MoneyBackType>
     * @exception :
     * @author : 张永辉
     */
    PageInfo<MoneyBackType> getMoneyBackTypeList(PageUtil pageUtil, MoneyBackType moneyBackType);

    /**
     * @Description : 添加回款类型
     * @methodName : addMoneyBackType
     * @param moneyBackType :
     * @return : boolean
     * @exception :
     * @author : 张永辉
     */
    boolean addMoneyBackType(MoneyBackType moneyBackType);

    /**
     * @Description : 修改回款类型
     * @methodName : updateMoneyBackType
     * @param moneyBackType :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    void updateMoneyBackType(MoneyBackType moneyBackType);

    /**
     * @Description : 删除回款类型
     * @methodName : deleteMoneyBackType
     * @param id :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    void deleteMoneyBackType(Long id);

    List<MoneyBackType> selectMoneyBackTypeList();
}
