package com.ty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class Javascriptcontroller extends ThymeleafController
{
	   @RequestMapping("/example")
	   public String Example()
	   {
		return "example";
		   
	   }
	

}
