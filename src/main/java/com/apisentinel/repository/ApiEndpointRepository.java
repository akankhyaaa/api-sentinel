package com.apisentinel.repository;

import com.apisentinel.entity.ApiEndpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ApiEndpointRepository
        extends JpaRepository<ApiEndpoint, Long> {
    @Query("SELECT COUNT(a) FROM ApiEndpoint a WHERE a.status='UP'")
    long countUpApis();

    @Query("SELECT COUNT(a) FROM ApiEndpoint a WHERE a.status='DOWN'")
    long countDownApis();
}
