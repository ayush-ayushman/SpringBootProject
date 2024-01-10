package com.ty.ratingservice.RatingService;
import java.util.List;
import com.ty.ratingservice.entity.Rating;
public interface RatingService {
	Rating saveRating(Rating rating);
	List<Rating> getAllRating();
	List<Rating> getRatingByuserId(String userId);
	List<Rating> getRatingByhotelId(String hotelId);
}
