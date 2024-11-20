package org.example.algolia_microservice.pokemon.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.algolia_microservice.pokemon.dto.PokemonCreateDTO;
import org.example.algolia_microservice.pokemon.dto.PokemonResponseDTO;
import org.example.algolia_microservice.pokemon.dto.PokemonUpdateDTO;
import org.example.algolia_microservice.pokemon.mapper.PokemonMapper;
import org.example.algolia_microservice.pokemon.model.Pokemon;
import org.example.algolia_microservice.pokemon.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;
    private final PokemonMapper pokemonMapper;

    public PokemonServiceImpl(PokemonRepository pokemonRepository, PokemonMapper pokemonMapper) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonMapper = pokemonMapper;
    }


    @Override
    public List<PokemonResponseDTO> getAllPokemonForUser(Long userId) {
        List<Pokemon> pokemonList = pokemonRepository.findByUserId(userId);

        return pokemonList.stream()
                .map(pokemonMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PokemonResponseDTO> getAllPokemon() {
        return pokemonRepository.findAll().stream()
                .map(pokemonMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PokemonResponseDTO getPokemonById(Long id) {
        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        if (optionalPokemon.isPresent()) {
            return pokemonMapper.mapToDTO(optionalPokemon.get());
        } else {
            throw new EntityNotFoundException("Pokemon not found with id " + id);
        }
    }

    @Override
    public PokemonResponseDTO createPokemon(PokemonCreateDTO pokemonCreateDTO) {
        Pokemon pokemon = pokemonRepository.save(pokemonMapper.mapToEntity(pokemonCreateDTO));
        return pokemonMapper.mapToDTO(pokemon);
    }

    @Override
    public PokemonResponseDTO updatePokemon(Long id, PokemonUpdateDTO pokemonUpdateDTO) {
        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        if (optionalPokemon.isPresent()) {
            Pokemon existingPokemon = optionalPokemon.get();
            existingPokemon.setName(pokemonUpdateDTO.getName());
            existingPokemon.setPicture(pokemonUpdateDTO.getPicture());
            existingPokemon.setLife(pokemonUpdateDTO.getLife());
            existingPokemon.setDamage(pokemonUpdateDTO.getDamage());
            existingPokemon.setTypes(pokemonUpdateDTO.getTypes());

            Pokemon updatedPokemon = pokemonRepository.save(existingPokemon);
            return pokemonMapper.mapToDTO(updatedPokemon);
        } else {
            throw new EntityNotFoundException("Pokemon not found with id " + id);
        }
    }

    @Override
    public void deletePokemon(Long id) {
        pokemonRepository.deleteById(id);
    }
}
