package com.example.reposatory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.entity.User;

public interface UserRepository  extends CrudRepository<User, Integer>{
	public List<User> findByName(String name);
	public List<User> findByNameAndState(String name,String state);
	
	//jpql
	@Query("select u from User u")
	public List<User> getAllUser();
	//jpql
	@Query("select u from User  u where u.name=:m")
	public List<User> getUserByName(@Param("m") String name);
	//native 
	@Query(value="select * from user", nativeQuery = true)
	public List<User> getuser();
	
	
   
}
