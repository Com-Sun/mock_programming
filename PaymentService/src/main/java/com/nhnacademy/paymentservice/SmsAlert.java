package com.nhnacademy.paymentservice;

import com.nhnacademy.paymentservice.accounts.Account;

public interface SmsAlert {
    void alert(Bill bill);
}
