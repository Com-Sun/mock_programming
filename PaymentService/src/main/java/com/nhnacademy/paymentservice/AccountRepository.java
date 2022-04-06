package com.nhnacademy.paymentservice;

interface AccountRepository {
    Account findByUsername(String username);

}
