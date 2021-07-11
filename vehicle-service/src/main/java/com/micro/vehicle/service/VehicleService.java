package com.micro.vehicle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.vehicle.entity.Vehicle;
import com.micro.vehicle.repository.VehicleRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public Vehicle saveVehicle(Vehicle vehicle) {
		log.info("Inside saveVehicle method of vehicleService");
		
		return vehicleRepository.save(vehicle);
	}

	public Vehicle findVehicleById(Long vehicleId) {
		log.info("Inside findVehicleById method of vehicleService");
		
		return vehicleRepository.findById(vehicleId).get();
	}

	public List<Vehicle> findAllVehicles() {
		log.info("Inside findAllVehicles method of vehicleService");
		return vehicleRepository.findAll();
	}

	public List<Vehicle> findAllVehicleByVendorId(Long vendorId) {
		log.info("Inside findAllVehicleByVendorId method of vehicleService");
		return vehicleRepository.findByVendorId(vendorId);
	}
}
