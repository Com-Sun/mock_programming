package com.nhnacademy.paymentservice;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.nhnacademy.paymentservice.accounts.Account;
import com.nhnacademy.paymentservice.exception.LoginFailedException;
import com.nhnacademy.paymentservice.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentServiceTest {
    private AccountRepository repository;
    private PaymentService paymentService;

    // 목을하면 해쉬맵이 필요없다.
    @BeforeEach
    void setUp() {
        repository = mock(AccountRepository.class);
        paymentService = new PaymentService(repository);
    }

    @DisplayName("계정이 없으면 예외 발생.")
    @Test
    void pay_unableIdException () {
        // 그러면 pay 를 할 때 가장 처음으로 Account 를 저장하고 있는 저장소를 확인해본다.
        // 내가 알고 있는 단서는 accountId 로 -> "계정"(Account)

        // 고객의 계정(Account) 는 이미 존재한다고 가정
        String accountId = "hyunjin";
        Account account = new Account(accountId);
        when(repository.findByAccountId(accountId)).thenReturn(account); //조작하는 stubbing 과정

        // 결재(PaymentService) 는 계정(AccountRepository) 에 의존함?

        // account 변수가 null 이면 throw new XXXException() <- pay 메서드에서 하고 있니?
        assertThatThrownBy(() -> paymentService.pay(1_000L, "jh"))
            .isInstanceOf(NotFoundAccountException.class)
            .hasMessageContaining("not found");

//        verify(paymentService.pay(), times(1))
    }
}
