package com.pragma.Emazon.infrastructure.input.restcontroller;

import com.pragma.Emazon.application.dto.CategoryRequest;
import com.pragma.Emazon.application.handler.ICategoryHandler;
import  org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(MockitoExtension.class)
public class CategoryRestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ICategoryHandler categoryHandler;

    @InjectMocks
    private CategoryRestController categoryRestController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryRestController).build();
    }

    @Test
    void testCreateCategory() throws Exception {
        mockMvc.perform(post("/category/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test\",\"description\":\"Test Description\"}"))
                .andExpect(status().isCreated());

        verify(categoryHandler).saveCategory(any(CategoryRequest.class));
    }
}