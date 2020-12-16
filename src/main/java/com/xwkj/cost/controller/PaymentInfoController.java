package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.PaymentInfo;
import com.xwkj.cost.service.PaymentInfoService;
import com.xwkj.cost.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentInfoController
{
    private static final Logger log = LoggerFactory.getLogger(PaymentInfoController.class);
    @Autowired
    private PaymentInfoService paymentInfoService;

    @PostMapping({"/selectPaymentList"})
    public ResponseResult selectPaymentList(PageUtil pageUtil, PaymentInfo paymentInfo)
    {
        ResponseResult responseResult = null;
        log.info("查询付款条件列表");
        try
        {
            PageInfo<PaymentInfo> paymentInfoPageInfo = this.paymentInfoService.selectPaymentList(pageUtil, paymentInfo);
            log.info("查询付款条件列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), paymentInfoPageInfo, "查询付款条件成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("查询付款条件失败");
            responseResult = ResponseResult.failure("查询付款条件失败");
        }
        return responseResult;
    }

    @PostMapping({"/insertPaymentInfo"})
    public ResponseResult insertPaymentInfo(PaymentInfo paymentInfo)
    {
        log.info("添加付款条件");
        ResponseResult responseResult = null;
        try
        {
            this.paymentInfoService.insertPaymentInfo(paymentInfo);
            log.info("添加付款条件成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), null, "添加付款条件成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("添加付款条件失败");
            responseResult = ResponseResult.failure("添加付款条件失败");
        }
        return responseResult;
    }

    @PostMapping({"/updatePaymentInfo"})
    public ResponseResult updatePaymentInfo(PaymentInfo paymentInfo)
    {
        log.info("修改付款条件");
        ResponseResult responseResult = null;
        try
        {
            this.paymentInfoService.updatePaymentInfo(paymentInfo);
            log.info("修改付款条件成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), null, "修改付款条件成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("修改付款条件失败");
            responseResult = ResponseResult.failure("修改付款条件失败");
        }
        return responseResult;
    }

    @PostMapping({"/findPaymentById"})
    public ResponseResult findPaymentById(Long id)
    {
        log.info("获得该条付款条件的详细信息");
        ResponseResult responseResult = null;
        try
        {
            PaymentInfo paymentInfo = this.paymentInfoService.findPaymentById(id);
            log.info("获得该条付款条件的详细信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), paymentInfo, "获得该条付款条件的详细信息成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("获得该条付款条件的详细信息失败");
            responseResult = ResponseResult.failure("获得该条付款条件的详细信息失败");
        }
        return responseResult;
    }

    @DeleteMapping({"/deletePayment/{id}"})
    public ResponseResult deletePaymentInfo(@PathVariable Long id)
    {
        ResponseResult responseResult = null;
        try
        {
            this.paymentInfoService.deletePaymentInfo(id);
            log.info("删除付款条件成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), null, "删除付款条件成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("删除付款条件失败");
            responseResult = ResponseResult.failure("删除付款条件失败");
        }
        return responseResult;
    }
}
