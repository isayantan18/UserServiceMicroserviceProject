package com.hotelservice.hotelservice.services;

import java.util.List;

import com.hotelservice.hotelservice.entities.Hotel;
import com.hotelservice.hotelservice.repository.HotelServiceRepository;

public interface HotelServices {
	
	Hotel saveHotel(Hotel hotel);
	
	List<Hotel> getAllHotel();
	
	Hotel getHotel(String hotelId);
	
	List<Hotel> getHotelById(String hotelId);
	
	List<Hotel> getRatingByHotelId(String hotelId);
	

}
