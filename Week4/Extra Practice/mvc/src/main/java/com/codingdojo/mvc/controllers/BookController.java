package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService BookService;
	
	@GetMapping("/")
	public String index(Model bookModel) {
		List<Book> books= BookService.allBooks();
		bookModel.addAttribute("allBooks", books);
		return "index.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String showBook(Model bookModel, @PathVariable("id") Long id) {
		Book showBook = BookService.findBook(id);
		bookModel.addAttribute("book", showBook);
		return "show.jsp";
	}
}
