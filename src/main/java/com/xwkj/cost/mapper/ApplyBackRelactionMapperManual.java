package com.xwkj.cost.mapper;

import com.xwkj.cost.model.ApplyBackRelaction;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyBackRelactionMapperManual
{
    ApplyBackRelaction selectByConditions(ApplyBackRelaction paramApplyBackRelaction);
}
