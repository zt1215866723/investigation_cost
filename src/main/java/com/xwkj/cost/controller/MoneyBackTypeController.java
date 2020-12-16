package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.MoneyBackType;
import com.xwkj.cost.service.MoneyBackTypeService;
import com.xwkj.cost.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: investigation_cost
 * @description: 回款类型控制层
 * @author: 张永辉
 * @create: 2020-07-15 11:54
 **/
@RestController
@Slf4j
public class MoneyBackTypeController {

    @Autowired
    private MoneyBackTypeService moneyBackTypeService;

    /**
     * @Description : 获取回款类型列表
     * @methodName : getMoneyBackTypeList
     * @param pageUtil :
     * @param moneyBackType :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @GetMapping("/getMoneyBackTypeList")
    public ResponseResult getMoneyBackTypeList(PageUtil pageUtil, MoneyBackType moneyBackType) {
        ResponseResult responseResult = null;
        try {
            PageInfo<MoneyBackType> list = moneyBackTypeService.getMoneyBackTypeList(pageUtil, moneyBackType);
            log.info("获取回款类型列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"获取回款类型列表成功");
        } catch(Exception e){
            log.error("获取回款类型列表失败",e);
            responseResult = ResponseResult.failure("获取回款类型列表失败");
        }
        return responseResult;
    }

    /**
     * @Description : 添加回款类型
     * @methodName : addMoneyBackType
     * @param moneyBackType :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @PostMapping("/addMoneyBackType")
    public ResponseResult addMoneyBackType(MoneyBackType moneyBackType){
        ResponseResult responseResult = null;
        try {
            moneyBackTypeService.addMoneyBackType(moneyBackType);
            log.info("添加回款类型成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"添加回款类型成功");
        } catch(Exception e){
            log.error("添加回款类型失败",e);
            responseResult = ResponseResult.failure("添加回款类型失败");
        }
        return responseResult;
    }

    /**
     * @Description : 修改回款类型
     * @methodName : updateMoneyBackType
     * @param moneyBackType :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @PutMapping("/updateMoneyBackType")
    public ResponseResult updateMoneyBackType(MoneyBackType moneyBackType){
        ResponseResult responseResult = null;
        try {
            moneyBackTypeService.updateMoneyBackType(moneyBackType);
            log.info("修改回款类型成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改回款类型成功");
        } catch(Exception e){
            log.error("修改回款类型失败",e);
            responseResult = ResponseResult.failure("修改回款类型失败");
        }
        return responseResult;
    }

    /**
     * @Description : 删除回款类型
     * @methodName : deleteMoneyBackType
     * @param id :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @DeleteMapping("/deleteMoneyBackType/{id}")
    public ResponseResult deleteMoneyBackType(@PathVariable("id") Long id) {
        ResponseResult responseResult = null;
        try {
            moneyBackTypeService.deleteMoneyBackType(id);
            log.info("删除回款类型成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除回款类型成功");
        } catch(Exception e){
            log.error("删除回款类型失败",e);
            responseResult = ResponseResult.failure("删除回款类型失败");
        }
        return responseResult;
    }

    @PostMapping({"/selectMoneyBackTypeList"})
    public ResponseResult selectMoneyBackTypeList()
    {
        ResponseResult responseResult = null;
        try
        {
            List<MoneyBackType> list = this.moneyBackTypeService.selectMoneyBackTypeList();
            log.info("查询回款列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), list, "查询回款列表成功");
        }
        catch (Exception e)
        {
            log.error("查询回款列表失败", e);
            responseResult = ResponseResult.failure("查询回款列表失败");
        }
        return responseResult;
    }
}
