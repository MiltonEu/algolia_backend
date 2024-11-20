package org.example.algolia_microservice.pokemon.controller;

import org.example.algolia_microservice.pokemon.dto.PokemonCreateDTO;
import org.example.algolia_microservice.pokemon.dto.PokemonResponseDTO;
import org.example.algolia_microservice.pokemon.dto.PokemonUpdateDTO;
import org.example.algolia_microservice.pokemon.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value =  "/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping(value = "/all/{userId}")
    public ResponseEntity<List<PokemonResponseDTO>> getAllPokemonForUser(@PathVariable Long userId) {
        List<PokemonResponseDTO> pokemons = pokemonService.getAllPokemonForUser(userId);
        return ResponseEntity.ok(pokemons);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<PokemonResponseDTO>> getAllPokemon() {
        List<PokemonResponseDTO> pokemons = pokemonService.getAllPokemon();
        return ResponseEntity.ok(pokemons);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PokemonResponseDTO> getPokemonById(@PathVariable Long id) {
        return ResponseEntity.ok(pokemonService.getPokemonById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<PokemonResponseDTO> createPokemon(PokemonCreateDTO pokemon) {
        return ResponseEntity.ok(pokemonService.createPokemon(pokemon));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PokemonResponseDTO> updatePokemon(@PathVariable Long id, @RequestBody PokemonUpdateDTO pokemon) {
        return ResponseEntity.ok(pokemonService.updatePokemon(id, pokemon));
    }

}
