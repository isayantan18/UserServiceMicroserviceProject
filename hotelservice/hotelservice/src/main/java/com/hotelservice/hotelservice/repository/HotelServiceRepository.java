package com.hotelservice.hotelservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelservice.hotelservice.entities.Hotel;

public interface HotelServiceRepository extends JpaRepository<Hotel, String>{

	
	List<Hotel> findByHotelId(String hotelId);
}
