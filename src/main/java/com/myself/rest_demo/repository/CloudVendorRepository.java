package com.myself.rest_demo.repository;

import com.myself.rest_demo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, Long> {
}
