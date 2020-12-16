package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.ApplyBackRelaction;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyBackRelactionMapper
{
    int deleteByPrimaryKey(Long paramLong);

    int insert(ApplyBackRelaction paramApplyBackRelaction);

    int insertSelective(ApplyBackRelaction paramApplyBackRelaction);

    ApplyBackRelaction selectByPrimaryKey(Long paramLong);

    int updateByPrimaryKeySelective(ApplyBackRelaction paramApplyBackRelaction);

    int updateByPrimaryKey(ApplyBackRelaction paramApplyBackRelaction);
}
