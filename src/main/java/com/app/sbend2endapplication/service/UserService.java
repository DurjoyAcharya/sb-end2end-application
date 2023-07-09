package com.app.sbend2endapplication.service;

import com.app.sbend2endapplication.registration.RegistrationRequest;
import com.app.sbend2endapplication.user.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    List<User> getAllUsers();
    User registerUser(RegistrationRequest request);

    Optional<User> findByUserEmail(String userEmail);



}
