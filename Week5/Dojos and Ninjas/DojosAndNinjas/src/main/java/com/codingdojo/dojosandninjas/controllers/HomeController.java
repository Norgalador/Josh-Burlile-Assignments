package com.codingdojo.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.services.DojoService;
import com.codingdojo.dojosandninjas.services.NinjaService;



@Controller
public class HomeController {

	@Autowired
	private DojoService dojos;
	@Autowired
	private NinjaService ninjas;
	
	
//	Root route
	@GetMapping("/")
	public String home() {
	return "redirect:/dojos/new";
	}
	
//	Index route
	@GetMapping("/dojos/new")
	public String index(Model dojoModel, @ModelAttribute("dojo") Dojo dojo) {
		dojoModel.addAttribute("dojo", dojo);
		return "index.jsp";
	}
	
//	Create a Dojo
	@PostMapping("/dojos/new")
	public String createDojo(Model dojoModel, @Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			dojoModel.addAttribute("dojo", dojo);
			return "index.jsp";
		}
		dojos.createDojo(dojo);
		return "redirect:/dojos/new";
	}

//	New Ninja page
	@GetMapping("/ninjas/new")
	public String ninjaForm(Model ninjaModel, @ModelAttribute("ninja") Ninja ninja) {
		ninjaModel.addAttribute("dojos", dojos.allDojos());
		return "new_ninja.jsp";
	}
	
// Create a Ninja
	@PostMapping("/ninjas")
	public String createNinja(Model ninjaModel, @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			ninjaModel.addAttribute("ninja", ninja);
			return "new_ninja.jsp";
		}
		ninja = ninjas.createNinja(ninja);
		return "redirect:/dojos/" + ninja.getDojo().getId();
	}

	//	Show a dojo's ninjas
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model dojoModel) {
		Dojo dojo = dojos.findDojo(id);
	dojoModel.addAttribute("dojo", dojo);
	return "showDojo.jsp";
	}
}