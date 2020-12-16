package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.ProjectType;
import com.xwkj.cost.service.ProjectTypeService;
import com.xwkj.cost.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: investigation_cost
 * @description: 合同项目类型控制层
 * @author: 张永辉
 * @create: 2020-07-15 14:23
 **/
@RestController
@Slf4j
public class ProjectTypeController {

    @Autowired
    private ProjectTypeService projectTypeService;

    /**
     * @Description : 获取合同工程类型列表
     * @methodName : getProjectTypeList
     * @param projectType :
     * @param pageUtil :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @GetMapping("/getProjectTypeList")
    public ResponseResult getProjectTypeList(ProjectType projectType, PageUtil pageUtil) {
        ResponseResult responseResult = null;
        try {
            PageInfo<ProjectType> list = projectTypeService.getProjectTypeList(projectType, pageUtil);
            log.info("获取合同工程类型列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"获取合同工程类型列表成功");
        } catch(Exception e){
            log.error("获取合同工程类型列表失败", e);
            responseResult = ResponseResult.failure("获取合同工程类型列表失败");
        }
        return responseResult;
    }

    /**
     * @Description : 添加合同工程类型
     * @methodName : addProjectType
     * @param projectType :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @PostMapping("/addProjectType")
    public ResponseResult addProjectType(ProjectType projectType) {
        ResponseResult responseResult = null;
        try {
            projectTypeService.addProjectType(projectType);
            log.info("添加合同工程类型成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"添加合同工程类型成功");
        } catch(Exception e){
            log.error("添加合同工程类型失败", e);
            responseResult = ResponseResult.failure("添加合同工程类型失败");
        }
        return responseResult;
    }

    /**
     * @Description : 修改合同工程类型
     * @methodName : updateProjectType
     * @param projectType :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @PutMapping("/updateProjectType")
    public ResponseResult updateProjectType(ProjectType projectType) {
        ResponseResult responseResult = null;
        try {
            projectTypeService.updateProjectType(projectType);
            log.info("修改合同工程类型成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改合同工程类型成功");
        } catch(Exception e){
            log.error("修改合同工程类型失败", e);
            responseResult = ResponseResult.failure("修改合同工程类型失败");
        }
        return responseResult;
    }

    /**
     * @Description : 删除合同工程类型
     * @methodName : deleteProjectType
     * @param id :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @DeleteMapping("/deleteProjectType/{id}")
    public ResponseResult deleteProjectType(@PathVariable("id") Long id) {
        ResponseResult responseResult = null;
        try {
            projectTypeService.deleteProjectType(id);
            log.info("删除合同工程类型成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除合同工程类型成功");
        } catch(Exception e){
            log.error("删除合同工程类型失败", e);
            responseResult = ResponseResult.failure("删除合同工程类型失败");
        }
        return responseResult;
    }

    @PostMapping({"/selectProjectTypeList"})
    public ResponseResult selectProjectTypeList()
    {
        ResponseResult responseResult = null;
        try
        {
            List<ProjectType> list = this.projectTypeService.selectProjectTypeList();
            log.info("获取工程类别列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), list, "获取工程类别列表成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("获取工程类别列表失败");
            responseResult = ResponseResult.failure("获取工程类别列表失败");
        }
        return responseResult;
    }
}
