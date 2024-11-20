package org.example.algolia_microservice.indexer.service;

import org.example.algolia_microservice.indexer.model.IndexerState;
import org.example.algolia_microservice.pokemon.mapper.PokemonMapper;
import org.example.algolia_microservice.pokemon.repository.PokemonRepository;
import org.example.algolia_microservice.providers.algolia.indexing.AlgoliaIndexingService;
import org.example.algolia_microservice.user.mapper.UserMapper;
import org.example.algolia_microservice.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class IndexingJob {
    private static final long TWO_MINUTES = 120000;
    private final AlgoliaIndexingService algoliaIndexingService;
    private final IndexerStateService indexerStateService;
    private final PokemonRepository pokemonRepository;
    private final PokemonMapper pokemonMapper;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Value("${algolia.users.index}")
    private String userIndex;

    @Value("${algolia.pokemons.index}")
    private String pokemonIndex;

    public IndexingJob(AlgoliaIndexingService algoliaIndexingService, IndexerStateService indexerStateService, PokemonRepository pokemonRepository, PokemonMapper pokemonMapper, UserMapper userMapper, UserRepository userRepository) {
        this.algoliaIndexingService = algoliaIndexingService;
        this.indexerStateService = indexerStateService;
        this.pokemonRepository = pokemonRepository;
        this.pokemonMapper = pokemonMapper;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Scheduled(fixedRate = TWO_MINUTES, initialDelay = 2000)
    public void processUpdateUserIndex() {
        processUpdateIndex(userIndex, userRepository::getUsersUpdatedAfter, userMapper::mapToIndexableUser);
    }

    @Scheduled(fixedRate = TWO_MINUTES, initialDelay = 2000)
    public void processUpdatePokemonIndex() {
        processUpdateIndex(pokemonIndex, pokemonRepository::findPokemonsUpdatedAfter, pokemonMapper::mapToIndexablePokemon);
    }

    private <T, R> void processUpdateIndex(String indexName, Function<Instant, List<T>> findUpdatedEntities, Function<T, R> mapToIndexable) {
        Instant dateBeforeIndexing = Instant.now();
        Instant lastUpdateDate;
        Optional <IndexerState> indexerState = indexerStateService.getIndexLastUpdateDate(indexName);
        if(indexerState.isEmpty()){
            lastUpdateDate = Instant.EPOCH;
        } else {
            lastUpdateDate = indexerState.get().getUpdatedAt();
        }

        List<R> indexableEntities = findUpdatedEntities.apply(lastUpdateDate).stream().map(mapToIndexable).toList();

        this.algoliaIndexingService.updateObjects(indexName, indexableEntities);
        this.indexerStateService.updateLastIndexUpdateDate(dateBeforeIndexing, indexName);
    }
}