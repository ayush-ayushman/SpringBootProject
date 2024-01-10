package com.ty.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.ty.entity.LoginData;
@Controller
public class MainController  {
	@GetMapping("/open")
	public String openform(Model mo)
	{
		System.out.println("opening form");
		mo.addAttribute("loginData", new LoginData());
		return "form";
	}
	@PostMapping("/process")
	public String checkPersonInfo(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult bindingResult) {
        System.out.println(bindingResult);
		if (bindingResult.hasErrors()) {
			 System.out.println(bindingResult);
			return "form";
		}
        System.out.println(loginData);
		return "success";
	}

}
