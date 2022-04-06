package com.nhnacademy.paymentservice;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class AccountAvailableTest {
    private AccountService service;
    private AccountRepository repository;


    @BeforeEach
    void setUp() {
        repository = new HashMapAccountRepository();
        service = new AccountService(repository);

    }

    @DisplayName("계정이 없으면 예외 발생.")
    @Test
    void unableIdException () {
        String username = "hyunjin";
        Account account = new Account("marco", "aaa");

        when(repository.findByUsername(username)).thenReturn(account); //조작하는 stubbing 과정



    }
}

