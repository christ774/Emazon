package com.pragma.Emazon.domain.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.pragma.Emazon.application.dto.PaginationRequest;
import com.pragma.Emazon.domain.exception.BrandAlreadyExistsException;
import com.pragma.Emazon.domain.model.Brand;
import com.pragma.Emazon.domain.model.Category;
import com.pragma.Emazon.domain.spi.IBrandPersistencePort;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BrandUseCaseTest {

    @Mock
    private IBrandPersistencePort brandPersistencePort;

    @InjectMocks
    private BrandUseCase brandUseCase;

    @Test
    public void When_BrandDoesNotExist_Expect_BrandSavedSuccessfully() {
        // Arrange
        Brand brand = new Brand(null, "BrandName", "Description");
        when(brandPersistencePort.existsByName(any())).thenReturn(false);

        // Act
        brandUseCase.saveBrand(brand);

        // Assert
        verify(brandPersistencePort, times(1)).saveBrand(brand);
    }

    @Test
    public void When_BrandExists_Expect_BrandAlreadyExistsException() {
        // Arrange
        Brand brand = new Brand(null, "BrandName", "Description");
        when(brandPersistencePort.existsByName(any())).thenReturn(true);

        // Act & Assert
        assertThrows(BrandAlreadyExistsException.class, () -> brandUseCase.saveBrand(brand));
    }
    @Test
    public void testGetAllBrand() {

        Brand bran1 = new Brand(1L, "Electronics", "Devices and gadgets");
        Brand brand2 = new Brand(2L, "Books", "Various genres");

        List<Brand> brands = Arrays.asList(bran1, brand2);


        when(brandPersistencePort.getAllBrands(any(PaginationRequest.class)))
                .thenReturn(brands);


        PaginationRequest request = new PaginationRequest(0, 10, "ASC");


        List<Brand> result = brandUseCase.getAllBrands(request);

        assertEquals(2, result.size());
        assertEquals("Electronics", result.get(0).getName());
        assertEquals("Books", result.get(1).getName());

        // Verify interactions
        verify(brandPersistencePort).getAllBrands(request);
    }

}
