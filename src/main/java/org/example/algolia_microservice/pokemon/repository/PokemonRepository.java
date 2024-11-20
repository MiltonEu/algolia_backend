package org.example.algolia_microservice.pokemon.repository;

import org.example.algolia_microservice.pokemon.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    @Query("SELECT p FROM Pokemon p LEFT JOIN FETCH p.types WHERE p.owner.id = :userId")
    List<Pokemon> findByUserId(Long userId);

    @Query("SELECT p FROM Pokemon p WHERE p.updatedAt > :lastUpdate")
    List<Pokemon> findPokemonsUpdatedAfter(Instant lastUpdate);
}
