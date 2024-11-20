package org.example.algolia_microservice.pokemon.dto;


import org.example.algolia_microservice.pokemon.model.PokemonType;

import java.util.Set;

public class PokemonCreateDTO extends PokemonBaseDTO {


    public PokemonCreateDTO(String name, String picture, int life, int damage, Set<PokemonType> types) {
        super(name, picture, life, damage, types);
    }
}

