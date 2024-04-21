package com.lcwd.user.service.Impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.common.util.concurrent.RateLimiter;
import com.lcwd.user.service.Repository.UserRepository;
import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Ratings;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourseNotFoundException;
import com.lcwd.user.service.services.UserService;

import ch.qos.logback.classic.Logger;
import jakarta.websocket.server.ServerEndpoint;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RestTemplate restTemplate;

	private Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAlUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub

		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourseNotFoundException("user Not found on server !!" + userId));
		
		  Ratings[] forObj = restTemplate.getForObject("http://RATINGSERVICE/rating/user/"+user.getUserId(),Ratings[].class); 
		  logger.info("{}",forObj); 
		  
		  List<Ratings> forObjList = Arrays.stream(forObj).toList();
		  
		  //user.setRatings(forObj);
			
			/*
			 * List<Ratings> forObjListHotel = forObjList.stream().map(rating->{
			 * ResponseEntity<Hotel> hotelForEntity =
			 * restTemplate.getForEntity("http://localhost:8082/hotel/"+rating.getHotelId(),
			 * Hotel.class);
			 * 
			 * Hotel hotel = hotelForEntity.getBody(); rating.setHotel(hotel);
			 * 
			 * return rating ; //logger.info("Response Status")
			 * }).collect(Collectors.toList());
			 */
				
			 // HashMap<Ratings, String> mapRating = new HashMap<Ratings, String>();
		  
		  
			  List<Ratings> listRating = new ArrayList<Ratings>();
			  
				  for(Ratings rating : forObjList) {
					  
					  //Call API
					 Hotel[] hotelEntity = restTemplate.getForObject("http://HOTELSERVICE/hotel/"+rating.getHotelId(), Hotel[].class);
					 
					 // Array to List Convert
					 List<Hotel> forObjListhotel = Arrays.stream(hotelEntity).toList();
					  
					 for(Hotel hotel : forObjListhotel) {
						 rating.setHotel(hotel);
					 }
					 
				  }
				 
			
		  user.setRatings(forObjList);
		  
		return user;
	}

}
