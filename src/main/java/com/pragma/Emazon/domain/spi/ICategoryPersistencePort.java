package com.pragma.Emazon.domain.spi;

import com.pragma.Emazon.application.dto.CategoryPaginationRequest;
import com.pragma.Emazon.domain.model.Category;

import java.util.List;

public interface ICategoryPersistencePort {
    void saveCategory(Category category);
    boolean existsByName(String name);
    List<Category> getAllCategories(CategoryPaginationRequest categoryPaginationRequest);
}
