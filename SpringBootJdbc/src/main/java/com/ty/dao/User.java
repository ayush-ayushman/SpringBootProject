package com.ty.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class User {
	@Autowired
    private JdbcTemplate jt;
	public User() {
	
		
	}
	public int createTable()
	{
	  String query="CREATE TABLE IF NOT EXISTS User( id int primary key,name varchar(20),age int,city varchar(50))";
	  int u=this.jt.update(query);
	  System.out.println(u);
	  return u;
	}
	public int insertUser(Integer id,String name,Integer age,String city)
	{
		String qry="insert into user(id,name,age,city) values(?,?,?,?)";
		int up=this.jt.update(qry,new Object[] {id,name,age,city});
		return up;
		
	}

}
