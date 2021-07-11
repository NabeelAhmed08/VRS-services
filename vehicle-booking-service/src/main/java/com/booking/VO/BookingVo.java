package com.booking.VO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingVo {

	@Id
	private String bookingId;
	private double bookingAmmount;
	private int noOfHoursBooked;
	private Long vehicleId;
	
}
