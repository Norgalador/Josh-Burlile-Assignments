package com.codingdojo.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	// List all books
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	// Create new book
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	// Delete book
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	// Get one book
	public Book getOneBook(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	
	// Update book
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	
	//Books that aren't borrowed
	public List<Book> unborrowedBooks(User user){
		return bookRepo.findByBorrowerIdIsOrUserIdIs(null, user.getId());
	}
	
	//Borrowed books
	public List<Book> borrowedBooks(User user){
		return bookRepo.findByBorrowerIdIs(user.getId());
	}
	
	//List of my books
	public List<Book> myBooks(User user){
		return bookRepo.findByUserIdIs(user.getId());
	}
	
	
}
