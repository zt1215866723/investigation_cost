package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.mapper.ContractCostTypeRelatedMapperManual;
import com.xwkj.cost.mapper.ContractTypeMapperManual;
import com.xwkj.cost.mapper.PersonCostMapperManual;
import com.xwkj.cost.mapper.SubContractInfoMapperManual;
import com.xwkj.cost.mapper.auto.ContractTypeMapper;
import com.xwkj.cost.model.*;
import com.xwkj.cost.service.ContractTypeService;
import com.xwkj.cost.service.ContractTypeService;
import com.xwkj.cost.util.PageUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ContractTypeServiceImpl implements ContractTypeService{

    @Autowired
    private ContractTypeMapper contractTypeMapper;
    @Autowired
    private ContractTypeMapperManual contractTypeMapperManual;

    /**
     * @Description : 获取成本分类列表
     * @methodName : getContractTypeList
     * @return : java.util.List<com.xwkj.cost.model.ContractType>
     * @exception :
     * @author : zt
     */
    @Override
    public List<ContractType> getContractTypeList() {
        return contractTypeMapperManual.getPageContractTypeList(null);
    }

    /**
     * @Description : 增加成本分类信息
     * @methodName : addContractType
     * @param contractType :
     * @return : java.lang.Long
     * @exception :
     * @author : zt
     */
    @Override
    public Long addContractType(ContractType contractType) {
        contractType.setStatus(1);
        contractTypeMapper.insertSelective(contractType);
        return contractType.getId();
    }

    /**
     * @Description : 修改成本分类信息
     * @methodName : updateContractType
     * @param ContractType :
     * @return : void
     * @exception :
     * @author : zt
     */
    @Override
    public void updateContractType(ContractType ContractType) {
        contractTypeMapper.updateByPrimaryKeySelective(ContractType);
    }

    /**
     * @Description : 删除成本分类信息
     * @methodName : deleteContractType
     * @param id :
     * @return : void
     * @exception :
     * @author : zt
     */
    @Override
    public void deleteContractType(Long id) {
        ContractType contractType =new ContractType();
            contractType.setId(id).setStatus(0);
            contractTypeMapper.updateByPrimaryKeySelective(contractType);
    }

    @Override
    public PageInfo<ContractType> getPageContractTypeList(PageUtil pageUtil, ContractType contractType) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getLimit());
        List<ContractType> list = contractTypeMapperManual.getPageContractTypeList(contractType);
        return new PageInfo<>(list);
    }

}
