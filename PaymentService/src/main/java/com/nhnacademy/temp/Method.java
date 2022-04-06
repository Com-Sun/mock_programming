package com.nhnacademy.temp;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Objects;
import java.util.stream.Stream;

import static java.lang.Math.min;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Method {
    RATE() {
        @Override
        long getDiscountAmt(DiscountPolicy discountPolicy, long productAmt) {
            return (long) (productAmt * discountPolicy.getRate());
        }
    },
    AMOUNT() {
        @Override
        long getDiscountAmt(DiscountPolicy discountPolicy, long productAmt) {
            return min(productAmt, discountPolicy.getAmt());
        }
    };

    //        @JsonCreator
    public static Method from(String value) {
        return Stream.of(values())
                     .filter(e -> Objects.equals(e.value(), value))
                     .findAny()
                     .orElse(null);
    }

    //        @JsonValue
    public String value() {
        return name();
    }

    abstract long getDiscountAmt(DiscountPolicy discountPolicy, long productAmt);
}
