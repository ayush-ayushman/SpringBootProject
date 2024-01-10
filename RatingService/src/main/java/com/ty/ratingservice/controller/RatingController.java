package com.ty.ratingservice.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.ratingservice.RatingService.RatingService;
import com.ty.ratingservice.entity.Rating;

@RestController
@RequestMapping("/rating")
public class RatingController {
	@Autowired
	private RatingService ratingService;
	
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating)
	{

		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
		
	}
	@PreAuthorize("hasAuthority('SCOPE_internal')|| hasAuthority('Admin')")
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingByuserId(@PathVariable  String userId)
	{
		return ResponseEntity.ok(ratingService.getRatingByuserId(userId));
	
	}
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getSingleHotelId(@PathVariable String hotelId)
	{
		return ResponseEntity.ok(ratingService.getRatingByhotelId(hotelId));
		
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAll()
	{
		return ResponseEntity.ok(ratingService.getAllRating());
		
	}

}
