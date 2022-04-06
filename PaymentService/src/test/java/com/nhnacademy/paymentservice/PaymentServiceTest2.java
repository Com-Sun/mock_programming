package com.nhnacademy.paymentservice;

import static org.mockito.Mockito.mock;

import com.nhnacademy.paymentservice.accounts.Account;
import com.nhnacademy.paymentservice.repository.AccountRepository;
//import com.nhnacademy.paymentservice.repository.HashMapAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest2 {
    private PaymentService paymentService;
    private AccountRepository repository;

//    @BeforeEach
//    void setUp() {
//        // 결제할 떄 무엇이 필요할지
//        paymentService = new PaymentService();
//        repository = mock(HashMapAccountRepository.class);
//    }

    @DisplayName("결제 테스트입니다.")
    @Test
    void paymentTest() {
//        Account account = new Account("marco", "aaa", 1);
//        int price = 10000;
//        paymentService.pay(account, price);


    }
}
