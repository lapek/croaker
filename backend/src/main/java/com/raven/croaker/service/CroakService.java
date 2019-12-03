package com.raven.croaker.service;

import com.raven.croaker.domain.Croak;
import com.raven.croaker.domain.CroakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CroakService {
    private CroakRepository croakRepository;

    @Autowired
    public CroakService(CroakRepository croakRepository) {
        this.croakRepository = croakRepository;
    }

    public Croak save(Croak croak) {
        Date currentTime = new Date();
        croak.setPostDate(currentTime);
        croak.setLastEditDate(currentTime);
        return croakRepository.save(croak);
    }

    public Croak update(Croak croak) {
        Date currentTime = new Date();
        croak.setLastEditDate(currentTime);
        return croakRepository.save(croak);
    }

    public Iterable<Croak> findAllFromUser(String username) {
        return croakRepository.findByUsername(username);
    }

    public void delete(Croak croak) {
        croakRepository.delete(croak);
    }

    public Optional<Croak> findOne(String id) {
        return croakRepository.findById(id);
    }

    public Iterable<Croak> findAll() {
        return croakRepository.findAll();
    }
}
