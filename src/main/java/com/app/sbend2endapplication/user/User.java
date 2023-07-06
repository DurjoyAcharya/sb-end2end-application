package com.app.sbend2endapplication.user;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.Collection;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String userEmail;
    private String password;
    private boolean isEnable=false;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<Role> roles;
}
