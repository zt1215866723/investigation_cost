package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.ContractType;
import com.xwkj.cost.model.UserInfo;
import com.xwkj.cost.service.ContractTypeService;
import com.xwkj.cost.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ContractTypeController {

    @Autowired
    ContractTypeService contractTypeService;

    /**
     * @Description : 获取合同类别列表
     * @methodName : getUserInfoList
     * @param pageUtil :
     * @param contractType :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zt
     */
    @GetMapping("/getPageContractTypeList")
    public ResponseResult getPageContractTypeList(PageUtil pageUtil, ContractType contractType) {
        ResponseResult responseResult = null;
        try {
            PageInfo<ContractType> pageInfo = contractTypeService.getPageContractTypeList(pageUtil, contractType);
            log.info("获取用户信息列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),pageInfo,"获取用户信息列表成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("获取用户信息列表失败");
            responseResult = ResponseResult.failure("获取用户信息列表失败");
        }
        return responseResult;
    }

    /**
     * @Description : 获取合同类别列表
     * @methodName : getContractTypeList
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zt
     */
    @GetMapping("/getContractTypeList")
    public ResponseResult getContractTypeList() {
        ResponseResult responseResult = null;
        try {
            List<ContractType> list = contractTypeService.getContractTypeList();
            log.info("获取合同类别列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"获取合同类别列表成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("获取合同类别列表失败");
            responseResult = ResponseResult.failure("获取合同类别列表失败");
        }
        return responseResult;
    }

    /**
     * @Description : 添加合同类别信息
     * @methodName : addContractType
     * @param ContractType :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zt
     */
    @PostMapping("/addContractType")
    public ResponseResult addContractType(ContractType ContractType){
        ResponseResult responseResult = null;
        try {
            Long id = contractTypeService.addContractType(ContractType);
            log.info("添加合同类别信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),id,"添加合同类别信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("添加合同类别信息失败");
            responseResult = ResponseResult.failure("添加合同类别信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 修改合同类别信息
     * @methodName : updateContractType
     * @param ContractType :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zt
     */
    @PutMapping("/updateContractType")
    public ResponseResult updateContractType(ContractType ContractType) {
        ResponseResult responseResult = null;
        try {
            contractTypeService.updateContractType(ContractType);
            log.info("修改合同类别信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改合同类别信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("修改合同类别信息失败");
            responseResult = ResponseResult.failure("修改合同类别信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 删除合同类别
     * @methodName : deleteContractType
     * @param id :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zt
     */
    @DeleteMapping("/deleteContractType")
    public ResponseResult deleteContractType(Long id) {
        ResponseResult responseResult = null;
        try {
            contractTypeService.deleteContractType(id);
            log.info("删除用户信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除用户信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("删除用户信息失败");
            responseResult = ResponseResult.failure("删除用户信息失败");
        }
        return responseResult;
    }
}
