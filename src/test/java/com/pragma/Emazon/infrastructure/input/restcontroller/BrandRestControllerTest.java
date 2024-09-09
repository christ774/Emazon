package com.pragma.Emazon.infrastructure.input.restcontroller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.pragma.Emazon.application.dto.BrandListResponse;
import com.pragma.Emazon.application.dto.BrandRequest;
import com.pragma.Emazon.application.dto.CategoryListResponse;
import com.pragma.Emazon.application.dto.PaginationRequest;
import com.pragma.Emazon.application.handler.IBrandHandler;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class BrandRestControllerTest {

    @Mock
    private IBrandHandler brandHandler;

    @InjectMocks
    private BrandRestController brandRestController;

    @Test
    public void When_ValidBrandRequest_Expect_CreatedStatus() {
        // Arrange
        BrandRequest brandRequest = new BrandRequest("BrandName", "Description");

        // Act
        ResponseEntity<Void> response = brandRestController.createBrand(brandRequest);

        // Assert
        verify(brandHandler, times(1)).saveBrand(brandRequest);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
    @Test
    void listBrands_shouldReturnOkResponseWithBrandListResponse() {
        // Arrange
        int page = 0;
        int size = 10;
        String sortDirection = "ASC";
        PaginationRequest expectedRequest = new PaginationRequest(page, size, sortDirection);
        BrandListResponse mockResponse = new BrandListResponse(Collections.emptyList(), page, size);

        when(brandHandler.getAllBrands(expectedRequest)).thenReturn(mockResponse);

        // Act
        ResponseEntity<BrandListResponse> response = brandRestController.listBrands(page, size, sortDirection);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
        verify(brandHandler).getAllBrands(expectedRequest);
    }
}
