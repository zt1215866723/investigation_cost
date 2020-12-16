package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.ManagerInfo;
import com.xwkj.cost.service.ManagerInfoService;
import com.xwkj.cost.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ManagerInfoController {

    @Autowired
    ManagerInfoService managerInfoService;

    /**
     * @param pageUtil    :
     * @param managerInfo :
     * @return : com.xwkj.cost.common.ResponseResult
     * @throws :
     * @Description : 获取业务员信息列表
     * @methodName : getManagerInfoList
     * @author : zyh
     */
    @GetMapping("/getManagerInfoList")
    public ResponseResult getManagerInfoList(PageUtil pageUtil, ManagerInfo managerInfo) {
        ResponseResult responseResult = null;
        try {
            PageInfo<ManagerInfo> pageInfo = managerInfoService.getManagerInfoList(pageUtil, managerInfo);
            log.info("获取业务员信息列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), pageInfo, "获取业务员信息列表成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取业务员信息列表失败");
            responseResult = ResponseResult.failure("获取业务员信息列表失败");
        }
        return responseResult;
    }

    /**
     * @param managerInfo :
     * @return : com.xwkj.cost.common.ResponseResult
     * @throws :
     * @Description : 添加业务员信息
     * @methodName : addManagerInfo
     * @author : zyh
     */
    @PostMapping("/addManagerInfo")
    public ResponseResult addManagerInfo(ManagerInfo managerInfo) {
        ResponseResult responseResult = null;
        try {
            Boolean b = managerInfoService.addManagerInfo(managerInfo);
            if (b) {
                log.info("添加业务员信息成功");
                responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), null, "添加业务员信息成功");
            } else {
                log.error("添加业务员信息失败,业务员名重复");
                responseResult = ResponseResult.failure("添加业务员信息失败,业务员名重复");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("添加业务员信息失败");
            responseResult = ResponseResult.failure("添加业务员信息失败");
        }
        return responseResult;
    }

    /**
     * @param managerInfo :
     * @return : com.xwkj.cost.common.ResponseResult
     * @throws :
     * @Description : 修改业务员信息
     * @methodName : updateManagerInfo
     * @author : zyh
     */
    @PutMapping("/updateManagerInfo")
    public ResponseResult updateManagerInfo(ManagerInfo managerInfo) {
        ResponseResult responseResult = null;
        try {
            managerInfoService.updateManagerInfo(managerInfo);
            log.info("修改业务员信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), null, "修改业务员信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("修改业务员信息失败");
            responseResult = ResponseResult.failure("修改业务员信息失败");
        }
        return responseResult;
    }

    /**
     * @param id :
     * @return : com.xwkj.cost.common.ResponseResult
     * @throws :
     * @Description : 删除业务员信息
     * @methodName : deleteManagerInfo
     * @author : zyh
     */
    @DeleteMapping("/deleteManagerInfo")
    public ResponseResult deleteManagerInfo(Long id) {
        ResponseResult responseResult = null;
        try {
            managerInfoService.deleteManagerInfo(id);
            log.info("删除业务员信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), null, "删除业务员信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("删除业务员信息失败");
            responseResult = ResponseResult.failure("删除业务员信息失败");
        }
        return responseResult;
    }

    /**
     * @param : * @param id :
     * @return : com.xwkj.cost.common.ResponseResult
     * @throws :
     * @Description ：根据业务员主键获取业务员信息
     * @methodName : getManagerInfoById
     * @author : 张童
     */
    @GetMapping("/getManagerInfoById")
    public ResponseResult getManagerInfoById(Long id) {
        ResponseResult responseResult = null;
        try {
            ManagerInfo managerInfo = managerInfoService.getManagerInfo(id);
            log.info("根据业务员主键获取业务员信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), managerInfo, "根据业务员主键获取业务员信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("根据业务员主键获取业务员信息失败");
            responseResult = ResponseResult.failure("根据业务员主键获取业务员信息失败");
        }
        return responseResult;
    }

    @GetMapping({"/getManagerInfos"})
    public ResponseResult getManagerInfos(ManagerInfo managerInfo)
    {
        ResponseResult responseResult = null;
        try
        {
            List<ManagerInfo> managerInfos = this.managerInfoService.getManagerInfos(managerInfo);
            log.info("获取业务员信息列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), managerInfos, "获取业务员信息列表成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("获取业务员信息列表失败");
            responseResult = ResponseResult.failure("获取业务员信息列表失败");
        }
        return responseResult;
    }
}
