package com.payment.facade.subsystems;

import com.payment.facade.model.User;
public class AuthService {
    public boolean authenticate(User user) {
        System.out.println("Authenticating " + user.getUsername());
        return user.getToken() != null && !user.getToken().isEmpty();
    }
}
