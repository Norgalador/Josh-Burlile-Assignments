package com.codingdojo.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
    // this method retrieves all the languages from the database
    List<Language> findAll();
    // this method finds languages containing the search string
    List<Language> findByNameContaining(String search);
    // this method counts how many languages contain a certain string
    Long countByNameContaining(String search);
    // this method deletes a language that starts with a specific name
    Long deleteByNameStartingWith(String search);
}