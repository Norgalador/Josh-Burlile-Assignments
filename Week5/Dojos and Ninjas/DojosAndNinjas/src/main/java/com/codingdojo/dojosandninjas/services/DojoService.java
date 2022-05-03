package com.codingdojo.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
    // adding the repository as a dependency
	private final DojoRepository dojoRepo;
    
    public DojoService(DojoRepository dojoRepo) {
        this.dojoRepo = dojoRepo;
    }
    // returns all the dojos
    public List<Dojo> allDojos() {
        return dojoRepo.findAll();
    }
    // creates a dojo
    public Dojo createDojo(Dojo d) {
        return dojoRepo.save(d);
    }
    // retrieves a dojo
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
}
