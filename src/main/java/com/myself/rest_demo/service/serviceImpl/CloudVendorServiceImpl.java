package com.myself.rest_demo.service.serviceImpl;

import com.myself.rest_demo.exception.CloudVendorNotFoundException;
import com.myself.rest_demo.model.CloudVendor;
import com.myself.rest_demo.repository.CloudVendorRepository;
import com.myself.rest_demo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {
    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public CloudVendor getCloudVendor(Long cloudVendorId) {
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested cloud vendor doesn't exist");
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Created Successfully";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Updated Successfully";
    }

    @Override
    public String deleteCloudVendor(Long cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Deleted Successfully";
    }
}
