package com.codingdojo.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
//	Root route
	@GetMapping("/")
	public String index(Model expenseModel, @ModelAttribute("newExpense") Expense newExpense) {
		List<Expense> expenses = expenseService.allExpenses();
		expenseModel.addAttribute("allExpenses", expenses);
		return "index.jsp";
	}

//	Add an expense
	@PostMapping("/processing")
	public String processForm(@Valid @ModelAttribute("newExpense") Expense newExpense, BindingResult results) {
		if(results.hasErrors()) {
			return "index.jsp";
		}
		expenseService.createExpense(newExpense);
		
		return "redirect:/";
	}
}
