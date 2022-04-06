package com.nhnacademy.paymentservice.accounts;

import com.nhnacademy.paymentservice.exception.LoginFailedException;
import com.nhnacademy.paymentservice.exception.paymentFailedException;
import com.nhnacademy.paymentservice.repository.AccountRepository;
import com.nhnacademy.paymentservice.repository.HashMapAccountRepository;

public class AccountService {
    HashMapAccountRepository repository;

    float rate = 0.01f;


    public AccountService(AccountRepository repository) {
        this.repository = (HashMapAccountRepository) repository;

    }

    public Account login(String username, String password) {
        Account found = repository.findByUsername(username);
        if (found == null) {
            throw new LoginFailedException();
        }
    return null;
    }

    public void payment(int amount, Account account) {
        if(account == null){
            throw new paymentFailedException("해당하는 account가 존재하지 않습니다.");
        }

        if(amount > account.getMoney()){
            throw new paymentFailedException("잔액이 부족합니다.");
        }

        if(amount < 0) {
            throw new paymentFailedException("결제 금액은 음수가 될 수 없습니다.");
        }

        int money = account.getMoney();
        money -= amount;
        account.setMoney(money);

        account.setPoint(accumulatePoint(amount));


    }

    private int accumulatePoint(int amount) {
        return (int) (amount * rate);
    }

}
