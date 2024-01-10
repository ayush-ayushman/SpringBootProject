package com.ty.userservice.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.ty.userservice.entity.Rating;
@Service
@FeignClient(name = "RATINGSERVICE")
public interface RatingService {
	@PostMapping("/rating")
	public Rating creatRating(Rating values);

	@PutMapping("/rating/{ratingId}")
	public Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

	@DeleteMapping("/rating/{ratingId}")
	public void deleteRating(@PathVariable("ratingId") String ratingId);

}
