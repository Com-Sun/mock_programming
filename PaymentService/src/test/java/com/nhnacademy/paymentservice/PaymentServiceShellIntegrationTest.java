package com.nhnacademy.paymentservice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentServiceShellIntegrationTest {
    // SUT
    private PaymentServiceShell service;
    // DOC
    private DiscountPolicyRepository discountPolicyRepository;

    @BeforeEach
    void setUp() {
        discountPolicyRepository = new JsonDiscountPolicyRepository();
        service = new PaymentServiceShell(discountPolicyRepository);

        initPolices();
    }

    @AfterEach
    void tearDown() {
        clearPolices();
    }

    private void clearPolices() {
        discountPolicyRepository.deleteByCode("FANCAFE");
    }

    private void initPolices() {
        discountPolicyRepository.insert(DiscountPolicy.amount("FANCAFE", 1_000L));
    }

    @DisplayName("대부분의 상황에서 할인 금액을 알 수 있는 테스트.(코드+상품가격 조합)")
    @ParameterizedTest(name = "할인코드: {0}, 상품가: {1}, 할인금액: {2}")
    @CsvFileSource(resources = "discount-conditions.csv", numLinesToSkip = 1)
    void getDiscount(String discountCode, long productAmt, long discountAmt) {
        // when
        Discount discount = service.getDiscount(productAmt, discountCode);
        // then
        assertThat(discount.getAmount()).isEqualTo(discountAmt);
    }

    @Test
    void payment() {
    }


}