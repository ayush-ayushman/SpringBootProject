package com.ty.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hotel.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{
	

}
