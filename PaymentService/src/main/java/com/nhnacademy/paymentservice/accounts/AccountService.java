package com.nhnacademy.paymentservice.accounts;

import com.nhnacademy.paymentservice.repository.AccountRepository;
import com.nhnacademy.paymentservice.repository.HashMapAccountRepository;
import java.util.Map;

public class AccountService {
    HashMapAccountRepository repository;


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

    public void payment() {

    }

}
