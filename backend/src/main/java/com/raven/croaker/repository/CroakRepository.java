package com.raven.croaker.repository;

import com.raven.croaker.model.Croak;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CroakRepository extends ElasticsearchRepository<Croak, String> {
}
