package com.myself.rest_demo.controller;

import com.myself.rest_demo.model.CloudVendor;
import com.myself.rest_demo.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("{vendorId}")
    public CloudVendor getVendorDetails( @PathVariable("vendorId") String vendorId){
        return  cloudVendorService.getCloudVendor(vendorId);
    }
    @GetMapping()
    public List<CloudVendor> getAllVendorDetails(){
        return  cloudVendorService.getAllCloudVendors();
    }
    @PostMapping
    public String createVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Created successfully";
    }

    @PutMapping
    public String updateVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Updated successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteVendorDetails( @PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Deleted successfully";
    }
}
