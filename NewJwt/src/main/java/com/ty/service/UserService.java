package com.ty.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ty.entity.User;
import com.ty.repositories.UserRepository;

@Service
public class UserService {
	//private List<User> store=new ArrayList<>();

/*	public UserService() {
		
	}
	public List<User> getUsers()
	{
		return this.store;
		
	}
	*/
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	public List<User> getUsers()
	{
		return userRepository.findAll();
		
	}
	public User CreateUser(User user)
	{
		user.setId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	

}
