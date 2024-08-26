package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.CategoryResponse;
import com.pragma.Emazon.domain.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public  interface ICategoryResponseMapper {

    CategoryResponse toResponse(Category category);

}
