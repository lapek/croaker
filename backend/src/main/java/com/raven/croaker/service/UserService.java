package com.raven.croaker.service;

import com.raven.croaker.domain.User;
import com.raven.croaker.domain.UserRepository;
import com.raven.croaker.exception.UserAlreadyExistException;
import com.raven.croaker.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Add new user. If user already exists throw {@link UserAlreadyExistException}.
     *
     * @param user user to add
     * @return added user
     */
    public User addUser(User user) {
        Optional<User> userByName = getUserByName(user.getUsername());
        if (userByName.isPresent())
            throw new UserAlreadyExistException("User with name " + user.getUsername() + " already exists.");

        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return getUserByName(username).orElseThrow(() -> new UserNotFoundException("User with username " + username + " not found."));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found."));
    }

    public void modifyUser(User user, String id) {
        Optional<User> userById = getUserById(id);
        if (!userById.isPresent())
            throw new UserNotFoundException("User with id " + id + " not found.");

        user.setId(id);
        userRepository.save(user);
    }

    /**
     * Find all users and return them as List.
     *
     * @return list of users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public void deleteUser(String id) {
        getUserById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found."));
        userRepository.deleteById(id);
    }

    private Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    private Optional<User> getUserByName(String name) {
        return userRepository.findByUsername(name);
    }
}
