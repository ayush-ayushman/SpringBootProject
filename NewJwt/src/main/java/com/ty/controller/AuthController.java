package com.ty.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ty.entity.JwtRequest;
import com.ty.entity.JwtResponse;
import com.ty.entity.RefreshToken;
import com.ty.entity.User;
import com.ty.model.RefreshTokenRequest;
import com.ty.repositories.UserRepository;
import com.ty.security.jwtauthentication.JwtHelper;
import com.ty.service.RefreshTokenService;
import com.ty.service.UserService;
import io.jsonwebtoken.Jwt;
@RestController
@RequestMapping("/auth")
public class AuthController {
	 @Autowired
	    private UserDetailsService userDetailsService;

	    @Autowired
	    private AuthenticationManager manager;
	    @Autowired
	    private UserService userService;
	    @Autowired
        private RefreshTokenService refreshTokenService;

	    @Autowired
	    private JwtHelper helper;

	    private Logger logger = LoggerFactory.getLogger(AuthController.class);


	    @PostMapping("/login")
	    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

	        this.doAuthenticate(request.getEmail(), request.getPassword());


	        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
	        String token = this.helper.generateToken(userDetails);
	        RefreshToken refreshToken=refreshTokenService.createRefreshToken(userDetails.getUsername());
	        

	        JwtResponse response = JwtResponse.builder()
	                .jwtToken(token)
	                .refreshToken(refreshToken.getRefreshToken())
	                .username(userDetails.getUsername()).build();
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    private void doAuthenticate(String email, String password) {

	        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
	        try {
	            manager.authenticate(authentication);


	        } catch (BadCredentialsException e) {
	            throw new BadCredentialsException(" Invalid Username or Password  !!");
	        }

	    }

	    @ExceptionHandler(BadCredentialsException.class)
	    public String exceptionHandler() {
	        return "Credentials Invalid !!";
	    }
	    @PostMapping("/create-user")
	    public User createUser(@RequestBody User user)
	    {
			return userService.CreateUser(user);
	    	
	    }
	    @PostMapping("/refresh")
	    public JwtResponse refreshJwtToken(@RequestBody RefreshTokenRequest request)
	    {
	    	RefreshToken refreshToken=refreshTokenService.varifyRefreshToken(request.getRefreshToken());
	    	User user=refreshToken.getUser();
	    	String token=this.helper.generateToken(user);
			return JwtResponse.builder().refreshToken(refreshToken.getRefreshToken()).jwtToken(token)
					.username(user.getEmail())
					.build();
	    	
	    }

}
