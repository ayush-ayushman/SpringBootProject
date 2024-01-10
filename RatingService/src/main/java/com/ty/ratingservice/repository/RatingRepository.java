package com.ty.ratingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.ratingservice.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{
	//custom
	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);

}
