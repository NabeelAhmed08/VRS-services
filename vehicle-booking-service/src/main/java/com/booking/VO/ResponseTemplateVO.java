package com.booking.VO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

	private BookingVo bookingDetails;
	private Vehicle bookedVehicle;
	private Vendor vendor;
	
}
