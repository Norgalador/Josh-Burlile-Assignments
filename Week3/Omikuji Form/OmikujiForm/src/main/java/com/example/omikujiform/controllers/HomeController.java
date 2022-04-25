package com.example.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class HomeController {

	@GetMapping("")
	private String index() {
		return "index.jsp";
	}
	
	@GetMapping("/show")
	private String omikujiResults(HttpSession session, Model model) {
		
		String result = (String) session.getAttribute("formOmikuji");
		model.addAttribute("result", result);
		
		
		return "show.jsp";
	}
	
	@PostMapping("/processForm")
	private String processData(
			@RequestParam("number") int number, 
			@RequestParam("city") String city,
			@RequestParam("person") String person,
			@RequestParam("activity") String activity,
			@RequestParam("livingThing") String livingThing,
			@RequestParam("geniality") String geniality,
			HttpSession session) {
		
		String formOmikuji = String.format("In %s years you will live in %s with %s as your roommate, %s. "
				+ "The next time you see a %s, you will have good luck. Also, %s.",
				number, city, person, activity, livingThing, geniality);
		
		session.setAttribute("formOmikuji", formOmikuji);
		return "redirect:/omikuji/show";
		
	}
}
