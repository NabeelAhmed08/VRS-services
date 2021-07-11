package com.vendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vendor.VO.ResponseTemplateVO;
import com.vendor.VO.Vehicle;
import com.vendor.entity.Vendor;
import com.vendor.repository.VendorRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VendorService {

	@Autowired
	private VendorRepository vendorRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public Vendor saveVendor(Vendor vendor) {
		log.info("Inside saveVendor method of vendorService");
		
		return vendorRepository.save(vendor);
	}

	public Vendor findVendorById(Long vendorId) {
		log.info("Inside findVendorById method of vendorService");
		
		return vendorRepository.findById(vendorId).get();
	}

	public List<Vendor> findAllVendors() {
	
		log.info("Inside findAllVendors method of vendorService");
		
		return vendorRepository.findAll();
	}

	public ResponseTemplateVO getVendorWithVehicle(Long vendorId) {
		log.info("Inside getVendorWithVehicle method of vendorService");
		
		ResponseTemplateVO vo = new ResponseTemplateVO();
	    Vendor vendor =	vendorRepository.findById(vendorId).get();
		
	    String url = "http://VEHICLE-SERVICE/vehicle/ven/"+vendor.getVendorId();
	   System.out.println(url);
	   // Vehicle vehicle = restTemplate.getForObject(url, Vehicle.class);
	   Vehicle[] vehicle  = restTemplate.getForObject(url, Vehicle[].class);
	    vo.setVehicle(vehicle);
	    vo.setVendor(vendor);
		return vo;
	}

/*
	public ResponseTemplateVO getVendorWithVehicle(Long vendorId) {
		log.info("Inside getVendorWithVehicle method of vendorService");
		
		ResponseTemplateVO vo = new ResponseTemplateVO();
	    Vendor vendor =	vendorRepository.findById(vendorId).get();
		
	    String url = "http://localhost:9001/vehicle/ven/"+vendor.getVendorId();
	   System.out.println(url);
	   // Vehicle vehicle = restTemplate.getForObject(url, Vehicle.class);
	    Vehicle vehicle = restTemplate.getForObject(url, Vehicle.class);
	    vo.setVehicle(vehicle);
	    vo.setVendor(vendor);
		return vo;
	}
	
*/	
	}

