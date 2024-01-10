package com.ty.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.entity.User;

public interface UserRepository  extends JpaRepository<User,String>{
	
   public Optional<User> findByEmail(String email);
   
}
