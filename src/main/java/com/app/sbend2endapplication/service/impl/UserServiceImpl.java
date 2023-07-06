package com.app.sbend2endapplication.service.impl;

import com.app.sbend2endapplication.registration.RegistrationRequest;
import com.app.sbend2endapplication.repository.UserRepository;
import com.app.sbend2endapplication.service.UserService;
import com.app.sbend2endapplication.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
    @Override
    public User registerUser(RegistrationRequest request) {
        return ;
    }
    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("User Not Found"));
    }
}
