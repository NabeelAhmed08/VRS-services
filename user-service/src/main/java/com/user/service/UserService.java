package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) {
		log.info("Inside saveVehicle method of userService");
	
		return userRepository.save(user);
	}

	public List<User> findAllUsers() {
		log.info("Inside findAllUsers method of userService");
		return userRepository.findAll();
	}

	public User findUserById(Long userId) {
		log.info("Inside findUserById method of userService");
		return userRepository.findById(userId).get();
	}

}
