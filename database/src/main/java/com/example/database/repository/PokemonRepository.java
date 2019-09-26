package com.example.database.repository;

import com.example.database.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.Set;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    Set<Pokemon> findAllByType(String type);
    Set<Pokemon> findAllByColor(String color);
    Set<Pokemon> findAllByAttribute(String attribute);
    Set<Pokemon> findAllBySize(Integer size);
    Set<Pokemon> findAllByGender(String gender);


    @Transactional
    void deleteByType(String type);

    @Transactional
    void deleteByAttribute(String attribute);

    @Transactional
    void deleteBySize(Integer size);

    @Transactional
    void deleteByGender(String gender);

    @Transactional
    void deleteByColor(String color);





}
