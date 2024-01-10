package com.ty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ty.dto.Book;
import com.ty.service.BookService;
@RestController
public class MainController {
	@Autowired
	public BookService dt;
	@PostMapping("/addbook")
	public Book storeBook(@RequestBody Book book)
	{
		return dt.saveBook(book);
	}
	@GetMapping("/getall")
	public List<Book> getall()
	{
	 List<Book>	 k=dt.getAllBook();
		return k;
		
	}
	@GetMapping("/getsingle/{id}")
	public Book getsingl(@PathVariable("id") int id)
	{
		Book l=dt.getBookId(id);
		return l;
		
	}
	@PutMapping("/updatebook/{id}")
	public Book updateBook(@PathVariable("id") int id)
	{
		Book h=dt.Update(id);
		return h;
		
	}
	@GetMapping("/byname/{name}")
	public Book getByname(@PathVariable("name") String nap)
	{
		Book st=dt.getBookByName(nap);
		return st;
		
	}
	@DeleteMapping("/delete/{id}")
	public void deleted(@PathVariable("id") int id)
	{
		dt.DeletedBook(id);
	}

}
