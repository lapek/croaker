package com.raven.croaker.service;

import com.raven.croaker.domain.User;

public interface UserService {
    User save(User user);
    Iterable<User> findAll();
}
