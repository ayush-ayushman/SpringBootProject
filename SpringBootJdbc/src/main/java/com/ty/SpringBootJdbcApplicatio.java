package com.ty;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ty.dao.User;
@SpringBootApplication
public class SpringBootJdbcApplicatio implements CommandLineRunner {
    @Autowired
	private User user;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplicatio.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	 System.out.println(this.user.createTable());
	 this.createUser();
		
	}
	public void createUser() throws NumberFormatException, IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the id");
		Integer userId=Integer.parseInt(br.readLine());
		System.out.println("enter the user name");
		String name=br.readLine();
		System.out.println("enter the age");
		Integer age=Integer.parseInt(br.readLine());
		System.out.println("enter the user city");
		String city=br.readLine();
		int i=this.user.insertUser(userId, name, age, city);
		System.out.println(i);
	}

}