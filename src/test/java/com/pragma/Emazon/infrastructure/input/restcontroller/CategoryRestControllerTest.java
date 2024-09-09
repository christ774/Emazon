package com.pragma.Emazon.infrastructure.input.restcontroller;

import com.pragma.Emazon.application.dto.CategoryListResponse;
import com.pragma.Emazon.application.dto.PaginationRequest;
import com.pragma.Emazon.application.dto.CategoryRequest;
import com.pragma.Emazon.application.handler.ICategoryHandler;
import  org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
    @Test
    void listCategories_shouldReturnOkResponseWithCategoryListResponse() {
        // Arrange
        int page = 0;
        int size = 10;
        String sortDirection = "ASC";
        PaginationRequest expectedRequest = new PaginationRequest(page, size, sortDirection);
        CategoryListResponse mockResponse = new CategoryListResponse(Collections.emptyList(), page, size);

        when(categoryHandler.getAllCategories(expectedRequest)).thenReturn(mockResponse);

        // Act
        ResponseEntity<CategoryListResponse> response = categoryRestController.listCategories(page, size, sortDirection);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
        verify(categoryHandler).getAllCategories(expectedRequest);
    }
}