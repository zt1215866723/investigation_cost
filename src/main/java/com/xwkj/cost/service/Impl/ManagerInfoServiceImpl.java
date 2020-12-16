package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.mapper.ManagerInfoMapperManual;
import com.xwkj.cost.mapper.auto.ManagerInfoMapper;
import com.xwkj.cost.model.ManagerInfo;
import com.xwkj.cost.service.ManagerInfoService;
import com.xwkj.cost.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ManagerInfoServiceImpl implements ManagerInfoService {

    @Autowired
    ManagerInfoMapper managerInfoMapper;
    @Autowired
    ManagerInfoMapperManual managerInfoMapperManual;

    /**
     * @param pageUtil    :
     * @param managerInfo :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.ManagerInfo>
     * @throws :
     * @Description : 获取业务员列表
     * @methodName : getManagerInfoList
     * @author : zyh
     */
    @Override
    public PageInfo<ManagerInfo> getManagerInfoList(PageUtil pageUtil, ManagerInfo managerInfo) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getLimit());
        List<ManagerInfo> list = managerInfoMapperManual.getManagerInfoList(managerInfo);
        return new PageInfo<>(list);
    }

    /**
     * @param managerInfo :
     * @return : java.lang.Boolean
     * @throws :
     * @Description : 添加业务员信息
     * @methodName : addManagerInfo
     * @author : zyh
     */
    @Transactional
    @Override
    public Boolean addManagerInfo(ManagerInfo managerInfo) {

        managerInfo.setCreateTime(new Date()).setStatus(1);
        managerInfoMapper.insertSelective(managerInfo);
        return true;
    }

    /**
     * @param managerInfo :
     * @return : void
     * @throws :
     * @Description : 修改业务员信息
     * @methodName : updateManagerInfo
     * @author : zyh
     */
    @Override
    public void updateManagerInfo(ManagerInfo managerInfo) {
        managerInfoMapper.updateByPrimaryKeySelective(managerInfo);
    }

    /**
     * @param id :
     * @return : void
     * @throws :
     * @Description : 删除业务员信息
     * @methodName : deleteManagerInfo
     * @author : zyh
     */
    @Override
    public void deleteManagerInfo(Long id) {
        ManagerInfo managerInfo = new ManagerInfo();
        managerInfo.setId(id).setStatus(0);
        managerInfoMapper.updateByPrimaryKeySelective(managerInfo);
    }

    /**
     * @param : * @param id :
     * @return : com.xwkj.cost.model.ManagerInfo
     * @throws :
     * @Description ：根据业务员主键获取业务员信息
     * @methodName : getManagerInfo
     * @author : 张童
     */
    @Override
    public ManagerInfo getManagerInfo(Long id) {
        return managerInfoMapper.selectByPrimaryKey(id);
    }

    public List<ManagerInfo> getManagerInfos(ManagerInfo managerInfo)
    {
        managerInfo.setStatus(Integer.valueOf(1));
        return this.managerInfoMapperManual.getManagerInfoList(managerInfo);
    }
}
