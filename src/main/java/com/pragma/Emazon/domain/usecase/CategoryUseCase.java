package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.application.dto.CategoryPaginationRequest;
import com.pragma.Emazon.domain.api.ICategoryServicePort;
import com.pragma.Emazon.domain.model.Category;
import com.pragma.Emazon.domain.spi.ICategoryPersistencePort;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category) {
        if (categoryPersistencePort.existsByName(category.getName())) {
            throw new IllegalArgumentException("El nombre de la categoría ya existe.");
        }
        categoryPersistencePort.saveCategory(category);
    }

    @Override
    public List<Category> getAllCategories(CategoryPaginationRequest categoryPaginationRequest) {
        return categoryPersistencePort.getAllCategories(categoryPaginationRequest);
    }


}
