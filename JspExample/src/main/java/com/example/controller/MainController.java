package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String home()
	{
		System.out.println("HOME");
		return "home";
		
	}
	@RequestMapping("/con")
	public String contact()
	{
		System.out.println("contact");
		return "contact";
		
	}

}
