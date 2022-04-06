package com.nhnacademy.paymentservice.paymentservice;

import com.nhnacademy.paymentservice.NotFoundAccountException;
import com.nhnacademy.paymentservice.Receipt;
import com.nhnacademy.paymentservice.accounts.Account;
import com.nhnacademy.paymentservice.repository.AccountRepository;

public class PaymentService {
    private final AccountRepository repository;

    public PaymentService(AccountRepository repository) {
        this.repository = repository;
    }

    public Receipt pay(long amount, String accountId) {
        //어떤 작업이 이루어질까
        //페이먼트 서비스 안에 멤버변수로 어카운트객체가 있어야함

        // Account 가 없으면 / 예외 발생
        Account account = repository.findByAccountId(accountId);

        if (account == null) {
            throw new NotFoundAccountException("Account has not found");
        }
        return null;
    }
}
