package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.VO.ResponseTemplateVO;
import com.booking.entity.Booking;
import com.booking.service.BookingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	

	@PostMapping("/")
	public Booking doBooking(@RequestBody Booking booking) {
		log.info("Inside doBooking method of BookingController");
		
	booking.setBookingAmmount(Math.round((Math.random())*100000));
	booking.setBookingId("VRS21"+booking.getUserId());
		return bookingService.doBooking(booking);
	}
	
	
	@GetMapping("/")
	public List<Booking> findAllBookings() {
	log.info("Inside findAllBookings method of BookingController");
	return bookingService.findAllBookings();	
	}
	
	@GetMapping("/{id}")
	public Booking findBookingsById(@PathVariable("id") String bookingId) {
	log.info("Inside findBookingsById method of  BookingController");
	return bookingService.findBookingsById(bookingId) ;	
	}
	
	/*
	@GetMapping("/{id}")
	public Booking findBookingsByUserId(@PathVariable("id") String userId) {
	log.info("Inside findBookingsByUserId method of  BookingController");
	return bookingService.findBookingsByUserId(userId) ;	
	}
	*/
	
	@GetMapping("/details/{id}")
	public ResponseTemplateVO getAllBookingDetails(@PathVariable("id") Long userId) {
		log.info("Inside getAllBookingDetails method of BookingController");
		return bookingService.getAllBookingDetails(userId);
	}
	
}
