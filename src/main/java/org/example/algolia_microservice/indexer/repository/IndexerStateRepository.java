package org.example.algolia_microservice.indexer.repository;

import org.example.algolia_microservice.indexer.model.IndexerState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IndexerStateRepository extends JpaRepository<IndexerState, Long> {

    @Query("SELECT i FROM IndexerState i WHERE i.indexName = ?1")
    Optional<IndexerState> findByName(String indexName);

}

