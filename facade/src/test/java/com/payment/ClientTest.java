package com.payment;

import com.payment.facade.PaymentFacade;
import com.payment.facade.model.User;
import com.payment.facade.model.PaymentDetails;
import com.payment.facade.subsystems.AuthService;
import com.payment.facade.subsystems.BankService;
import com.payment.facade.subsystems.LoggerService;
import com.payment.facade.subsystems.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class ClientTest {

    private AuthService authService;
    private BankService bankService;
    private PaymentService paymentService;
    private LoggerService loggerService;
    private PaymentFacade facade;

    @BeforeEach
    void setUp() {
        authService = mock(AuthService.class);
        bankService = mock(BankService.class);
        paymentService = mock(PaymentService.class);
        loggerService = mock(LoggerService.class);


        facade = new PaymentFacade(authService, bankService, paymentService, loggerService);
    }

    @Test
    void shouldMakePaymentWhenAllChecksPass() {
        User user = new User("jan", "token123");
        PaymentDetails payment = new PaymentDetails("ACC1", "ACC2", 100.0);

        when(authService.authenticate(user)).thenReturn(true);
        when(bankService.hasSufficientFunds(payment)).thenReturn(true);

        facade.makePayment(user, payment);

        verify(authService).authenticate(user);
        verify(bankService).hasSufficientFunds(payment);
        verify(paymentService).transfer(payment);
        verify(loggerService, times(2)).log(anyString()); // "start" i "completed"
    }

    @Test
    void shouldThrowExceptionWhenUserNotAuthenticated() {
        User user = new User("jan", "");
        PaymentDetails payment = new PaymentDetails("ACC1", "ACC2", 100.0);

        when(authService.authenticate(user)).thenReturn(false);

        SecurityException ex = assertThrows(SecurityException.class, () ->
                facade.makePayment(user, payment)
        );

        assertEquals("User not authenticated", ex.getMessage());
        verify(loggerService).log("Authentication failed");
        verifyNoInteractions(bankService);
        verifyNoInteractions(paymentService);
    }

    @Test
    void shouldThrowExceptionWhenInsufficientFunds() {
        User user = new User("jan", "token123");
        PaymentDetails payment = new PaymentDetails("ACC1", "ACC2", 9999.0);

        when(authService.authenticate(user)).thenReturn(true);
        when(bankService.hasSufficientFunds(payment)).thenReturn(false);

        IllegalStateException ex = assertThrows(IllegalStateException.class, () ->
                facade.makePayment(user, payment)
        );

        assertEquals("Not enough funds", ex.getMessage());
        verify(loggerService).log("Insufficient funds");
        verifyNoMoreInteractions(paymentService);
    }

}