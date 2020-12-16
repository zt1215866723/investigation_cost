package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.ContractType;
import com.xwkj.cost.model.UserInfo;
import com.xwkj.cost.util.PageUtil;

import java.util.List;

public interface ContractTypeService {

    /**
     * @Description : 获取成本分类列表
     * @methodName : getContractTypeList
     * @return : java.util.List<com.xwkj.cost.model.ContractType>
     * @exception :
     * @author : zt
     */
    List<ContractType> getContractTypeList();

    /**
     * @Description : 增加成本分类信息
     * @methodName : addContractType
     * @param ContractType :
     * @return : java.lang.Long
     * @exception :
     * @author : zt
     */
    Long addContractType(ContractType ContractType);

    /**
     * @Description : 修改成本分类信息
     * @methodName : updateContractType
     * @param ContractType :
     * @return : void
     * @exception :
     * @author : zt
     */
    void updateContractType(ContractType ContractType);

    /**
     * @Description : 删除成本分类信息
     * @methodName : deleteContractType
     * @param id :
     * @return : void
     * @exception :
     * @author : zt
     */
    void deleteContractType(Long id);

    PageInfo<ContractType> getPageContractTypeList(PageUtil pageUtil, ContractType contractType);
}
