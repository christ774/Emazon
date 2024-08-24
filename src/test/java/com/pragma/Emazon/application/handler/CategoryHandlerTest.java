package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.CategoryRequest;
import com.pragma.Emazon.application.mapper.ICategoryRequestMapper;
import com.pragma.Emazon.domain.api.ICategoryServicePort;
import com.pragma.Emazon.domain.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CategoryHandlerTest {
    @Mock
    private ICategoryServicePort categoryServicePort;
    @Mock private ICategoryRequestMapper categoryRequestMapper;
    private CategoryHandler categoryHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        categoryHandler = new CategoryHandler(categoryServicePort, categoryRequestMapper);
    }

    @Test
    void testSaveCategory() {
        CategoryRequest request = new CategoryRequest("Test", "Test Description");
        Category category = new Category(null, "Test", "Test Description");
        when(categoryRequestMapper.toEntity(request)).thenReturn(category);

        categoryHandler.saveCategory(request);

        verify(categoryServicePort).saveCategory(category);
    }
}
