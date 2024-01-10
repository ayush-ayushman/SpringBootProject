package com.ty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiUsingSpringDataRestApplication implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepository;
	public static void main(String[] args) {
		SpringApplication.run(ApiUsingSpringDataRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book bk=new Book();
		bk.setBookid(120);
		bk.setBookname("Basic physics");
		bk.setSubject("physics");
		bk.setAuthor("Ayush Ayushman");
		this.bookRepository.save(bk);
		Book bk1=new Book();
		bk1.setBookid(121);
		bk1.setBookname("Basic chemistry");
		bk1.setSubject("chemistry");
		bk1.setAuthor("Angha Ramesh");
		this.bookRepository.save(bk1);
		
		
	}

}
