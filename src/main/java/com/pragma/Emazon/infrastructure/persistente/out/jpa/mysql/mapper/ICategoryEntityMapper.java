package com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.mapper;


import com.pragma.Emazon.domain.model.Category;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface ICategoryEntityMapper {

    CategoryEntity toEntity(Category category);

    Category toCategory(CategoryEntity categoryEntity);

}
