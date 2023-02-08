package com.randyluc.BurgerTrackerhw.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.randyluc.BurgerTrackerhw.models.Burger;
import com.randyluc.BurgerTrackerhw.services.BurgerServ;

@Controller
public class BurgerController {
	@Autowired
	BurgerServ BurgerServ;
	
	@GetMapping("/")
	public String home(@ModelAttribute("burger")Burger burger, Model model) {
		List<Burger>burgers = BurgerServ.allburgers();
		model.addAttribute("burgers",burgers);
		return "index.jsp";
	}
	@PostMapping("/addburger")
	public String home(@Valid @ModelAttribute("burger")Burger burger,BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Burger>burgers = BurgerServ.allburgers();
			model.addAttribute("burgers",burgers);
			return "index.jsp";
		}
		BurgerServ.addBurger(burger);
		return"redirect:/";
	}
}
