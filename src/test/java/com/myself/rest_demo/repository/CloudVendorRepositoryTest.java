package com.myself.rest_demo.repository;

import com.myself.rest_demo.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CloudVendorRepositoryTest {
    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor= new CloudVendor(1L,"Amazon",
                "USA","xxx-xxx-xx-xx");
        cloudVendorRepository.save(cloudVendor);

    }

    @AfterEach
    void tearDown() {
        cloudVendor=null;
        cloudVendorRepository.deleteAll();
    }

    // Test case SUCCESS
    @Test
    void testFindByVendorName_Found(){
        List<CloudVendor> cloudVendorList= cloudVendorRepository.getVendorByVendorName("Amazon");
        assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(cloudVendorList.get(0).getVendorAddress());

    }

}
