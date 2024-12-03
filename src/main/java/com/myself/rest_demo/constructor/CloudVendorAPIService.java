package com.myself.rest_demo.constructor;

import com.myself.rest_demo.model.CloudVendor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIService {
    CloudVendor cloudVendor;
    @GetMapping("{vendorId}")
    public CloudVendor getVendorDetails(String vendorId){
        return  cloudVendor;
//                new CloudVendor("1","RandomName1",
//                "SomewhereOnEarth","055-532-22-12");
    }
    @PostMapping
    public String createVendorDetails(@RequestBody CloudVendor cloudVendor){
        this.cloudVendor=cloudVendor;
        return "Created successfully";
    }

    @PutMapping
    public String updateVendorDetails(@RequestBody CloudVendor cloudVendor){
        this.cloudVendor=cloudVendor;
        return "Updated successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteVendorDetails(String vendorId){
        this.cloudVendor=null;
        return "Deleted successfully";
    }
}
