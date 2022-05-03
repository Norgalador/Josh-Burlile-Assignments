package com.codingdojo.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.models.Dojo;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {

		 // this method retrieves all the ninjas from the database
	    List<Ninja> findAll();
	    // list the dojos
	    List<Ninja> findAllByDojo(Dojo dojo);

}
