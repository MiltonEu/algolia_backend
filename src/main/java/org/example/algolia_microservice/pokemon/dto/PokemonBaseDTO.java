package org.example.algolia_microservice.pokemon.dto;

import jakarta.validation.constraints.*;
import org.example.algolia_microservice.pokemon.model.PokemonType;

import java.util.List;
import java.util.Set;

public abstract class PokemonBaseDTO {

    @NotBlank(message = "Le nom est requis.")
    @Size(min = 1, max = 50, message = "Le nom doit contenir entre 1 et 50 caractères.")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Le nom doit respecter le modèle spécifié.")
    private String name;

    @NotBlank(message = "L'image est requise.")
    private String picture;

    @Min(value = 0, message = "La vie doit être positive.")
    @Max(value = 100, message = "La vie ne peut pas dépasser 100.")
    private int life;

    @Min(value = 0, message = "Les dégâts doivent être positifs.")
    private int damage;

    @NotNull(message = "Les types sont requis.")
    @Size(max = 3, message = "Vous ne pouvez pas spécifier plus de 3 types.")
    private Set<PokemonType> types;

    public PokemonBaseDTO(String name, String picture, int life, int damage, Set<PokemonType> types) {
        this.name = name;
        this.picture = picture;
        this.life = life;
        this.damage = damage;
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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

    public Set<PokemonType> getTypes() {
        return types;
    }

    public void setTypes(Set<PokemonType> types) {
        this.types = types;
    }
}
