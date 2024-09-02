package com.pragma.Emazon.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BrandTest {

    @Test
    public void When_ValidNameAndDescription_Expect_BrandCreatedSuccessfully() {
        // Arrange
        String validName = "Valid Brand Name";
        String validDescription = "Valid description.";

        // Act
        Brand brand = new Brand(1L, validName, validDescription);

        // Assert
        assertNotNull(brand);
        assertEquals(1L, brand.getId());
        assertEquals(validName, brand.getName());
        assertEquals(validDescription, brand.getDescription());
    }

    @Test
    public void When_NameIsNull_Expect_IllegalArgumentException() {
        // Arrange
        String invalidName = null;
        String validDescription = "Valid description.";

        // Act & Assert
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Brand(1L, invalidName, validDescription),
                "Expected constructor to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contains("El nombre no puede ser nulo y debe tener máximo 50 caracteres."));
    }

    @Test
    public void When_NameIsEmpty_Expect_IllegalArgumentException() {
        // Arrange
        String invalidName = "";
        String validDescription = "Valid description.";

        // Act & Assert
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Brand(1L, invalidName, validDescription),
                "Expected constructor to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contains("El nombre no puede ser nulo y debe tener máximo 50 caracteres."));
    }

    @Test
    public void When_NameIsTooLong_Expect_IllegalArgumentException() {
        // Arrange
        String invalidName = "A".repeat(51); // 51 characters long
        String validDescription = "Valid description.";

        // Act & Assert
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Brand(1L, invalidName, validDescription),
                "Expected constructor to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contains("El nombre no puede ser nulo y debe tener máximo 50 caracteres."));
    }

    @Test
    public void When_DescriptionIsNull_Expect_IllegalArgumentException() {
        // Arrange
        String validName = "Valid Brand Name";
        String invalidDescription = null;

        // Act & Assert
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Brand(1L, validName, invalidDescription),
                "Expected constructor to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contains("La descripción no puede ser nula y debe tener máximo 120 caracteres."));
    }

    @Test
    public void When_DescriptionIsEmpty_Expect_IllegalArgumentException() {
        // Arrange
        String validName = "Valid Brand Name";
        String invalidDescription = "";

        // Act & Assert
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Brand(1L, validName, invalidDescription),
                "Expected constructor to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contains("La descripción no puede ser nula y debe tener máximo 120 caracteres."));
    }

    @Test
    public void When_DescriptionIsTooLong_Expect_IllegalArgumentException() {
        // Arrange
        String validName = "Valid Brand Name";
        String invalidDescription = "A".repeat(121); // 121 characters long

        // Act & Assert
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Brand(1L, validName, invalidDescription),
                "Expected constructor to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contains("La descripción no puede ser nula y debe tener máximo 120 caracteres."));
    }
}
