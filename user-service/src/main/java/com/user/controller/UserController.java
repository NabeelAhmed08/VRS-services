package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;



import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	

	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("Inside saveUser method of UserController");
		user.setEnabled(true);
		return userService.saveUser(user);
	}
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public List<User> findAllUsers() {
	log.info("Inside findAllUser method of UserController");
	return userService.findAllUsers();	
	}
	
	@GetMapping("/{id}")
	public User findUserById(@PathVariable("id") Long userId) {
	log.info("Inside findUserById method of UserController");
	return userService.findUserById(userId) ;	
	}
	
	/*
	@GetMapping("/vehicle/{id}")
	public ResponseTemplateVO getVendorWithVehicle(@PathVariable("id") Long vendorId) {
		log.info("Inside getVendorWithVehicle method of VendorController");
		return userService.getVendorWithVehicle(vendorId);
	}
	*/
}
