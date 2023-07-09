package com.app.sbend2endapplication.service.impl;

import com.app.sbend2endapplication.repository.UserRepository;
import com.app.sbend2endapplication.security.EndToEndUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EndToEndUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return userRepository.findByuserEmail(userEmail)
                .map(EndToEndUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("User Not Found"));
    }
}
