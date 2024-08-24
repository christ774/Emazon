package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.model.Category;
import com.pragma.Emazon.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
}
