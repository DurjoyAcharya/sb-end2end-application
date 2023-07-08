package com.app.sbend2endapplication.service.impl;

import com.app.sbend2endapplication.registration.RegistrationRequest;
import com.app.sbend2endapplication.repository.UserRepository;
import com.app.sbend2endapplication.service.UserService;
import com.app.sbend2endapplication.user.Role;
import com.app.sbend2endapplication.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
    @Override
    public User registerUser(RegistrationRequest request) {
        var user=new User(request.getFirstName(), request.getLastName(), request.getUserEmail(),
                passwordEncoder.encode(request.getPassword()),
                List.of(new Role("ROLE_USER")));
         repository.save(user);
        return user;
    }
    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("User Not Found"));
    }
}
