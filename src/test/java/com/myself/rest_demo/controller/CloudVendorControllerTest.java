package com.myself.rest_demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.myself.rest_demo.model.CloudVendor;
import com.myself.rest_demo.service.CloudVendorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CloudVendorControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CloudVendorService cloudVendorService;

    private CloudVendorController cloudVendorController;

    CloudVendor cloudVendorOne;
    CloudVendor cloudVendorTwo;
    List<CloudVendor> cloudVendorList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cloudVendorController = new CloudVendorController(cloudVendorService);
        mockMvc = MockMvcBuilders.standaloneSetup(cloudVendorController).build();

        cloudVendorOne = new CloudVendor(1L, "Google", "USA", "xxx-xxx-xx-xx");
        cloudVendorTwo = new CloudVendor(2L, "Yandex", "Russia", "yyy-yyy-yy-yy");
        cloudVendorList = new ArrayList<>();
        cloudVendorList.add(cloudVendorOne);
        cloudVendorList.add(cloudVendorTwo);
    }

    @Test
    void testGetVendorDetails() throws Exception {
        when(cloudVendorService.getCloudVendor(1L)).thenReturn(cloudVendorOne);

        this.mockMvc.perform(get("/cloudvendor/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllVendorDetails() throws Exception {
        when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendorList);

        this.mockMvc.perform(get("/cloudvendor"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testCreateVendorDetails() throws Exception {
        String requestJson = entityToJson(cloudVendorOne);
        when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn("Created Successfully");

        this.mockMvc.perform(post("/cloudvendor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateVendorDetails() throws Exception {
        String requestJson = entityToJson(cloudVendorTwo);
        when(cloudVendorService.updateCloudVendor(cloudVendorTwo)).thenReturn("Updated Successfully");

        this.mockMvc.perform(put("/cloudvendor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteVendorDetails() throws Exception {
        when(cloudVendorService.deleteCloudVendor(2L)).thenReturn("Deleted Successfully");

        this.mockMvc.perform(delete("/cloudvendor/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private static String entityToJson(CloudVendor cloudVendor) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(cloudVendor);
    }
}
