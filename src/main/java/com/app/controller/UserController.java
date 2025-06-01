package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.entity.User;
import com.app.service.UserService;

@Controller
@ComponentScan(basePackages = {"com.app", "com.app.controller", "com.app.entity", "com.app.repo", "com.app.service", "src/maim/resources/templates"})
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public String register(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return"register";
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute("user") User user) {
		System.out.println(user);
		service.registerUser(user);
		return"home";
	}

}
