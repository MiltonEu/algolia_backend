package org.example.algolia_microservice.indexer.service;

import org.example.algolia_microservice.indexer.model.IndexerState;
import org.example.algolia_microservice.indexer.repository.IndexerStateRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class IndexerStateServiceImpl implements IndexerStateService {

    private final IndexerStateRepository indexerStateRepository;

    public IndexerStateServiceImpl(IndexerStateRepository indexerStateRepository) {
        this.indexerStateRepository = indexerStateRepository;
    }

    @Override
    public Optional<IndexerState> getIndexLastUpdateDate(String indexName) {
        return indexerStateRepository.findByName(indexName);
    }

    @Override
    public void updateLastIndexUpdateDate(Instant updateDate, String indexName) {
        Optional<IndexerState> indexerState = indexerStateRepository.findByName(indexName);

        if (indexerState.isEmpty()) {
            IndexerState newIndexState = new IndexerState(
                    null,
                    updateDate,
                    updateDate,
                    indexName
            );
            indexerStateRepository.save(newIndexState);
            return;
        }

        indexerState.get().setUpdatedAt(updateDate);
        indexerStateRepository.save(indexerState.get());

    }
}
