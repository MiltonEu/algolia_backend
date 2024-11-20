package org.example.algolia_microservice.pokemon.service;

import org.example.algolia_microservice.pokemon.dto.PokemonCreateDTO;
import org.example.algolia_microservice.pokemon.dto.PokemonResponseDTO;
import org.example.algolia_microservice.pokemon.dto.PokemonUpdateDTO;
import org.example.algolia_microservice.pokemon.model.Pokemon;

import java.util.List;

public interface PokemonService {

    List<PokemonResponseDTO> getAllPokemonForUser(Long userId);

    List<PokemonResponseDTO> getAllPokemon();

    PokemonResponseDTO getPokemonById(Long id);

    PokemonResponseDTO createPokemon(PokemonCreateDTO pokemon);

    PokemonResponseDTO updatePokemon(Long id, PokemonUpdateDTO pokemon);

    void deletePokemon(Long id);
}
