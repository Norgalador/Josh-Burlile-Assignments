package com.codingdojo.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
    // this method retrieves all the Projects from the database
    List<Project> findAll();
    // this method finds Projects with descriptions containing the search string
    List<Project> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);
    // this method deletes a Project that starts with a specific title
    Long deleteByTitleStartingWith(String search);
    
    Project findByIdIs(Long id);
    List<Project> findAllByUsers(User user);
    List<Project> findByUsersNotContains(User user);
    
}