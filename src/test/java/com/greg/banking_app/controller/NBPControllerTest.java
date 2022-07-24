package com.greg.banking_app.controller;

import com.greg.banking_app.client.NBPClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringJUnitConfig
@WebMvcTest(NBPController.class)
class NBPControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NBPClient client;

    @Test
    void shouldGetTableC() throws Exception {
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/nbp/tableC")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}