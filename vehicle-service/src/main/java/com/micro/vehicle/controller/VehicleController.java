package com.micro.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.vehicle.entity.Vehicle;
import com.micro.vehicle.service.VehicleService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/vehicle")
@Slf4j
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping("/")
	public Vehicle saveVehicle(@RequestBody Vehicle vehicle) {
		log.info("Inside saveVehicle method of VehicleController");
		return vehicleService.saveVehicle(vehicle);	
	}
	
	@GetMapping("/")
	public List<Vehicle> findAllVehicles() {
	log.info("Inside findAllVehicles method of VehicleController");
	return vehicleService.findAllVehicles() ;	
	}

	@GetMapping("/{id}")
	public Vehicle findVehicleById(@PathVariable("id") Long vehicleId) {
	log.info("Inside findVehicleById method of VehicleController");
	return vehicleService.findVehicleById(vehicleId) ;	
	}
	
	@GetMapping("/ven/{id}")
	public List<Vehicle> findAllVehicleByVendorId(@PathVariable("id") Long vendorId) {
	log.info("Inside findAllVehicleByVendorId method of VehicleController");
	return vehicleService.findAllVehicleByVendorId(vendorId) ;	
	}
	
}
