package com.nhnacademy.paymentservice;

public class DummySmsAlert implements SmsAlert {
    @Override
    public void alert(Bill bill) {
        System.out.println("결제가 완료되었습니다.");
    }
}
