package com.authchain.handler;

import com.authchain.model.Request;

public class EmailValidator  extends Handler {

    @Override
    public boolean handle(Request request) {

        if (request.email == null || !request.email.contains("@")) {
            System.out.println("Email is invalid.");
            return false;
        }
        return next == null || next.handle(request);
    }
}
