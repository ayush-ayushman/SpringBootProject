package com.ty.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ty.dao.Crud;
import com.ty.dto.Book;
@Component
public class BookService {
	@Autowired
	public Crud cr;
	public List<Book> getAllBook()
	{
		List<Book> bk=(List<Book>) cr.findAll();
		return bk ;
		
	}
	public Book getBookByName(String nm)
	{
		Book h=cr.findByBname(nm);
		return h ;
		
		
	}
	public void DeletedBook(int id)
	{
		cr.deleteById(id);
		System.out.println("deleted successfully");
		
		
	}
	public Book getBookId(int n)
	{
		Optional<Book> r=cr.findById(n);
		 Book l=r.get();
		return l;
		
	}
	public Book Update(int id)
	{
		Optional<Book> n=cr.findById(id);
		Book l=n.get();
		l.setBname("Physical Chemistry");
		return cr.save(l);
	}
	public Book saveBook(Book op)
	{
		Book pl=cr.save(op);
		
		return pl;
		
	}
	
	

}
