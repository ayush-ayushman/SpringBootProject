package com.ty.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ThymeleafController {
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String about(Model mo)
	{
		mo.addAttribute("nm","Anagha");
		System.out.println("Ayush Ayushman");
		return "about";	
	}
	@RequestMapping(value="/loop",method=RequestMethod.GET)
	public String looping(Model mo)
	{
		List<String> st=List.of("ayush","ayushman","new delhi","mumbai");
		mo.addAttribute("key",st);
		
		return "looping";	
	}
	@RequestMapping(value="/condition" ,method=RequestMethod.GET)
	public String ConditionOperator(Model m)
	{
		m.addAttribute("isActive", true);
		m.addAttribute("gender", "m");
		List<Integer> it=List.of(1);
		m.addAttribute("list", it);
		return "condition";
		
	}
	@GetMapping("/footer")
	public String fragmentHandler(Model m)
	{
		m.addAttribute("m","Ayush");
		m.addAttribute("n","Ayushman");
		return "fragment";
		
	}
	@GetMapping("/about")
	public String aboutnew(Model m)
	{
		
		return "aboutnew";
		
	}
	@GetMapping("/contect")
	public String contect(Model m)
	{
		
		return "contect";
		
	}
} 
