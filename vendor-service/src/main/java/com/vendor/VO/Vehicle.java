package com.vendor.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
	
	private Long vehicleId;
	private String vehicleName;
	private String vehicleNumber;
	private String vehicleMake;
	private String vehicleColour;
	private String vehicleType;
	private Long vendorId;
	private int noOfSeat;
	private boolean isAvailable;
}