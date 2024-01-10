package com.ty.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
