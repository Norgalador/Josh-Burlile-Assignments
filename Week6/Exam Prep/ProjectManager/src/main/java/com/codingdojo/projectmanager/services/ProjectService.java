package com.codingdojo.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.models.User;
import com.codingdojo.projectmanager.repositories.ProjectRepository;

@Service
public class ProjectService {
    
	// adding the repository as a dependency
	private final ProjectRepository projectRepo;
    
    public ProjectService(ProjectRepository projectRepo) {
        this.projectRepo = projectRepo;
    }
    
    // returns all the projects
    public List<Project> allProjects() {
        return projectRepo.findAll();
    }
    // creates a project
    public Project createProject(Project project) {
        return projectRepo.save(project);
    }
    // retrieves a project
    public Project findProject(Long id) {
        Optional<Project> optionalProject = projectRepo.findById(id);
        if(optionalProject.isPresent()) {
            return optionalProject.get();
        } else {
            return null;
        }
    }
    
    // updates a project
    public Project updateProject(Project project) {
    	return projectRepo.save(project);
    }
    
    // gets one project
    public Project getOneProject(Long id) {
    	return projectRepo.findById(id).orElse(null);
    }
    
    // delete a project
    public void deleteProject(Long id) {
    	projectRepo.deleteById(id);
    }
    
    // get assigned users of a project
    public List<Project> getAssignedUsers(User user) {
    	return projectRepo.findAllByUsers(user);
    }
    
    // get all unassigned users of a project
    public List<Project> getUnassignedUsers(User user) {
    	return projectRepo.findByUsersNotContains(user);
    }
    
}