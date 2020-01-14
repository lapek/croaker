package com.raven.croaker.service;

import com.raven.croaker.exception.UserAlreadyExistException;
import com.raven.croaker.exception.UserCreationErrorException;
import com.raven.croaker.exception.UserNotFoundException;
import com.raven.croaker.model.Role;
import com.raven.croaker.model.User;
import com.raven.croaker.repository.RoleRepository;
import com.raven.croaker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.raven.croaker.model.Roles.USER;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Add new user with role "USER".
     * If user already exists throw {@link UserAlreadyExistException}.
     *
     * @param user user to add
     * @return added user
     */
    public User addUser(User user) {
        Optional<User> userByName = getUserByName(user.getUsername());
        if (userByName.isPresent())
            throw new UserAlreadyExistException("User with name " + user.getUsername() + " already exists.");

        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        final String roleToSearch = USER.getName();
        Optional<Role> role = roleRepository.findByRoleName(roleToSearch);
        if (!role.isPresent())
            throw new UserCreationErrorException("Role '" + roleToSearch + "' doesn't exist.");

        Set<Role> roles = new HashSet<>();
        roles.add(role.get());
        user.setRoles(roles);

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
