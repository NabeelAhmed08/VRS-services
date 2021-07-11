package com.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.booking.VO.BookingVo;
import com.booking.VO.ResponseTemplateVO;
import com.booking.VO.Vehicle;
import com.booking.VO.Vendor;
import com.booking.entity.Booking;
import com.booking.repository.BookingRepository;


@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	

	@Autowired
	private RestTemplate restTemplate;
	
	public Booking doBooking(Booking booking) {
		
		return bookingRepository.save(booking);
	}

	public List<Booking> findAllBookings() {
		
		return bookingRepository.findAll();
	}

	public Booking findBookingsById(String bookingId) {
	
		return bookingRepository.findById(bookingId).get();
	}

	
	public ResponseTemplateVO getAllBookingDetails(Long userId) {
	
		
		
		ResponseTemplateVO vo = new ResponseTemplateVO();
	    //Vendor vendor =	vendorRepository.findById(vendorId).get();
		
		Booking bo = this.bookingRepository.findByUserId(userId) ;
    
		BookingVo bookingVo = new BookingVo();
		bookingVo.setBookingId(bo.getBookingId() );
		bookingVo.setNoOfHoursBooked(bo.getNoOfHoursBooked());
		bookingVo.setBookingAmmount(bo.getBookingAmmount());
		bookingVo.setVehicleId(bo.getVehicleId());
	
		// we can get vehicle id from bookingVo 
		
	
	    String url = "http://VEHICLE-SERVICE/vehicle/"+bookingVo.getVehicleId();
	    Vehicle vehicle  = restTemplate.getForObject(url, Vehicle.class);

		// we can get vendor id from vehicle 
	   
	    String vurl = "http://VENDOR-SERVICE/vendors/"+vehicle.getVendorId();
	    Vendor vendor  = restTemplate.getForObject(vurl, Vendor.class);
	   
	    vo.setBookingDetails(bookingVo);
	    vo.setBookedVehicle(vehicle);
	    vo.setVendor(vendor);;
		return vo;

	
	}

}
