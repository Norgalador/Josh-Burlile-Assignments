package com.codingdojo.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
   
	User findByEmail(String email);
	List <User> findAll();
	List <User> findAllByProjects(Project project);
	List <User> findByProjectsNotContains(Project project);
	User findByIdIs(Long id);
}