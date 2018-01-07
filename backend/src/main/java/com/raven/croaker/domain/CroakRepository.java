package com.raven.croaker.domain;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CroakRepository extends ElasticsearchRepository<Croak, String> {
}
