package com.codingdojo.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/")
	public String index(@RequestParam(value="q", required=false) String firstName, String lastName) {
		if(firstName == null) {
			return "Hello human! How is the weather today?";
		}
		return "Hello, " + firstName + " " + lastName + ". " + "You look fantastic today!";
	}
	
}
