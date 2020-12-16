package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.ManagerInfo;
import com.xwkj.cost.util.PageUtil;

import java.util.List;

public interface ManagerInfoService {

    /**
     * @Description : 获取业务员列表
     * @methodName : getManagerInfoList
     * @param pageUtil :
     * @param managerInfo :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.managerInfo>
     * @exception : 
     * @author : zyh
     */
    PageInfo<ManagerInfo> getManagerInfoList(PageUtil pageUtil, ManagerInfo managerInfo);

    /**
     * @Description : 添加业务员信息
     * @methodName : addManagerInfo
     * @param managerInfo :
     * @return : java.lang.Boolean
     * @exception :
     * @author : zyh
     */
    Boolean addManagerInfo(ManagerInfo managerInfo);

    /**
     * @Description : 修改业务员信息
     * @methodName : updateManagerInfo
     * @param managerInfo :
     * @return : void
     * @exception :
     * @author : zyh
     */
    void updateManagerInfo(ManagerInfo managerInfo);

    /**
     * @Description : 删除业务员信息
     * @methodName : deleteManagerInfo
     * @param id : 
     * @return : void
     * @exception : 
     * @author : zyh
     */
    void deleteManagerInfo(Long id);

    /**
     * @Description  ：根据业务员主键获取业务员信息
     * @methodName   : getManagerInfo
     * @param        : * @param id :
     * @return       : com.xwkj.cost.model.ManagerInfo
     * @exception    :
     * @author       : 张童
     */
    ManagerInfo getManagerInfo(Long id);

    List<ManagerInfo> getManagerInfos(ManagerInfo managerInfo);
}
