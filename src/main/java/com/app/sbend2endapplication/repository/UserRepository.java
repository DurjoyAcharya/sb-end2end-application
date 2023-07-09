package com.app.sbend2endapplication.repository;

import com.app.sbend2endapplication.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByuserEmail(String userEmail);
}
