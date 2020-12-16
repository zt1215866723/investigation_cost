package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.mapper.ProjectTypeMapperManual;
import com.xwkj.cost.mapper.auto.ProjectTypeMapper;
import com.xwkj.cost.model.ProjectType;
import com.xwkj.cost.service.ProjectTypeService;
import com.xwkj.cost.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: investigation_cost
 * @description: 合同工程类型服务层
 * @author: 张永辉
 * @create: 2020-07-15 14:08
 **/
@Service
public class ProjectTypeServiceImpl implements ProjectTypeService {

    @Autowired
    private ProjectTypeMapper projectTypeMapper;
    @Autowired
    private ProjectTypeMapperManual projectTypeMapperManual;


    /**
     * @param projectType :
     * @param pageUtil    :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.ProjectType>
     * @throws :
     * @Description : 获取合同工程类型列表
     * @methodName : getProjectTypeList
     * @author : 张永辉
     */
    @Override
    public PageInfo<ProjectType> getProjectTypeList(ProjectType projectType, PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getLimit());
        List<ProjectType> projectTypeList = projectTypeMapperManual.getProjectTypeList(projectType);
        return new PageInfo<>(projectTypeList);
    }

    /**
     * @param projectType :
     * @return : boolean
     * @throws :
     * @Description : 添加合同工程类型
     * @methodName : addProjectType
     * @author : 张永辉
     */
    @Override
    public boolean addProjectType(ProjectType projectType) {
        projectTypeMapper.insertSelective(projectType.setStatus(0));
        return true;
    }

    /**
     * @param projectType :
     * @return : void
     * @throws :
     * @Description : 修改合同工程类型
     * @methodName : updateProjectType
     * @author : 张永辉
     */
    @Override
    public void updateProjectType(ProjectType projectType) {
        projectTypeMapper.updateByPrimaryKeySelective(projectType);
    }

    /**
     * @param id :
     * @return : void
     * @throws :
     * @Description : 删除合同工程类型
     * @methodName : deleteProjectType
     * @author : 张永辉
     */
    @Override
    public void deleteProjectType(Long id) {
        projectTypeMapper.updateByPrimaryKeySelective(new ProjectType().setId(id).setStatus(1));
    }


    public List<ProjectType> selectProjectTypeList() {
        return this.projectTypeMapperManual.getProjectTypeList(null);
    }
}
