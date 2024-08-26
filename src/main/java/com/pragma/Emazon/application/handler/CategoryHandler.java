package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.CategoryListResponse;
import com.pragma.Emazon.application.dto.CategoryRequest;
import com.pragma.Emazon.application.dto.CategoryResponse;
import com.pragma.Emazon.application.dto.CategoryPaginationRequest;
import com.pragma.Emazon.application.mapper.ICategoryRequestMapper;

import com.pragma.Emazon.application.mapper.ICategoryResponseMapper;
import com.pragma.Emazon.domain.api.ICategoryServicePort;
import com.pragma.Emazon.domain.model.Category;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CategoryHandler implements ICategoryHandler{

    private final ICategoryServicePort categoryServicePort;
    private final ICategoryRequestMapper categoryRequestMapper;
    private final ICategoryResponseMapper categoryResponseMapper;



    @Override
    public void saveCategory(CategoryRequest categoryRequest) {
        Category category = categoryRequestMapper.toEntity(categoryRequest);
        categoryServicePort.saveCategory(category);

    }

    @Override
    public CategoryListResponse getAllCategories(CategoryPaginationRequest categoryPaginationRequest) {
        List<Category> categories = categoryServicePort.getAllCategories(categoryPaginationRequest);
        List<CategoryResponse> categoryResponses = categories.stream()
                .map(categoryResponseMapper::toResponse)
                .collect(Collectors.toList());
        return new CategoryListResponse(categoryResponses, categoryPaginationRequest.page(), categoryPaginationRequest.size());
    }



}
