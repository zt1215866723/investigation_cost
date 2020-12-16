package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.mapper.PaymentInfoMapperManual;
import com.xwkj.cost.mapper.auto.PaymentInfoMapper;
import com.xwkj.cost.model.PaymentInfo;
import com.xwkj.cost.service.PaymentInfoService;
import com.xwkj.cost.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentInfoServiceImpl implements PaymentInfoService {
    @Autowired
    private PaymentInfoMapper paymentInfoMapper;
    @Autowired
    private PaymentInfoMapperManual paymentInfoMapperManual;

    public PageInfo<PaymentInfo> selectPaymentList(PageUtil pageUtil, PaymentInfo paymentInfo) {
        PageHelper.startPage(pageUtil.getPage().intValue(), pageUtil.getLimit().intValue());
        List<PaymentInfo> list = this.paymentInfoMapperManual.selectPaymentList(paymentInfo);
        return new PageInfo(list);
    }

    public void insertPaymentInfo(PaymentInfo paymentInfo) {
        paymentInfo.setStatus(Integer.valueOf(0));
        this.paymentInfoMapper.insertSelective(paymentInfo);
    }

    public void updatePaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfoMapper.updateByPrimaryKeySelective(paymentInfo);
    }

    public void deletePaymentInfo(Long id) {
        this.paymentInfoMapper.updateByPrimaryKeySelective(new PaymentInfo().setId(id).setStatus(Integer.valueOf(1)));
    }

    public PaymentInfo findPaymentById(Long id) {
        return this.paymentInfoMapper.selectByPrimaryKey(id);
    }
}
