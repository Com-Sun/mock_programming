package com.nhnacademy.paymentservice;

interface AccountRepository {
    void insert(Account account);
    Account findByUsername(String username);
}
