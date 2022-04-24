package com.codingdojo.fruityloops.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.fruityloops.models.Item;

@Controller
public class ItemController {

	@RequestMapping("/")
	public String index(Model model) {
		
		ArrayList<Item> fruits = new ArrayList<Item>();
        fruits.add(new Item("Bushhukan (Buddha's Hand)", 5.5));
        fruits.add(new Item("Kumquat", 2.75));
        fruits.add(new Item("Rambutan", 4.0));
        fruits.add(new Item("Lychee", 3.75));
        fruits.add(new Item("Pitaya (Dragon Fruit)", 4.25));
        
        // Add fruits from your view model here
        model.addAttribute("fruitsFromMyController", fruits);
		
        return "index.jsp";
        
	}
}
