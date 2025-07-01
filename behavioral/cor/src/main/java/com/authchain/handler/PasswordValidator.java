package com.authchain.handler;

import com.authchain.model.Request;

public class PasswordValidator extends Handler {

    @Override
    public boolean handle(Request request) {

        if (request.password == null || request.password.length() < 8) {
            System.out.println("Password is too short.");
            return false;
        }
        return next == null || next.handle(request);
    }
}
