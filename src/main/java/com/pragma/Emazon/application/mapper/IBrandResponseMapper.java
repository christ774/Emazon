package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.BrandResponse;

import com.pragma.Emazon.domain.model.Brand;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IBrandResponseMapper {

    BrandResponse toResponse(Brand brand);
}
