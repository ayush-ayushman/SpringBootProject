package com.jwt.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class Main {
	@RequestMapping("/app")
	public String first()
	{
		return "home";
		
	}

}
