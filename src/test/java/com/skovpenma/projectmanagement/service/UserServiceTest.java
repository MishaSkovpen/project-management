package com.skovpenma.projectmanagement.service;

import com.skovpenma.projectmanagement.model.User;
import com.skovpenma.projectmanagement.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    public void testRegisterUser_Success() {
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("testuser@example.com");
        user.setPassword("password");

        /*
        when(userRepository.findByUsername(user.getUsername())).thenReturn(null);
        when(userRepository.findByEmail(user.getEmail())).thenReturn(null);
        */
        when(passwordEncoder.encode(user.getPassword())).thenReturn("encodedPassword");


        userService.registerUser(user);

        verify(userRepository, times(1)).save(user);
        assertThat(user.getPassword()).isEqualTo("encodedPassword");
    }

    /*
    @Test
    public void testRegisterUser_UserAlreadyExists() {
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("testuser@example.com");
        user.setPassword("password");

        User newUser = userService.registerUser(user);
        // when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.of(user));


        assertThatThrownBy(() -> userService.registerUser(user))
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("User already exists|Користувач вже існує");
    }
    */

}


