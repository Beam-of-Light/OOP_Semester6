package com.oop.lab2.airport;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class AirportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAirports() throws Exception {
        this.mockMvc.perform(get("/airports")).andExpect(status().isUnauthorized());
    }


    @Test
    void addAirport() throws Exception {

        this.mockMvc.perform(post("/airports")
                .contentType("application/json;charset=UTF-8")
                .content("{\"email\":\"jim@yahoo.com\",\"name\":\"Jim\"}")
        ).andExpect(status().isUnauthorized());
    }

    @Test
    void updateAirport() throws Exception {
        this.mockMvc.perform(put("/airports")
                .contentType("application/json;charset=UTF-8")
                .content("{\"email\":\"jim@yahoo.com\",\"name\":\"Jim\"}")
        ).andExpect(status().isUnauthorized());
    }

    @Autowired
    private AirportController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}