package com.raven.croaker.repository;

import com.raven.croaker.model.Role;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends ElasticsearchRepository<Role, String> {
    Optional<Role> findByRoleName(String roleName);
}
