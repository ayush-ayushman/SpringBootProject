package com.ty.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ExampleController {
	   @RequestMapping("/ant")
	   public String Example()
	   {
		    return "example1";
		   
	   }
	
}
