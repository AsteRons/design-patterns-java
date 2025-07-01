package com.authchain.handler;

import com.authchain.model.Request;

public class UserExistenceChecker extends Handler {
    @Override
    public boolean handle(Request request) {
        if (!request.userExists) {
            System.out.println("User does not exist.");
            return false;
        }
        return next == null || next.handle(request);
    }
}
