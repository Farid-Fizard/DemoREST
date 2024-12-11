package com.myself.rest_demo.service.serviceImpl;

import com.myself.rest_demo.model.CloudVendor;
import com.myself.rest_demo.repository.CloudVendorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


//@ExtendWith(MockitoExtension.class) alternativ olaraq istifade ederek
// autoClosable ile mockingin yaradilmasini ve baglamasini manual olaraq yazmaqdan qurtulmaq olar

class CloudVendorServiceImplTest {
    @Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorServiceImpl cloudVendorService;
    CloudVendor cloudVendor;
    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor = new CloudVendor(1L, "Google", "USA", "xxx-xxx-xx-xx");

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    // Test cases SUCCESS
    @Test
    void testGetCloudVendor() {
        when(cloudVendorRepository.findById(Long.valueOf(1))).thenReturn(Optional.ofNullable(cloudVendor));
        assertThat(cloudVendorService.getCloudVendor(1L).getVendorName()).isEqualTo(cloudVendor.getVendorName());
        assertThat(cloudVendorService.getCloudVendor(1L).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());

    }

    @Test
    void testGetAllCloudVendors() {
        when(cloudVendorRepository.findAll()).thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));
        assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorName()).isEqualTo(cloudVendor.getVendorName());
    }

    @Test
    void testCreateCloudVendor() {
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        String result = cloudVendorService.createCloudVendor(cloudVendor);
        assertThat(result).isEqualTo("Created Successfully");
        verify(cloudVendorRepository, times(1)).save(cloudVendor);
    }

    @Test
    void testUpdateCloudVendor() {
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);

        String result = cloudVendorService.updateCloudVendor(cloudVendor);
        assertThat(result).isEqualTo("Updated Successfully");
        verify(cloudVendorRepository, times(1)).save(cloudVendor);
    }

    @Test
    void testDeleteCloudVendor() {
        doNothing().when(cloudVendorRepository).deleteById(any());
        cloudVendorService.deleteCloudVendor(1L);
        verify(cloudVendorRepository, times(1)).deleteById(1L);
    }
}