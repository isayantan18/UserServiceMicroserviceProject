package com.ratings.RatingService.services;

import java.util.List;

import com.ratings.RatingService.entities.Rating;
import com.ratings.RatingService.repository.RatingRepository;

public interface RatingService{
	
	Rating saveRatings(Rating ratings);
	
	List<Rating> getAllRatings();

	List<Rating> getRatingbyUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);
	
	
	
}
