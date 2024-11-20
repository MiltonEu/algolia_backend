package org.example.algolia_microservice.pokemon.mapper;

import org.example.algolia_microservice.indexer.model.IndexablePokemon;
import org.example.algolia_microservice.pokemon.dto.PokemonCreateDTO;
import org.example.algolia_microservice.pokemon.dto.PokemonResponseDTO;
import org.example.algolia_microservice.pokemon.model.Pokemon;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonMapper {

    Pokemon mapToEntity(PokemonCreateDTO pokemonCreateDTO);
    PokemonResponseDTO mapToDTO(Pokemon pokemon);
    IndexablePokemon mapToIndexablePokemon(Pokemon pokemon);
}
