package com.ratings.RatingService.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ratings.RatingService.entities.Rating;
import com.ratings.RatingService.repository.RatingRepository;
import com.ratings.RatingService.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository ratingRepo;
	
	@Override
	public Rating saveRatings(Rating ratings) {
		
		String randomId = UUID.randomUUID().toString();
		ratings.setRatingId(randomId);
		
		return ratingRepo.save(ratings);
	}

	@Override
	public List<Rating> getAllRatings() {
		// TODO Auto-generated method stub
		return ratingRepo.findAll();
	}

	public List<Rating> getRatingbyUserId(String userId) {
		
		return ratingRepo.findByUserId(userId);
	}
	
	public List<Rating> getRatingByHotelId(String hotelId){
		
		return ratingRepo.findByHotelId(hotelId);
	}


}
