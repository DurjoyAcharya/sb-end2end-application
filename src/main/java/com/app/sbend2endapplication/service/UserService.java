package com.app.sbend2endapplication.service;

import com.app.sbend2endapplication.registration.RegistrationRequest;
import com.app.sbend2endapplication.user.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();
    User registerUser(RegistrationRequest request);

    User findByEmail(String email);



}
