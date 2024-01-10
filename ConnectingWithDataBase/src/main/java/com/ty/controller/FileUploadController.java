package com.ty.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ty.helper.FileUploadHelper;
@RestController
public class FileUploadController {
	@Autowired
	private FileUploadHelper fu;
	@PostMapping("/uploadfile")
	public ResponseEntity<String> uploadfile(@RequestParam("anyname") MultipartFile anyname )
	{
		try {
			
		
		if(anyname.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain file");
		}
		if(!anyname.getContentType().equals("image/jpeg"))
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only jpeg file");
		}
		boolean f=fu.uplaodfile(anyname);
		if(f=true)
		{
			//return ResponseEntity.ok("File upload successfully");
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(anyname.getOriginalFilename()).toUriString());
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR ).body("SOME PROBLEM IS ENCOUNTER");
		
	}

}
