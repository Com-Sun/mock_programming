package com.nhnacademy.paymentservice;

public interface DiscounterFactory {
    Discountable getDiscounter(String discountName);
}

