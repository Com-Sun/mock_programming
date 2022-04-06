package com.nhnacademy.paymentservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JsonDiscountPolicyRepositoryTest {
    // SUT
    JsonDiscountPolicyRepository repository;

    @BeforeEach
    void setUp() {
        repository = new JsonDiscountPolicyRepository();
    }

    @Test
    void insertAndFindByCode() {
        String code = "TEN_PERCENT";
        DiscountPolicy policy = DiscountPolicy.rate(code, 0.1f);
        repository.insert(policy);

        DiscountPolicy result = repository.findByCode(code);

        assertThat(result)
                .usingRecursiveComparison()
                .isEqualTo(policy);
    }

    @Test
    void deleteByCode() {
        String code = "TEN_PERCENT";
        DiscountPolicy policy = DiscountPolicy.rate(code, 0.1f);
        repository.insert(policy);

        repository.deleteByCode(code);

        assertThatThrownBy(() -> repository.findByCode(code))
                .isInstanceOf(RepositoryFailException.class)
                .hasMessageContaining("Failed load");
    }

    @Disabled
    @Test
    void findByCodes() {
    }
}