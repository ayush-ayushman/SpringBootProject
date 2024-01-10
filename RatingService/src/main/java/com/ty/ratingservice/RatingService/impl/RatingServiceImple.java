package com.ty.ratingservice.RatingService.impl;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.ratingservice.RatingService.RatingService;
import com.ty.ratingservice.entity.Rating;
import com.ty.ratingservice.repository.RatingRepository;
@Service
public class RatingServiceImple implements RatingService{
    @Autowired
    private RatingRepository ratingRepository;

	@Override
	public Rating saveRating(Rating rating) {
		String s=UUID.randomUUID().toString();
		rating.setRatingId(s);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByuserId(String userId) {
		
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByhotelId(String hotelId) {
		
		return ratingRepository.findByHotelId(hotelId);
	}
	

}
