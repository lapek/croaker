package com.raven.croaker.domain;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends ElasticsearchRepository<Role, String> {
}
