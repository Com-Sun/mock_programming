package com.nhnacademy.paymentservice.repository;

import com.nhnacademy.paymentservice.accounts.Account;

public interface AccountRepository {
    void insert(Account account);
    Account findByUsername(String username);
}
