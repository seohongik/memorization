package com.fastcampus.jpa.bookmanager.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class HelloWorldControllerTest {


    private MockMvc mockMvc;

    @Autowired
    private HelloWorldController helloWorldController;

    @BeforeEach
    public void init(){

        mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();
    }


    @Test
    public void helloWorld() throws Exception{
        init();

        mockMvc.perform(MockMvcRequestBuilders
                .get("/helloWorld"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("helloWorld"));

    }

}