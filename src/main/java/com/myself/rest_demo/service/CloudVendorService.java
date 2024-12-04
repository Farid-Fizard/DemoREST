package com.myself.rest_demo.service;

import com.myself.rest_demo.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    public CloudVendor getCloudVendor(String cloudVendorId);
    public List<CloudVendor> getAllCloudVendors();
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String cloudVendorId);
}
