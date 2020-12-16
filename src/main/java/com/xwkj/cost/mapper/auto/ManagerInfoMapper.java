package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.ManagerInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ManagerInfo record);

    int insertSelective(ManagerInfo record);

    ManagerInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ManagerInfo record);

    int updateByPrimaryKey(ManagerInfo record);
}