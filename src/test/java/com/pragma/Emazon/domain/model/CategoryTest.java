package com.pragma.Emazon.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CategoryTest {
    @Test
    void testValidCategory() {
        Category category = new Category(1L, "Electronics", "Electronic devices");
        assertEquals("Electronics", category.getName());
        assertEquals("Electronic devices", category.getDescription());
    }

    @Test
    void testInvalidCategoryName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Category(1L, "", "Description")
        );
    }
}
