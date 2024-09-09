package com.pragma.Emazon.domain.api;

import com.pragma.Emazon.application.dto.PaginationRequest;
import com.pragma.Emazon.domain.model.Category;

import java.util.List;

public interface ICategoryServicePort {
    void saveCategory(Category category);
    List<Category> getAllCategories(PaginationRequest paginationRequest);
}
