package com.xwkj.cost.mapper;

import com.xwkj.cost.model.ManagerInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerInfoMapperManual {


    List<ManagerInfo> getManagerInfoList(ManagerInfo managerInfo);
}