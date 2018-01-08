package com.raven.croaker.service.internal;

import com.raven.croaker.domain.Croak;
import com.raven.croaker.domain.CroakRepository;
import com.raven.croaker.service.CroakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CroakServiceImpl implements CroakService{

    private CroakRepository croakRepository;

    @Autowired
    public CroakServiceImpl(CroakRepository croakRepository) {
        this.croakRepository = croakRepository;
    }

    public Croak save(Croak croak) {
        return croakRepository.save(croak);
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
