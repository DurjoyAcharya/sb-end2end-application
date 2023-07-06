package com.app.sbend2endapplication.registration;

import com.app.sbend2endapplication.user.Role;
import lombok.Data;

import java.util.Collection;
//its actually Data Transfer Object Class
@Data
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String userEmail;
    private String password;
    private Collection<Role> roles;
}
