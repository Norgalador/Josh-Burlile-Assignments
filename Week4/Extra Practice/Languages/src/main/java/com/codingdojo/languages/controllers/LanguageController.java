package com.codingdojo.languages.controllers;

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

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class LanguageController {

	@Autowired
	private LanguageService languageService;
	
	
//	Root route
	@GetMapping("/languages")
	public String index(Model languageModel, @ModelAttribute("language") Language language) {
		List<Language> languages = languageService.allLanguages();
		languageModel.addAttribute("languages", languages);
		return "index.jsp";
	}


//	Create a language with form
	@PostMapping("/languages")
	public String createLang(Model languageModel, @Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			List<Language> languages = languageService.allLanguages();
			languageModel.addAttribute("languages", languages);
			return "index.jsp";
		}
		languageService.createLanguage(language);
		
		return "redirect:/languages";
	}
	
//	Get specified language details
	@GetMapping("/languages/{id}")
	public String viewLang(@PathVariable("id") Long id, Model languageModel) {
		Language language = languageService.findLanguage(id);
		languageModel.addAttribute("language", language);
		return "details.jsp";
	}
	
//	Edit specified language details
	@GetMapping("/languages/{id}/edit")
	public String editLang(@PathVariable("id") Long id, Model languageModel) {
		Language language = languageService.findLanguage(id);
        languageModel.addAttribute("language", language);
		return "edit.jsp";
	}
	
//	Update specified language details
	@PutMapping("/languages/{id}")
	public String updateLang(@PathVariable("id") Long id, Model languageModel, @Valid @ModelAttribute("language") Language updatedLanguage, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			languageService.updateLanguage(updatedLanguage);
			return "redirect:/languages";
		}
	}
	
//	Delete specified language
	@DeleteMapping("/languages/{id}/delete")
	public String deleteLang(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}

}