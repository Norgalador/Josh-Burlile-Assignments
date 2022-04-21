package com.codingdojo.daikichipathvariables;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/daikichi")
public class HomeController {
	
	@RequestMapping("")
	public String index() {
		return "Welcome!";
	}
	
	@RequestMapping("/today")
	public String luck() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@RequestMapping("/tomorrow")
	public String fortune() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
	@RequestMapping("/travel/{location}")
	public String robotVacationResponse(@PathVariable("location") String location) {
		return "Wow! A vacation for you? You deserve it, human! Have fun out there in " + location + "!";
	}
	
	@RequestMapping("/lotto/{num}")
	public String sassyLadyLuck(@PathVariable("num") int num) {
		if (num % 2 == 0) {
			return "Hmmm...I'm getting something about an adventure. Hope you like to travel! Could be fun. Oh yeah...and scammers are really gonna like ya here soon. Betta watch out for those sly guys!";
		}
		return "Ya workin' hard and makin' lots of money already?! Look at you, huh? All fancy now. Betta relax and enjoy some R&R at granny's house!";
	}
}