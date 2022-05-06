package com.codingdojo.loginregistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.loginregistration.models.LoginUser;
import com.codingdojo.loginregistration.models.User;
import com.codingdojo.loginregistration.services.UserService;

@Controller
public class HomeController {
 
  @Autowired
  private UserService userService;
 
// Root route
 @GetMapping("/")
 public String index(@ModelAttribute("newUser") User user, 
		 @ModelAttribute("newLogin") LoginUser loginUser) {
 
     // Bind empty User and LoginUser objects to the JSP
     // to capture the form input
     return "index.jsp";
 }
 
// Register a user
 @PostMapping("/register")
 public String register(@Valid @ModelAttribute("newUser") User user, 
         BindingResult result, HttpSession session, 
         @ModelAttribute("newLogin") LoginUser loginUser) {
     //	Validate user
	 userService.validate(user, result);
	 if(result.hasErrors()) {
		 return "index.jsp";
	 }
	 //	Register user
	 userService.register(user, result);
	 //	Put user in Session
	 session.setAttribute("loggedInUser", user);
	 return "redirect:/dashboard";
 }
 
 // Login a user
 @PostMapping("/login")
 public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser loginUser, 
         BindingResult result, 
         HttpSession session, 
         @ModelAttribute("newUser") User user) {
	 
	 //Authenticate the user
	 userService.authenticateUser(loginUser, result);
	 if(result.hasErrors()) {
		 return "index.jsp";
	 }
     User loggedInUser=userService.findByEmail(loginUser.getEmail());
    
     //Put user in session
     session.setAttribute("loggedInUser", loggedInUser);
     return "redirect:/dashboard";
 }

 //	Logout a user
 @GetMapping("/logout")
 public String logout(HttpSession session) {
	 session.invalidate();
	 return "redirect:/";
 }
 
 @GetMapping("/dashboard")
 public String dashboard(HttpSession session) {
	 //	Check if user is in session
	 
	 if(session.getAttribute("loggedInUser")!=null) {
		 return "dashboard.jsp";
	 }
	 else {
		 return "redirect:/";
	 }
 }
 

 
}