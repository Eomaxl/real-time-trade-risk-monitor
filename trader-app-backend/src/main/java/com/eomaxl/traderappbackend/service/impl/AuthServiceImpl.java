package com.eomaxl.traderappbackend.service.impl;

import com.eomaxl.traderappbackend.entity.auth.User;
import com.eomaxl.traderappbackend.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request){
        // Authentication with spring security
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(()->new UsernameNotFoundException("User not found"));
        String token = jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
        return new AuthResponse(token, UserDto.from(user));
    }

    public void logout(HttpServletRequest request){
        // For JWT: client just deletes token; or blacklist if you need
    }
}
