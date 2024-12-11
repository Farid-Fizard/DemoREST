package com.myself.rest_demo.repository;

import com.myself.rest_demo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, Long> {

    //getVendorByName is created for only the testing purposes;
    List<CloudVendor> getVendorByVendorName(String vendorName);
}
