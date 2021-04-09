package com.vinaypy.potato;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vinaypy.potato.model.ElementDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PotatoApplicationIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void create_fetchAll() throws Exception {
        ElementDto elementDto = new ElementDto("element1","book");

        mockMvc.perform(
                post("/elements")
                .content(objectMapper.writeValueAsString(elementDto))
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated());

        mockMvc.perform(get("/elements")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
        .andExpect(jsonPath("length()").value(1))
        .andExpect(jsonPath("[0].elementName").value("element1"))
        .andExpect(jsonPath("[0].elementType").value("book"));
    }
}
