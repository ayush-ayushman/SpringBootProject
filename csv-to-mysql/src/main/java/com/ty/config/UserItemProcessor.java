package com.ty.config;

import org.springframework.batch.item.ItemProcessor;

import com.ty.model.User;

public class UserItemProcessor implements ItemProcessor<User,User> {

	@Override
	public User process(User user) throws Exception {
		
		return user;
	}

	

	

}
