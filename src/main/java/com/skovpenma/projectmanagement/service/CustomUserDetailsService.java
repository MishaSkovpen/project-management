package com.skovpenma.projectmanagement.service;

import com.skovpenma.projectmanagement.model.User;
import com.skovpenma.projectmanagement.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        User existingUser = user.get();
        return org.springframework.security.core.userdetails.User.builder()
                .username(existingUser.getUsername())
                .password(existingUser.getPassword())
                .roles("USER")
                .build();
    }
}
