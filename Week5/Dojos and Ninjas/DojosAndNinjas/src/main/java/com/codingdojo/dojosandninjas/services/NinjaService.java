package com.codingdojo.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
    // adding the repository as a dependency
	private final NinjaRepository ninjaRepo;
    
    public NinjaService(NinjaRepository NinjaRepo) {
        this.ninjaRepo = NinjaRepo;
    }
    // returns all the Ninjas
    public List<Ninja> allNinjas() {
        return ninjaRepo.findAll();
    }
    // creates a Ninja
    public Ninja createNinja(Ninja d) {
        return ninjaRepo.save(d);
    }
    // retrieves a Ninja
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    //finds a dojo
    public List<Ninja> byDojo(Dojo dojo) {
    	return ninjaRepo.findAllByDojo(dojo);
    }
}