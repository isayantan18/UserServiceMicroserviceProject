package com.ratings.RatingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratings.RatingService.entities.Rating;
import com.ratings.RatingService.services.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingServiceController {
	
	@Autowired
	RatingService ratingServ;
	
	@PostMapping("/createrating")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		Rating saveRating = ratingServ.saveRatings(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveRating);
		
	}
	
	@GetMapping("/getAllRatings")
	public ResponseEntity<List<Rating>> getAllRatings(){
		
		List<Rating> allRatings = ratingServ.getAllRatings();
		
		return ResponseEntity.ok(allRatings);
	}
	
	/*
	 * @GetMapping("/{ratingId}") public ResponseEntity<Rating>
	 * getRatingById(@PathVariable String ratingId){
	 * 
	 * Rating getRatingById = ratingServ.getRating(ratingId); return
	 * ResponseEntity.ok(getRatingById); }
	 */
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingByuserId(@PathVariable String userId){
		
		//List<Rating> getRatingByuserId = ratingServ.getRatingbyUserId(userId);
		return ResponseEntity.ok(ratingServ.getRatingbyUserId(userId));
	}
	
	@GetMapping("/hotel/{hoteId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(String hotelId){
		
		return ResponseEntity.ok(ratingServ.getRatingByHotelId(hotelId));
	}
}
