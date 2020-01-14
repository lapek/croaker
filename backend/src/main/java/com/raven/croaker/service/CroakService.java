package com.raven.croaker.service;

import com.raven.croaker.model.Croak;
import com.raven.croaker.repository.CroakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public void delete(Croak croak) {
        croakRepository.delete(croak);
    }

    public List<Croak> findAll() {
        List<Croak> list = new ArrayList<>();
        croakRepository.findAll().forEach(list::add);
        return list;
    }
}
