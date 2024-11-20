package org.example.algolia_microservice.pokemon.dto;

import org.example.algolia_microservice.pokemon.model.PokemonType;
import org.example.algolia_microservice.user.dto.UserResponseDTO;

import java.time.Instant;
import java.util.Set;

public class PokemonResponseDTO {

    private Long id;
    private String name;
    private int life;
    private int damage;
    private String picture;
    private Set<PokemonType> types;
    private UserResponseDTO owner;

    public PokemonResponseDTO() {
    }

    public PokemonResponseDTO(Long id, String name, int life, int damage, String picture, Set<PokemonType> types, UserResponseDTO owner) {
        this.id = id;
        this.name = name;
        this.life = life;
        this.damage = damage;
        this.picture = picture;
        this.types = types;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Set<PokemonType> getTypes() {
        return types;
    }

    public void setTypes(Set<PokemonType> types) {
        this.types = types;
    }

    public UserResponseDTO getOwner() {
        return owner;
    }

    public void setOwner(UserResponseDTO owner) {
        this.owner = owner;
    }
}