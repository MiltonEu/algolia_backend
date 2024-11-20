package org.example.algolia_microservice.pokemon.model;

import jakarta.persistence.*;
import org.example.algolia_microservice.user.model.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pokemons")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int life;

    @Column(nullable = false)
    private int damage;

    @Column(nullable = false)
    private String picture;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "pokemon_types", joinColumns = @JoinColumn(name = "pokemon_id"))
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Set<PokemonType> types = new HashSet<>();

    @Column(nullable = false, name = "createdAt")
    @CreationTimestamp
    private Instant createdAt;

    @Column(nullable = false, name = "updatedAt")
    @UpdateTimestamp
    private Instant updatedAt;


    @ManyToOne
    @JoinColumn(name = "userId")
    private User owner;

    public Pokemon() {
    }

    public Pokemon(Long id, String name, int life, int damage, String picture, Set<PokemonType> types, Instant createdAt, Instant updatedAt, User owner) {
        this.id = id;
        this.name = name;
        this.life = life;
        this.damage = damage;
        this.picture = picture;
        this.types = types;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant created) {
        this.createdAt = created;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updated) {
        this.updatedAt = updated;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }


}
