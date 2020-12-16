package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.ProjectType;
import com.xwkj.cost.util.PageUtil;

import java.util.List;

/**
 * @program: investigation_cost
 * @description: 合同工程类型服务层
 * @author: 张永辉
 * @create: 2020-07-15 14:07
 **/
public interface ProjectTypeService {

    /**
     * @Description : 获取合同工程类型列表
     * @methodName : getProjectTypeList
     * @param projectType :
     * @param pageUtil :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.ProjectType>
     * @exception :
     * @author : 张永辉
     */
    PageInfo<ProjectType> getProjectTypeList(ProjectType projectType, PageUtil pageUtil);

    /**
     * @Description : 添加合同工程类型
     * @methodName : addProjectType
     * @param projectType :
     * @return : boolean
     * @exception :
     * @author : 张永辉
     */
    boolean addProjectType(ProjectType projectType);

    /**
     * @Description : 修改合同工程类型
     * @methodName : updateProjectType
     * @param projectType :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    void updateProjectType(ProjectType projectType);

    /**
     * @Description : 删除合同工程类型
     * @methodName : deleteProjectType
     * @param id :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    void deleteProjectType(Long id);

    List<ProjectType> selectProjectTypeList();
}
