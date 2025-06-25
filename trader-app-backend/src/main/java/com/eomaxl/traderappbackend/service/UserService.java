package com.eomaxl.traderappbackend.service;

public interface UserService {
    UserDto register(RegisterRequest request);
    UserDto getProfile(String username);
    void changePassword(String username, String oldPass, String newPass);
}
