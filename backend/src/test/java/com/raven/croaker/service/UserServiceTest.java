package com.raven.croaker.service;

import com.raven.croaker.exception.UserAlreadyExistException;
import com.raven.croaker.exception.UserNotFoundException;
import com.raven.croaker.model.Role;
import com.raven.croaker.model.User;
import com.raven.croaker.repository.RoleRepository;
import com.raven.croaker.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.raven.croaker.model.Roles.USER;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldAddUserCorrectly() {
        User user = new User("test", "Test", "mail@test.com", "password");
        when(userRepository.save(user)).thenReturn(user);
        when(roleRepository.findByRoleName(USER.getName())).thenReturn(Optional.of(new Role()));
        when(passwordEncoder.encode(user.getPassword())).thenReturn("Encoded password");
        User returnedUser = userService.addUser(user);
        assertNotNull(returnedUser);
        assertEquals(user.getUsername(), returnedUser.getUsername());
        assertEquals(user.getEmail(), returnedUser.getEmail());
    }

    @Test
    public void shouldReturnEmptyListWhenNoUsers() {
        when(userRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(userService.getAllUsers().isEmpty());
    }

    @Test
    public void shouldReturnListWhenUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("test", "Test", "mail@test.com", "password"));
        when(userRepository.findAll()).thenReturn(users);
        assertFalse(userService.getAllUsers().isEmpty());
    }

    @Test
    public void shouldThrowExceptionWhenUserByNameNoExists() {
        Mockito.when(userRepository.findByUsername("test")).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> userService.findByUsername("test"));
    }

    @Test
    public void shouldThrowExceptionWhenUserByEmailNoExists() {
        Mockito.when(userRepository.findByEmail("test@test")).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> userService.findByEmail("test@test"));
    }

    @Test
    public void shouldThrowExceptionWhenUserExists() {
        User user = new User("test", "Test", "mail@test.com", "password");
        when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.of(user));
        assertThrows(UserAlreadyExistException.class, () -> userService.addUser(user));
    }

    @Test
    public void shouldThrowExceptionWhileModifyWhenUserNoExists() {
        String id = "fs$Hgfhs5";
        when(userRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> userService.modifyUser(new User(), id));
    }
}