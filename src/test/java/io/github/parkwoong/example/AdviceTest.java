package io.github.parkwoong.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class AdviceTest {
    @Autowired MockMvc mvc;

    @Test
    void mapsExpectedAndUnexpectedErrors() throws Exception {
        mvc.perform(get("/sample/bad"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode").value("API400"));
        mvc.perform(get("/sample/fail"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.message.errorMessage").value("Unexpected error"));
    }
}
