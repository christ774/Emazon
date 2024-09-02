package com.pragma.Emazon.application.handler;


import static org.mockito.Mockito.*;

import com.pragma.Emazon.application.dto.BrandRequest;
import com.pragma.Emazon.application.mapper.IBrandRequestMapper;
import com.pragma.Emazon.domain.api.IBrandServicePort;
import com.pragma.Emazon.domain.model.Brand;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class BrandHandlerTest {

    @Mock
    private IBrandServicePort brandServicePort;

    @Mock
    private IBrandRequestMapper brandRequestMapper;

    @InjectMocks
    private BrandHandler brandHandler;

    @Test
    public void When_ValidBrandRequest_Expect_BrandSavedSuccessfully() {
        // Arrange
        BrandRequest brandRequest = new BrandRequest("BrandName", "Description");
        Brand brand = new Brand(null, "BrandName", "Description");
        when(brandRequestMapper.toEntity(brandRequest)).thenReturn(brand);

        // Act
        brandHandler.saveBrand(brandRequest);

        // Assert
        verify(brandServicePort, times(1)).saveBrand(brand);
    }
}
