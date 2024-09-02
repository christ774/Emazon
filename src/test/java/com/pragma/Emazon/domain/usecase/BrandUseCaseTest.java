package com.pragma.Emazon.domain.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.pragma.Emazon.domain.exception.BrandAlreadyExistsException;
import com.pragma.Emazon.domain.model.Brand;
import com.pragma.Emazon.domain.spi.IBrandPersistencePort;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.extension.ExtendWith;

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
}
