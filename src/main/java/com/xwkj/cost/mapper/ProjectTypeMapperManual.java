package com.xwkj.cost.mapper;

import com.xwkj.cost.model.ProjectType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectTypeMapperManual {

    /**
     * @Description : 获取合同工程类型列表
     * @methodName : getProjectTypeList
     * @param projectType :
     * @return : java.util.List<com.xwkj.cost.model.ProjectType>
     * @exception :
     * @author : 张永辉
     */
    List<ProjectType> getProjectTypeList(ProjectType projectType);

}