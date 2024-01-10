package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.entity.User;
import com.example.reposatory.UserRepository;

@SpringBootApplication
public class JpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaExampleApplication.class, args);
		UserRepository user = context.getBean(UserRepository.class);
		User u1=new User();
		//save singal object
	//	u.setName("Anagha");
	//	u.setState("Bengalore");
	//	User t=user.save(u);
		//save multiple user
		//u1.setName("Ayush");
		//u1.setState("new Delhi");
		//User u2=new User();
		//u2.setName("priti");
		//u2.setState("patna");
		//Iterable<User> h=List.of(u1,u2);
		//user.saveAll(h);
		
		//update
		 Optional<User> y=user.findById(2);
		 User j=y.get();
		 j.setState("Bhopal");
		 user.save(j);
		//get 
	//	 Iterable<User> k=user.findAll();
	//	 for (User s : k) {
	//		 System.out.println(s);
			
	//	}
		 //delete
		// user.deleteById(3);
	//	List<User> t= user.findByName("Anagha");
	//	for (User user2 : t) {
	//		System.out.println(user2);
	//	}
	//	List<User> h =user.findByNameAndState("Anagha","Bengalore");
	//	for (User user2 : h) {
	//		System.out.println(user2);
		List<User> g= user.getAllUser();
		for (User user2 : g) {
			System.out.println(user2);
			
		}
		 List<User> x=user.getUserByName("Anagha");
		 for (User user3 : x) {
			 System.out.println(user3);
		
			
		}
			
		List<User> f=user.getuser();
		for (User user2 : f) {
			System.out.println(user2);
			
		}
	}
}
		 
			

	


