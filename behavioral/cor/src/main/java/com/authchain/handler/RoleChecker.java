package com.authchain.handler;

import com.authchain.model.Request;

public class RoleChecker extends Handler {
    @Override
    public boolean handle(Request request) {
        if (!request.hasAdminRole) {
            System.out.println("User lacks admin role.");
            return false;
        }
        return next == null || next.handle(request);
    }
}
