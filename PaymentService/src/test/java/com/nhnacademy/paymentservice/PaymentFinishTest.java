package com.nhnacademy.paymentservice;

import com.nhnacademy.paymentservice.accounts.AccountService;
import com.nhnacademy.paymentservice.repository.AccountRepository;
import org.junit.jupiter.api.*;

public class PaymentFinishTest {
    private AccountService service;
    private AccountRepository repository;

    @BeforeEach
    void setUp() {
        SmsAlert smsAlert = new DummySmsAlert();
        Bill bill = new Bill();
        smsAlert.alert(bill);

    }

    //SMS 알림 발생(Dummy). 만약 알림 발송이 실패해도, 결재는 정상적으로 완료.
}
