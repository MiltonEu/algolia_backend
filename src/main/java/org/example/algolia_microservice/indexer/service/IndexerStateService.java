package org.example.algolia_microservice.indexer.service;


import org.example.algolia_microservice.indexer.model.IndexerState;

import java.time.Instant;
import java.util.Optional;

public interface IndexerStateService {

    Optional<IndexerState> getIndexLastUpdateDate(String indexName);

    void updateLastIndexUpdateDate(Instant updateDate, String indexName);
}
