package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.mapper.auto.MoneyBackTypeMapper;
import com.xwkj.cost.mapper.MoneyBackTypeMapperManual;
import com.xwkj.cost.model.MoneyBackType;
import com.xwkj.cost.service.MoneyBackTypeService;
import com.xwkj.cost.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: investigation_cost
 * @description: 回款类型服务层
 * @author: 张永辉
 * @create: 2020-07-15 11:53
 **/
@Service
public class MoneyBackTypeServiceImpl implements MoneyBackTypeService {

    @Autowired
    private MoneyBackTypeMapper moneyBackTypeMapper;
    @Autowired
    private MoneyBackTypeMapperManual moneyBackTypeMapperManual;

    /**
     * @Description : 获取回款类型列表
     * @methodName : getMoneyBackTypeList
     * @param pageUtil :
     * @param moneyBackType :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.MoneyBackType>
     * @exception :
     * @author : 张永辉
     */
    @Override
    public PageInfo<MoneyBackType> getMoneyBackTypeList(PageUtil pageUtil, MoneyBackType moneyBackType) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getLimit());
        List<MoneyBackType> list = moneyBackTypeMapperManual.getMoneyBackTypeList(moneyBackType);
        return new PageInfo<>(list);
    }

    /**
     * @Description : 添加回款类型
     * @methodName : addMoneyBackType
     * @param moneyBackType :
     * @return : boolean
     * @exception :
     * @author : 张永辉
     */
    @Override
    public boolean addMoneyBackType(MoneyBackType moneyBackType) {
        moneyBackTypeMapper.insertSelective(moneyBackType.setStatus(0));
        return true;
    }

    /**
     * @Description : 修改回款类型
     * @methodName : updateMoneyBackType
     * @param moneyBackType :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    @Override
    public void updateMoneyBackType(MoneyBackType moneyBackType) {
        moneyBackTypeMapper.updateByPrimaryKeySelective(moneyBackType);
    }

    /**
     * @Description : 删除回款类型
     * @methodName : deleteMoneyBackType
     * @param id :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    @Override
    public void deleteMoneyBackType(Long id) {
        moneyBackTypeMapper.updateByPrimaryKeySelective(new MoneyBackType().setId(id).setStatus(1));
    }

    public List<MoneyBackType> selectMoneyBackTypeList()
    {
        return this.moneyBackTypeMapperManual.getMoneyBackTypeList(null);
    }
}
