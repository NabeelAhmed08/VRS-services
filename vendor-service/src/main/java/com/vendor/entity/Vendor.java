package com.vendor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vendorId;
	private String vendorName;
	private String email;
	private String password;
	private String role;
	private boolean isEnabled;
	
	
}
