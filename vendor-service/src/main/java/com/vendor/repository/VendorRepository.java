package com.vendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vendor.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
