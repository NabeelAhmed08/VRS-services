package com.vendor.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendor.VO.ResponseTemplateVO;
import com.vendor.entity.Vendor;
import com.vendor.service.VendorService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/vendors")
@Slf4j
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	@PostMapping("/")
	public Vendor saveVendor(@RequestBody Vendor vendor) {
		log.info("Inside saveVendor method of VendorController");
		return vendorService.saveVendor(vendor);
	}
	
	@GetMapping("/")
	public List<Vendor> findAllVendors() {
	log.info("Inside findAllVendors method of VendorController");
	return vendorService.findAllVendors() ;	
	}

	@GetMapping("/{id}")
	public Vendor findVendorById(@PathVariable("id") Long vendorId) {
	log.info("Inside findVendorById method of VendorController");
	return vendorService.findVendorById(vendorId) ;	
	}
	
	@GetMapping("/vehicle/{id}")
	public ResponseTemplateVO getVendorWithVehicle(@PathVariable("id") Long vendorId) {
		log.info("Inside getVendorWithVehicle method of VendorController");
		return vendorService.getVendorWithVehicle(vendorId);
	}
	
}
