package com.eomaxl.traderappbackend.service;

import jakarta.servlet.http.HttpServletRequest;

public interface AuthService {
    AuthResponse login(LoginRequest request);
    void logout(HttpServletRequest request);
}
