package com.pragma.Emazon.domain.usecase;


import com.pragma.Emazon.application.dto.CategoryPaginationRequest;
import com.pragma.Emazon.domain.model.Category;
import com.pragma.Emazon.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CategoryUseCaseTest {

    @Mock
    private ICategoryPersistencePort categoryPersistencePort;
    private CategoryUseCase categoryUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        categoryUseCase = new CategoryUseCase(categoryPersistencePort);
    }

    @Test
    void testSaveCategory() {
        Category category = new Category(null, "Test", "Test Description");
        when(categoryPersistencePort.existsByName("Test")).thenReturn(false);

        categoryUseCase.saveCategory(category);

        verify(categoryPersistencePort).saveCategory(category);
    }
    @Test
    public void testGetAllCategories() {

        Category category1 = new Category(1L, "Electronics", "Devices and gadgets");
        Category category2 = new Category(2L, "Books", "Various genres");

        List<Category> categories = Arrays.asList(category1, category2);


        when(categoryPersistencePort.getAllCategories(any(CategoryPaginationRequest.class)))
                .thenReturn(categories);


        CategoryPaginationRequest request = new CategoryPaginationRequest(0, 10, "ASC");


        List<Category> result = categoryUseCase.getAllCategories(request);

        assertEquals(2, result.size());
        assertEquals("Electronics", result.get(0).getName());
        assertEquals("Books", result.get(1).getName());

        // Verify interactions
        verify(categoryPersistencePort).getAllCategories(request);
    }

}
