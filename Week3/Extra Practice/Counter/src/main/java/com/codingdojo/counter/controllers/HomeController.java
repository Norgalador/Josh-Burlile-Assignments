package com.codingdojo.counter.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	private String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount++;
			session.setAttribute("count", currentCount);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	private String showCounter(HttpSession session, Model model, HttpServletRequest request) {
		Integer currentCount = 0;
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			currentCount = (Integer) session.getAttribute("count");
		}
		model.addAttribute("count", currentCount);
		
		
		
		return "counter.jsp";
	}
}
