package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.CategoryRequest;
import com.pragma.Emazon.application.mapper.ICategoryRequestMapper;
import com.pragma.Emazon.domain.api.ICategoryServicePort;
import com.pragma.Emazon.domain.model.Category;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryHandler implements ICategoryHandler{

    private final ICategoryServicePort categoryServicePort;
    private final ICategoryRequestMapper categoryRequestMapper;

    @Override
    public void saveCategory(CategoryRequest categoryRequest) {
        Category category = categoryRequestMapper.toEntity(categoryRequest);
        categoryServicePort.saveCategory(category);

    }
}
