package com.codingdojo.savetravels.controllers;

import java.util.List;

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
	
// Edit an expense
	@GetMapping("/edit/{id}")
	public String editExpense(@PathVariable Long id, Model expenseModel) {
        Expense editExpense = expenseService.findExpense(id);
        expenseModel.addAttribute("editExpense", editExpense);
        return "edit.jsp";
	}   
	
	@PutMapping("/update/{id}")
    public String updateExpense(@Valid @PathVariable Long id, @ModelAttribute("editExpense") Expense editedExpense, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            expenseService.updateExpense(editedExpense);
            return "redirect:/";
        }
	}

// Delete an expense
	@DeleteMapping("/delete/{id}")
	public String deleteExpense(@PathVariable Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/";
	}
	
//Show an expense
	@GetMapping("/expenses/{id}")
	public String showExpense(@PathVariable Long id, Model expenseModel) {
		Expense expense = expenseService.findExpense(id);
		expenseModel.addAttribute("expense", expense);
		return "details.jsp";
	}
}
