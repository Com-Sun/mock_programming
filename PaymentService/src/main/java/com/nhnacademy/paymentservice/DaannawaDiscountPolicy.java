package com.nhnacademy.paymentservice;

public class DaannawaDiscountPolicy implements Discountable {
    @Override
    public long getDiscountAmt(long originAmt) {
        return (long) (originAmt * 0.15);
    }
}
