package com.api.book.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entity.Book;

@Component
public class BookService {
	@Autowired
	public BookRepository br;
	//private static List<Book> list = new ArrayList<Book>();
	/*static {
		list.add(new Book(1, "sci", "Ayush"));
		list.add(new Book(2, "eng", "Anagha"));
		list.add(new Book(3, "phy", "Arpit"));

	}*/

	public List<Book> getAllBook() {
		List<Book> list=(List<Book>) br.findAll();
		return list;

	}

	// fetching single book
	public Book getSingleBook(int id) {
	/*	for (Book book : list) {
			int i = book.getBid();
			if (id == i)
				return list.get(i);

		}
		return null; */
		Book l=br.findById(id);
		return l;

	}

	// adding book
	public Book AddBook(Book p) {

		//list.add(p);
		//return p;
	Book p1=br.save(p);
		return p1;

	}

	// delete
	public void Delete(int id) {

		//list.remove(id);
		br.deleteById(id);
	}

	// updated
	public Book updated(int id) {
		//Book h = list.get(id);
		//h.setBauthor(" Kirmani");

	//	return h;
		Book m=br.findById(id);
		m.setBauthor("Nagesh");
		br.save(m);
		return m;
	}

}
