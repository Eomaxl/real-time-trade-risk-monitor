package com.eomaxl.traderappbackend.service.impl;

import com.eomaxl.traderappbackend.entity.auth.User;
import com.eomaxl.traderappbackend.entity.auth.UserStatus;
import com.eomaxl.traderappbackend.repository.RoleRepository;
import com.eomaxl.traderappbackend.repository.UserRepository;
import com.eomaxl.traderappbackend.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public UserDto register(RegisterRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setRoles(Set.of(roleRepository.findByRoleName("TRADER").orElseThrow()));
        user.setStatus(UserStatus.ACTIVE);
        userRepository.save(user);
        return UserDto.from(user);
    }

    @Override
    public UserDto getProfile(String username){
        User user = userRepository.findByUsername(username).orElseThrow();
        return UserDto.from(user);
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword){
        User user = userRepository.findByUsername(username).orElseThrow();
        if (!passwordEncoder.matches(oldPassword, user.getPasswordHash())){
            throw new RuntimeException("Old password mismatch");
        }
        user.setPasswordHash(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
}
