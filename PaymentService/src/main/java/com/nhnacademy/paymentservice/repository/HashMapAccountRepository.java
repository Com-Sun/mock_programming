package com.nhnacademy.paymentservice.repository;

import com.nhnacademy.paymentservice.accounts.Account;
import java.util.HashMap;
import java.util.Map;

public class HashMapAccountRepository  implements AccountRepository {
    HashMap<Long, Account> source = new HashMap<>();

    @Override
    public void insert(Account account) {
        source.put(account.getId(), account);
    }

    @Override
    public Account findByUsername(String username) {
        return null;
    }
}
