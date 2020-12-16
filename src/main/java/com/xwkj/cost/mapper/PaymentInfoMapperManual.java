package com.xwkj.cost.mapper;

import com.xwkj.cost.model.PaymentInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentInfoMapperManual
{
    List<PaymentInfo> selectPaymentList(PaymentInfo paramPaymentInfo);
}
