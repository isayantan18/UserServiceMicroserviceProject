package com.hotelservice.hotelservice.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.hotelservice.hotelservice.entities.Hotel;
import com.hotelservice.hotelservice.repository.HotelServiceRepository;
import com.hotelservice.hotelservice.services.HotelServices;

@Service
public class HotelServiceImpl implements HotelServices{
	
	@Autowired
	private HotelServiceRepository hotelRepo;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		String randomId = UUID.randomUUID().toString();
		hotel.setHotelId(randomId);
		
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getHotel(String hotelId) {
		
		return hotelRepo.findById(hotelId).orElseThrow();
	}
	
	public List<Hotel> getHotelById(String hotelId){
		
		return hotelRepo.findByHotelId(hotelId);
	}

	@Override
	public List<Hotel> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
