package com.raven.croaker.service;

import com.raven.croaker.domain.Croak;
import com.raven.croaker.domain.User;

import java.util.Optional;

public interface CroakService {
    Croak save(Croak croak);

    Croak update(Croak croak);

    void delete(Croak croak);

    Optional<Croak> findOne(String id);

    Iterable<Croak> findAll();

    Iterable<Croak> findAllFromUser(String username);
}
