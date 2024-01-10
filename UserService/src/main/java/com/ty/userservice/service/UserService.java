package com.ty.userservice.service;
import java.util.List;
import com.ty.userservice.entity.User;

public interface UserService {
	
	User saveUser(User user);
	List<User> getAllUser();
	User getUser(String userid);
	
	
	

}
