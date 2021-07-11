package com.vendor.VO;

import com.vendor.entity.Vendor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

	private Vendor vendor;
	//private Vehicle vehicle;
	
	private Vehicle[] vehicle;
	
}
