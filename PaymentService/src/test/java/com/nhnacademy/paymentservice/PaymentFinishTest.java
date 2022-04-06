//package com.nhnacademy.paymentservice;
//
//import com.nhnacademy.paymentservice.accounts.Account;
//import com.nhnacademy.paymentservice.accounts.AccountService;
//import com.nhnacademy.paymentservice.repository.AccountRepository;
////import com.nhnacademy.paymentservice.repository.HashMapAccountRepository;
////import org.junit.jupiter.api.*;
//
//import static org.mockito.Mockito.*;
//
//public class PaymentFinishTest {
//    private AccountService service;
//    private AccountRepository repository;
//
//    @BeforeEach
//    void setUp() {
//        repository = new HashMapAccountRepository();
//        service = mock(AccountService.class);
//
//    }
//
//    @DisplayName("SMS 알람 발생")
//    @Test
//    void smsAlert() {
//        Account account = new Account("marco", "11122", 1, 10000);
//        SmsAlert smsAlert = new DummySmsAlert();
//        Bill bill = new Bill(3000, account);
//        smsAlert.alert(bill);
//        service.paymentAlert(bill);
//        verify(service).paymentAlert(bill);
//    }
//
//    @DisplayName("결제시 적립금을 사용할 수 있음")
//    @Test
//    void usePointWhenPayment() {
////        service.payWithPoint(bill);
//    }
//
//
//    //SMS 알림 발생(Dummy). 만약 알림 발송이 실패해도, 결재는 정상적으로 완료.
//}
