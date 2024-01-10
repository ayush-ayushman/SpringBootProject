package com.ty.userservice.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ty.userservice.entity.User;
import com.ty.userservice.service.UserService;
import com.ty.userservice.service.imple.UserServiceImplement;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	private Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User s=userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(s);
		
	}
	//int retrycount=1;
	@GetMapping("/{userid}")
	//@CircuitBreaker(name="ratinghotelbreaker",fallbackMethod ="ratingHotelmethodFallback")
	//@Retry(name="ratinghotelbreaker",fallbackMethod ="ratingHotelmethodFallback")
	  @RateLimiter(name="ratinghotelbreaker",fallbackMethod ="ratingHotelmethodFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable("userid") String userid)
	{
		//logger.info(" retry count{}", retrycount);
		//retrycount++;
		User s=userService.getUser(userid);
		return ResponseEntity.ok(s);
		
	}
	@GetMapping
	public ResponseEntity<List<User>> getAllUser()
	{
		
		List<User> p=userService.getAllUser();
		return ResponseEntity.ok(p);
	}

	public ResponseEntity<User> ratingHotelmethodFallback(String userid,Exception ex)
	{
		//logger.info("service is down",ex.getMessage());
		
		User user=User.builder().email("dummy@gmail.com").name("dummy").about("dummy user").userid("dfghj").build();
		return new ResponseEntity<>(user,HttpStatus.OK);
		
	}
	

}
