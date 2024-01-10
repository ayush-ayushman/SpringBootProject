package com.ty.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.entity.User;
import com.ty.service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private UserService userservice;
	@GetMapping("/user")
	public List<User> getUser()
	{
		return userservice.getUsers();
		
	}
	@GetMapping("/current")
	public String getCurrentUser(Principal principal)
	{
		return principal.getName();
		
	}

}
