package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.CategoryRequest;
import com.pragma.Emazon.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICategoryRequestMapper {

    @Mapping(target = "id", ignore = true)
    Category toEntity(CategoryRequest dto);
}
