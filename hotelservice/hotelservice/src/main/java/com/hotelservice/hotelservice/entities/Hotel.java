package com.hotelservice.hotelservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="hotel_microservice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
	
	
	@Id
	String hotelId;
	String hotelName;
	String hotelAddress;
	String hotelRatings;
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelAddress() {
		return hotelAddress;
	}
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	public String getHotelRatings() {
		return hotelRatings;
	}
	public void setHotelRatings(String hotelRatings) {
		this.hotelRatings = hotelRatings;
	}
	
	
	

}
