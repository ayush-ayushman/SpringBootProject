package com.ty.dao;

import org.springframework.data.repository.CrudRepository;

import com.ty.dto.Book;

public interface Crud extends CrudRepository<Book, Integer>  {
	public Book findByBname(String name);

}
