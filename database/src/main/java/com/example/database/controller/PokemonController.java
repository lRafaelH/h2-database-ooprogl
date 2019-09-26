package com.example.database.controller;

import com.example.database.model.Pokemon;
import com.example.database.model.Trainer;
import com.example.database.repository.PokemonRepository;
import com.example.database.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;
    private TrainerRepository trainerRepository;

    @PutMapping("/pokemon")
    public Pokemon addPokemon(@RequestBody Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    @GetMapping("/pokemon/{ID}")
    public Pokemon getPokemon(@PathVariable Integer ID) {
        return pokemonRepository.findById(ID).orElse(null);
    }

    @DeleteMapping("/pokemon")
    public void deletePokemonByID(@RequestParam(name = "ID") Integer ID) {
        pokemonRepository.deleteById(ID);
    }

    @GetMapping("/pokemon/type/{type}")
    public Set<Pokemon> getPokemonByType(@PathVariable String type) {
        return pokemonRepository.findAllByType(type);
    }
    @GetMapping("/pokemon/color/{color}")
    public Set<Pokemon> getPokemonByColor(@PathVariable String color) {
        return pokemonRepository.findAllByColor(color);
    }
    @GetMapping("/pokemon/size/{size}")
    public Set<Pokemon> getPokemonBySize(@PathVariable Integer size) {
        return pokemonRepository.findAllBySize(size);
        }

    @GetMapping("/pokemon/attribute/{attribute}")
    public Set<Pokemon> getPokemonByAttribute(@PathVariable String attribute) {
        return pokemonRepository.findAllByAttribute(attribute);
    }

    @GetMapping("/pokemon/gender/{gender}")
    public Set<Pokemon> getPokemonByGender(@PathVariable String gender) {
        return pokemonRepository.findAllByGender(gender);
    }

    @DeleteMapping("/pokemon/type")
    public void deletePokemonByType(@RequestParam(name = "type")String type) {
        pokemonRepository.deleteByType(type);
    }

    @DeleteMapping("/pokemon/color")
    public void deletePokemonByColor(@RequestParam(name = "color")String color) {
        pokemonRepository.deleteByColor(color);
    }

    @DeleteMapping("/pokemon/attribute")
    public void deletePokemonByAttribute(@RequestParam(name = "attribute")String attribute) {
        pokemonRepository.deleteByAttribute(attribute);
    }

    @DeleteMapping("/pokemon/gender")
    public void deletePokemonByGender(@RequestParam(name = "gender")String gender) {
        pokemonRepository.deleteByGender(gender);
    }

    @DeleteMapping("/pokemon/size")
    public void deletePokemonBySize(@RequestParam(name = "size")Integer size) {
        pokemonRepository.deleteBySize(size);
    }

    @GetMapping("/pokemon/addtrainer/swagger")
    public Pokemon linktrainer(@RequestParam Integer trainerid, @RequestParam Integer id) {
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        Optional<Trainer> trainer = trainerRepository.findById(trainerid);

        if (pokemon.isPresent()) {
            Pokemon updatedPokemon = pokemon.get();
            updatedPokemon.setTrainer(trainer.get());
            return pokemonRepository.save(updatedPokemon);
        }
        return pokemon.get();
    }

}