package com.codingdojo.bookclub.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.repositories.UserRepository;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    //Validate User for - Duplicate email and password mismatch
    public void validate(User newUser, Errors errors) {
    	// Password match check
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		errors.rejectValue("password", "mismatch", "Password does not match!");
    	}
    	//	Duplicate email check
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
}