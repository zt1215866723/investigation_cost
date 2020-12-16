package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.ProjectType;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectType record);

    int insertSelective(ProjectType record);

    ProjectType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectType record);

    int updateByPrimaryKey(ProjectType record);
}