package com.raven.croaker.service.internal;

import com.raven.croaker.domain.Croak;
import com.raven.croaker.domain.CroakRepository;
import com.raven.croaker.service.CroakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CroakServiceImpl implements CroakService {
    private CroakRepository croakRepository;

    @Autowired
    public void setCroakRepository(CroakRepository croakRepository) {
        this.croakRepository = croakRepository;
    }

    @Override
    public Croak save(Croak croak) {
        Date currentTime = new Date();
        croak.setPostDate(currentTime);
        croak.setLastEditDate(currentTime);
        return croakRepository.save(croak);
    }

    @Override
    public Croak update(Croak croak) {
        Date currentTime = new Date();
        croak.setLastEditDate(currentTime);
        return croakRepository.save(croak);
    }

    @Override
    public Iterable<Croak> findAllFromUser(String username) {
        return croakRepository.findByUsername(username);
    }

    @Override
    public void delete(Croak croak) {
        croakRepository.delete(croak);
    }

    @Override
    public Optional<Croak> findOne(String id) {
        return croakRepository.findById(id);
    }

    @Override
    public Iterable<Croak> findAll() {
        return croakRepository.findAll();
    }
}
