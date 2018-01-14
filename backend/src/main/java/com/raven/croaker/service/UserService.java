package com.raven.croaker.service;

import com.raven.croaker.domain.User;

import java.util.Optional;

public interface UserService {
    User save(User user);
    User findByUsername(String username);
    Iterable<User> findAll();
}
