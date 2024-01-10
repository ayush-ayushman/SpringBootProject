package com.ty.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.ty.model.EmailRequest;
import com.ty.service.EmailService;

@RestController
public class EmailController {
	@Autowired
	private EmailService emailservice;
	@RequestMapping("/wel")
	public String welcome()
	{
		return "welcome";
		
	}
	@RequestMapping(value="/sendemail",method=RequestMethod.POST)
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request)
	{
		System.out.println(request);
	    this.emailservice.sendEmail(request.getSubject(),request.getMessage(),request.getTo());
		
		    return ResponseEntity.ok("done");
		
		}
		
	

}
