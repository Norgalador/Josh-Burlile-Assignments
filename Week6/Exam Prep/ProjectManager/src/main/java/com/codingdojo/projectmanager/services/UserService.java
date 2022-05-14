package com.codingdojo.projectmanager.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import com.codingdojo.projectmanager.models.LoginUser;
import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.models.User;
import com.codingdojo.projectmanager.repositories.ProjectRepository;
import com.codingdojo.projectmanager.repositories.UserRepository;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ProjectRepository projectRepo;
    
    //Validate User for - Duplicate email and password mismatch
    public void validate(User newUser, Errors errors) {
        // Password match check
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            errors.rejectValue("password", "mismatch", "Password does not match!");
        }
        //  Duplicate email check
        if(userRepo.findByEmail(newUser.getEmail())!=null) {
            errors.rejectValue("email", "unique", "Email is already taken!");
        }
    }
    
    // Hash users password and save to database
    public User register(User newUser, BindingResult result) {
        // Hash and set password, save user to database
        String hashedPass=BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashedPass);
        userRepo.save(newUser);
        // Return null if result has errors
        return null;
    }
    
    // Find all users
    public List<User> allUsers() {
    	return userRepo.findAll();
    }
    
    // Update a user
    public User updateUser(User user) {
    	return userRepo.save(user);
    }
        
    // Find user by email
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    
    // Find user by id
    public User findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
        
    
    // Authenticate user
    public boolean authenticateUser(LoginUser newLogin, Errors errors) {
        // First find the user by email
        User user= userRepo.findByEmail(newLogin.getEmail());
        // Reject if NOT present
        if(user==null) {
            errors.rejectValue("email", "missingEmail", "email not found");
            return false;
        // Reject if BCrypt password match fails
        } else {
            if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
                errors.rejectValue("password", "Matches", "Invalid password!");
                return false;
            }
        }
        // Otherwise, return the user object
        return true;
    }
    
    // Get users based on projects
    public List<User> getAssignedProjects(Project project) {
    	return userRepo.findAllByProjects(project);
    }
    
    // Get users based on unassigned projects
    public List<User> getUnassignedProjects(Project project) {
    	return userRepo.findByProjectsNotContains(project);
    }
    
    // Join project team
    public void joinTeam(Project project, User user) {
    	List<User> users=project.getUsers();
    	users.add(user);
    	projectRepo.save(project);
    }
    
    // Leave project team
    public void leaveTeam(Project project, User user) {
    	List<User> users=project.getUsers();
    	users.remove(user);
    	projectRepo.save(project);
    }
}