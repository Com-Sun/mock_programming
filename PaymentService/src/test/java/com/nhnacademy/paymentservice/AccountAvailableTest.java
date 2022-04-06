package com.nhnacademy.paymentservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountAvailableTest {

    @BeforeEach
    void setUp() {
        repository = mock(AccountRepository.class);
        service = new AccountService(repository);

    }

    @DisplayName("계정이 없으면 예외 발생.")
    @Test
    void unableIdException () {

        when(repository.findByUsername(username)).thenReturn(account); //조작하는 stubbing 과정

        Account result = service.login(username, password);

    }
}

