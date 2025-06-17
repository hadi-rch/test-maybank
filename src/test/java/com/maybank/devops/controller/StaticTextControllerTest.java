package com.maybank.devops.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StaticTextController.class)
public class StaticTextControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetStaticText() throws Exception {
        mockMvc.perform(get("/api/static-text"))
                .andExpect(status().isOk())
                .andExpect(content().string("Ini adalah teks statis."));
    }
}
