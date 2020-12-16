package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.PaymentInfo;
import com.xwkj.cost.util.PageUtil;

public  interface PaymentInfoService
{
    PageInfo<PaymentInfo> selectPaymentList(PageUtil paramPageUtil, PaymentInfo paramPaymentInfo);

    void insertPaymentInfo(PaymentInfo paramPaymentInfo);

    void updatePaymentInfo(PaymentInfo paramPaymentInfo);

    void deletePaymentInfo(Long paramLong);

    PaymentInfo findPaymentById(Long paramLong);
}
