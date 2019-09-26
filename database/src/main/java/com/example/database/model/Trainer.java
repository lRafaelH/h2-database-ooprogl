package com.example.database.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer trainerid;
    private String name;
    private String gender;

    @OneToMany(mappedBy = "trainer" , fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Pokemon> pokemons;

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Integer getTrainerid() {
        return trainerid;
    }

    public void setTrainerid(Integer trainerid) {
        this.trainerid = trainerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
