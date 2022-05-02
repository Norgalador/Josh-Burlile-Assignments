package com.codingdojo.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
    // adding the language repository as a dependency
	private final LanguageRepository languageRepo;
    
    public LanguageService(LanguageRepository languageRepo) {
        this.languageRepo = languageRepo;
    }
    // returns all the languages
    public List<Language> allLanguages() {
        return languageRepo.findAll();
    }
    // creates a language
    public Language createLanguage(Language b) {
        return languageRepo.save(b);
    }
    // retrieves a language
    public Language findLanguage(Long id) {
        return languageRepo.findById(id).orElse(null);
    }
    // update a language
    public void updateLanguage (Language language) {
    	languageRepo.save(language);
    }
    // delete a language
    public void deleteLanguage(Long id) {
    	languageRepo.deleteById(id);
    }
}
