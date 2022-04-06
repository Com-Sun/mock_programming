package com.nhnacademy.temp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import static java.lang.Math.min;

public class DiscountPolicy implements Discountable {
    private String code;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Method method;
    private float rate;
    private long amt;

    @JsonCreator
    private DiscountPolicy(
            @JsonProperty("code") String code,
            @JsonProperty("method") Method method,
            @JsonProperty("rate") float rate,
            @JsonProperty("amt") long amt) {
        if (rate < 0f) {
            throw new IllegalArgumentException("rate must be positive number");
        }
        if (amt < 0L) {
            throw new IllegalArgumentException("amt must be positive number");
        }
        this.code = code;
        this.method = method;
        this.rate = rate;
        this.amt = amt;
    }

    public static DiscountPolicy rate(String code, float rate) {
        return new DiscountPolicy(code, Method.RATE, rate, 0L);
    }

    public static DiscountPolicy amount(String code, long amount) {
        return new DiscountPolicy(code, Method.AMOUNT, 0f, amount);
    }

    public String getCode() {
        return code;
    }

    public float getRate() {
        return rate;
    }

    public long getAmt() {
        return amt;
    }

    @Override
    public long getDiscountAmt(long productAmt) {
        return method.getDiscountAmt(this, productAmt);
    }

    @Override
    public String toString() {
        return "DiscountPolicy{" +
               "code='" + code + '\'' +
               ", method=" + method +
               ", rate=" + rate +
               ", amt=" + amt +
               '}';
    }
}
