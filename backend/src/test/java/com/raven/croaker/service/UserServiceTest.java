package com.raven.croaker.service;

import com.raven.croaker.exception.UserAlreadyExistException;
import com.raven.croaker.exception.UserNotFoundException;
import com.raven.croaker.model.User;
import com.raven.croaker.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldAddUserCorrectly() {
        User user = new User("test", "Test", "mail@test.com", "password");
        when(userRepository.save(user)).thenReturn(user);
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

    @Test(expected = UserNotFoundException.class)
    public void shouldThrowExceptionWhenUserByNameNoExists() {
        Mockito.when(userRepository.findByUsername("test")).thenReturn(Optional.empty());
        userService.findByUsername("test");
    }

    @Test(expected = UserNotFoundException.class)
    public void shouldThrowExceptionWhenUserByEmailNoExists() {
        Mockito.when(userRepository.findByEmail("test@test")).thenReturn(Optional.empty());
        userService.findByEmail("test@test");
    }

    @Test(expected = UserAlreadyExistException.class)
    public void shouldThrowExceptionWhenUserExists() {
        User user = new User("test", "Test", "mail@test.com", "password");
        when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.of(user));
        userService.addUser(user);
    }

    @Test(expected = UserNotFoundException.class)
    public void shouldThrowExceptionWhileModifyWhenUserNoExists() {
        String id = "fs$Hgfhs5";
        when(userRepository.findById(id)).thenReturn(Optional.empty());
        userService.modifyUser(new User(), id);
    }
}