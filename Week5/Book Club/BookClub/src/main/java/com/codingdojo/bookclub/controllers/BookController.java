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
public class BookController {

	  @Autowired
	  private BookService bookService;
	  @Autowired
	  private UserService userService;
	  
	
	//***** Book Routes ******
	 
	// Dashboard route
	 @GetMapping("/dashboard")
	 public String dashboard(HttpSession session, Model bookModel) {
		 
		 //	Check if user is in session
		 if(session.getAttribute("loggedInUser")!=null) {
			 bookModel.addAttribute("books", bookService.allBooks());
			 return "dashboard.jsp";
		 }
		 else {
			 return "redirect:/";
		 }
	 }

//		Check if user is in session for all get routes
	 
//		Book Market route
	 	@GetMapping("/bookmarket")
	 	public String bookmarket(HttpSession session, Model bookModel) {
	 	if(session.getAttribute("loggedInUser")!=null) {
	 		bookModel.addAttribute("books", bookService.allBooks());
	 		return "bookmarket.jsp";
	 	}
	 	else {
	 		return "redirect:/";
	 	}
	 }
	 
//		New Book
	 	@GetMapping("/new")
	 	public String newBook(HttpSession session, 
	 			@ModelAttribute("newBook") Book book) {
	 		if(session.getAttribute("loggedInUser")!=null) {
	 			return "new.jsp";
	 		}
	 		else {
	 			 return "redirect:/";
	 		 }
	 	}
	 	
//		Create book
	 	@PostMapping("/books/create")
	 	public String createProject(@Valid @ModelAttribute("newBook") Book book, 
	 			BindingResult result) {
	 		if(result.hasErrors()) {
	 			return "new.jsp";
	 		}
	 		else {
	 			bookService.createBook(book);
	 			return "redirect:/dashboard";
	 		}
	 	}
//		Get one book details - allow edit/delete
	 	@GetMapping("/books/bookDetails/{id}")
	 	public String bookDetails(@PathVariable Long id, 
	 			Model bookModel,
	 			HttpSession session) {
	 		
	 		if(session.getAttribute("loggedInUser")!=null) {
	 			Book myBook=bookService.getOneBook(id);
	 	 		bookModel.addAttribute("book", myBook);
	 	 		return "bookDetails.jsp";
	 		}
	 		else {
	 			 return "redirect:/";
	 		 }
	 		
	 	}
//		Delete book
	 	@GetMapping("/delete/{id}")
	 	public String deleteBook(@PathVariable Long id,
	 			HttpSession session) {
	 		if(session.getAttribute("loggedInUser")!=null) {
		 		bookService.deleteBook(id);
		 		return "redirect:/dashboard";
	 		}
	 		else {
	 			return "redirect:/";
	 		}
	 	}
	 	
//		Edit book
	 	@GetMapping("/edit/{id}")
	 	public String editBook(@PathVariable Long id, 
	 			Model bookModel,
	 			HttpSession session) {
	 		if(session.getAttribute("loggedInUser")!=null) {
		 		Book editBook=bookService.getOneBook(id);
		 		bookModel.addAttribute("editBook", editBook);
		 		return "edit.jsp";
	 		}
	 		else {
	 			 return "redirect:/";
	 		 }
	 	}
//		Update book
	 	@PutMapping("/update/{id}")
	 	public String updateBook(@Valid @PathVariable Long id,
	 			@ModelAttribute("editBook") Book editedBook,
	 			BindingResult result,
	 			HttpSession session) {
	 		if(session.getAttribute("loggedInUser")!=null) {
	 			bookService.updateBook(editedBook);
	 			return "redirect:/dashboard";
	 		}
	 		else {
	 			return "redirect:/";
	 		}
	 	}
	 
	 
}
