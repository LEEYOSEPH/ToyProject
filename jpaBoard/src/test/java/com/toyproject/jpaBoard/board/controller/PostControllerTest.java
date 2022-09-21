package com.toyproject.jpaBoard.board.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private  MockMvc mockMvc;

    @Test
    @DisplayName("/posts 요청시 확인")
    void test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/posts"))
                .andExpect(status().isOk())
                .andExpect(content().string("zzz"))
                .andDo(MockMvcResultHandlers.print());
    }
}