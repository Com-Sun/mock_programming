package com.nhnacademy.paymentservice;

import static org.mockito.Mockito.*;

import com.nhnacademy.paymentservice.accounts.Account;
import com.nhnacademy.paymentservice.accounts.AccountService;
import com.nhnacademy.paymentservice.accounts.LoginFailedException;
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
        Account account = new Account("marco", "aaa", 1);

        when(repository.findByUsername(username)).thenReturn(null); //조작하는 stubbing 과정

        assertThatThrownBy(() -> service.login(username, "aaa"))
            .isInstanceOf(LoginFailedException.class);
    }

    @DisplayName("결제는 계정에 의존.")
    @Test
    void paymentDependsAccount() {
        Account account = new Account("marco2", "aaa", 2);

        when(repository.findByUsername("aaa")).thenReturn(null);

        Account result =

        assertThatThrownBy(() -> service.payment())
            .isInstanceOf(paymentFailedException.class);
    }
}// account가 결제를 한다. this를 던짐

