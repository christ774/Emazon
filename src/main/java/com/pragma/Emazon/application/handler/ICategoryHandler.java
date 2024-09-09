package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.CategoryListResponse;
import com.pragma.Emazon.application.dto.CategoryRequest;
import com.pragma.Emazon.application.dto.PaginationRequest;

public interface ICategoryHandler {
    void saveCategory(CategoryRequest categoryRequest);
    CategoryListResponse getAllCategories(PaginationRequest paginationRequest);
}
