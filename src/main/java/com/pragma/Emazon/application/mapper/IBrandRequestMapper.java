package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.BrandRequest;

import com.pragma.Emazon.domain.model.Brand;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IBrandRequestMapper {

    @Mapping(target = "id", ignore = true)
    Brand toEntity(BrandRequest dto);
}
