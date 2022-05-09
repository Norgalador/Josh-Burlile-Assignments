package com.codingdojo.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;



@Controller
public class HomeController {
 
  @Autowired
  private UserService userService;
  @Autowired
  private BookService bookService;
 
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
 

 
}