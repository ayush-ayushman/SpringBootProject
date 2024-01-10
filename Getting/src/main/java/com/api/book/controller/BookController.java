package com.api.book.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.dao.BookRepository;
import com.api.book.entity.Book;
import com.api.book.services.BookService;
@RestController
public class BookController {
	
 	@Autowired
 	BookService op;
 /*	@GetMapping("/books")
	public Book getBooks()
	{
		Book b=new Book();
		b.setBid(100);
		b.setBname("Math");
		b.setBauthor("Ayush");
		return b; 
		
		
	} */
	//@GetMapping("/books")
/*	public List<Book> getBooks()
	{
		
		return op.getAllBook(); 
		
		
	} */
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks()
	{
		
		List<Book> lis=op.getAllBook(); 
		if(lis.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
		}
		return ResponseEntity.of(Optional.of(lis));
		
		
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id)
	{
		
		Book n= op.getSingleBook(id) ;
		if(n==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(n));
		
		
	}
	@PostMapping("/addbook")
	public Book addbook(@RequestBody Book l)
	{
		return op.AddBook(l);
	}
	@DeleteMapping("/bookdelete/{id}")
	public void deleted(@PathVariable("id") int id)
	{
		
		op.Delete(id);
		System.out.println("item has been removed");
	}
	@PutMapping("/updatebook/{id}")
	public Book UpdateBook(@PathVariable("id") int id)
	{
		Book l=op.updated(id);
		return l;
		
	} 
	
	

}
