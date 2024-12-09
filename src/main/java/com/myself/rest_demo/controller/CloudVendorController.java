package com.myself.rest_demo.controller;

import com.myself.rest_demo.model.CloudVendor;
import com.myself.rest_demo.response.APIResponse;
import com.myself.rest_demo.response.ResponseHandler;
import com.myself.rest_demo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<APIResponse<CloudVendor>> getVendorDetails(@PathVariable("vendorId") Long vendorId){
        return  ResponseHandler.responseBuilder("Requested vendor details", HttpStatus.OK,
                cloudVendorService.getCloudVendor(vendorId));
    }
    @GetMapping()
    public ResponseEntity<APIResponse<List<CloudVendor>>> getAllVendorDetails(){
        return ResponseHandler.responseBuilder("Details of every vendor", HttpStatus.OK,
                cloudVendorService.getAllCloudVendors());

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
    public String deleteVendorDetails( @PathVariable("vendorId") Long vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Deleted successfully";
    }
}
