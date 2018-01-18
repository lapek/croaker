package com.raven.croaker.service;

import com.raven.croaker.domain.User;

public interface UserService {
    User save(User user);

    User findByUsername(String username);

    User findByEmail(String email);

    Iterable<User> findAll();
}
