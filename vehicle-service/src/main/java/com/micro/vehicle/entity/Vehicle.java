package com.micro.vehicle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vehicleId;
	private String vehicleName;
	private String vehicleNumber;
	private String vehicleMake;
	private String vehicleColour;
	private String vehicleType;
	
	@NotNull
	private Long vendorId;
	
	private int noOfSeat;
	private boolean isAvailable;
	
	
}
