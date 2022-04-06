package com.nhnacademy.paymentservice;

import java.util.HashMap;
import java.util.Map;

public class HashMapAccountRepository
    implements AccountRepository {
    private Map<Long, String> repository = new HashMap<>();

    @Override
    public void insert(Account account) {

    }

    @Override
    public Account findByUsername(String username) {
        return null;
    }
}
