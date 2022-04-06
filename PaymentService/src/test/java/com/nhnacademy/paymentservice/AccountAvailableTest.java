package com.nhnacademy.paymentservice;

import static org.mockito.Mockito.*;

import com.nhnacademy.paymentservice.accounts.Account;
import com.nhnacademy.paymentservice.accounts.AccountService;
import com.nhnacademy.paymentservice.exception.LoginFailedException;
import com.nhnacademy.paymentservice.exception.paymentFailedException;
import com.nhnacademy.paymentservice.repository.AccountRepository;
import com.nhnacademy.paymentservice.repository.HashMapAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class AccountAvailableTest {
    private AccountService service;
    private AccountRepository repository;


    @BeforeEach
    void setUp() {
        repository = mock(HashMapAccountRepository.class);
        service = new AccountService(repository);

    }

    @DisplayName("계정이 없으면 예외 발생.")
    @Test
    void unableIdException () {
        String username = "hyunjin";
        Account account = new Account("marco", "aaa", 1, 10000);

        when(repository.findByUsername(username)).thenReturn(null); //조작하는 stubbing 과정

        assertThatThrownBy(() -> service.login(username, "aaa"))
            .isInstanceOf(LoginFailedException.class);
    }

    @DisplayName("결제는 계정에 의존.")
    @Test
    void paymentDependsAccount() {
        Account account = null;
        int amount = 10000;

//        when(repository.findByUsername("aaa")).thenReturn(null);

        assertThatThrownBy(() -> service.payment(amount, account))
            .isInstanceOf(paymentFailedException.class)
            .hasMessageContaining("해당하는 account가 존재하지 않습니다.");
    }
    @DisplayName("결제 처리")
    @Test
    void checkPayment(){
        String username = "marco";
        String password = "12344";
        long id = 3;
        int money = 10000;

        Account account = new Account(username, password, id, money);

        assertThatThrownBy(() -> service.payment(20000, account))
            .isInstanceOf(paymentFailedException.class);

        assertThatThrownBy(() -> service.payment(-10000, account))
            .isInstanceOf(paymentFailedException.class);

        service.payment(5000, account);
        assertThat(account.getMoney()).isEqualTo(money - 5000);


    }

    @DisplayName("포인트 적립")
    @Test
    void pointAccumulation() {
        float rate = 0.01f;
        Account account = new Account("marco", "123123", 3, 10000);

        service.payment(5000, account);
        assertThat(account.getPoint()).isEqualsTo(5000 * rate);


    }

    @DisplayName("고객 계정 포인트 확인")
    @Test
    void acconutPointCheck() {

    }


}// account가 결제를 한다. this를 던짐


