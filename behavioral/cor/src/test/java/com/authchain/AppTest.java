package com.authchain;


import com.authchain.handler.Handler;
import com.authchain.model.Request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.authchain.handler.*;

class AppTest {

    private Handler handlerChain;

    @BeforeEach
    void setUp() {
        handlerChain = new EmailValidator();
        handlerChain.setNext(new PasswordValidator())
                .setNext(new UserExistenceChecker())
                .setNext(new RoleChecker());
    }


    @Test
    void testValidRequestPassesAllChecks() {
        Request request = new Request("john@example.com", "superSecret", true, true);
        assertTrue(handlerChain.handle(request));
    }

    @Test
    void testInvalidEmailFails() {
        Request request = new Request("invalid-email", "superSecret", true, true);
        assertFalse(handlerChain.handle(request));
    }

    @Test
    void testShortPasswordFails() {
        Request request = new Request("john@example.com", "123", true, true);
        assertFalse(handlerChain.handle(request));
    }

    @Test
    void testNonExistingUserFails() {
        Request request = new Request("john@example.com", "superSecret", false, true);
        assertFalse(handlerChain.handle(request));
    }

    @Test
    void testMissingAdminRoleFails() {
        Request request = new Request("john@example.com", "superSecret", true, false);
        assertFalse(handlerChain.handle(request));
    }

}