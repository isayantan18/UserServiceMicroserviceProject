package com.hotelservice.hotelservice.controller;

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

import com.hotelservice.hotelservice.entities.Hotel;
import com.hotelservice.hotelservice.services.HotelServices;

import jakarta.ws.rs.POST;

@RestController
@RequestMapping("/hotel")
public class HotelServiceController {
	
	@Autowired
	private HotelServices hotelServ;
	
	@PostMapping("/createhotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		
		Hotel hotelVal = hotelServ.saveHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelVal);
	}
	
	@GetMapping("/gethotels")
	public List<Hotel> getAlHotels() {
		// TODO Auto-generated method stub
		return hotelServ.getAllHotel();
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<List<Hotel>> getRatingByHotelId(@PathVariable String  hotelId){
		
		return ResponseEntity.ok(hotelServ.getHotelById(hotelId));
	}

	 

}
