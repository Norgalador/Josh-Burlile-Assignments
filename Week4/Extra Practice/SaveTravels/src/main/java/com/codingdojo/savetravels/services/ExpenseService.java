package com.codingdojo.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	    // adding the expense repository as a dependency
		private final ExpenseRepository expenseRepository;
	    
	    public ExpenseService(ExpenseRepository expenseRepository) {
	        this.expenseRepository = expenseRepository;
	    }
	    // returns all the expenses
	    public List<Expense> allExpenses() {
	        return expenseRepository.findAll();
	    }
	    // creates an expense
	    public Expense createExpense(Expense expense) {
	        return expenseRepository.save(expense);
	    }
	    // retrieves an expense
	    public Expense findExpense(Long id) {
	    	return expenseRepository.findById(id).orElse(null);
	    }
	    // edits an expense
	    public void updateExpense(Expense expense) {
	    	expenseRepository.save(expense);
	    }
	    
	 // deletes an expense
	    public void deleteExpense(Long id) {
	    	expenseRepository.deleteById(id);
	    }
}
