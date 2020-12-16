package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.ContractAdjust;
import com.xwkj.cost.service.ContractAdjustService;
import com.xwkj.cost.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: electricity_cost
 * @description: 后期维护控制层
 * @author: 张永辉
 * @create: 2020-06-30 09:48
 **/
@RestController
@Slf4j
public class AdjustmentController {

    @Autowired
    private ContractAdjustService contractAdjustService;

    /**
     * @Description : 获取后期维护列表
     * @methodName : getAdjustmentList
     * @param pageUtil :
     * @param adjustment :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @GetMapping("/getAdjustmentList")
    public ResponseResult getAdjustmentList(PageUtil pageUtil, ContractAdjust adjustment){
        ResponseResult responseResult = null;
        try {
            PageInfo<ContractAdjust> list = contractAdjustService.getAdjustmentList(pageUtil, adjustment);
            log.info("获取后期维护列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"获取后期维护列表成功");
        } catch(Exception e){
            log.error("获取后期维护列表失败",e);
            responseResult = ResponseResult.failure("获取后期维护列表失败");
        }
        return responseResult;
    }

    /**
     * @Description : 添加后期维护信息
     * @methodName : addAdjustment
     * @param adjustment :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @PostMapping("/addAdjustment")
    public ResponseResult addAdjustment(ContractAdjust adjustment){
        ResponseResult responseResult = null;
        try {
            contractAdjustService.addAdjustment(adjustment);
            log.info("添加后期维护信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"添加后期维护信息成功");
        } catch(Exception e){
            log.error("添加后期维护信息失败");
            responseResult = ResponseResult.failure("添加后期维护信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 修改后期维护信息
     * @param contractAdjust
     * @return
     */
    @PostMapping({"/editAdjustment"})
    public ResponseResult editAdjustment(ContractAdjust contractAdjust)
    {
        ResponseResult responseResult = null;
        try
        {
            this.contractAdjustService.editAdjustment(contractAdjust);
            log.info("修改调整信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), null, "修改调整信息成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("修改调整信息失败");
            responseResult = ResponseResult.failure("修改调整信息失败");
        }
        return responseResult;
    }
}
