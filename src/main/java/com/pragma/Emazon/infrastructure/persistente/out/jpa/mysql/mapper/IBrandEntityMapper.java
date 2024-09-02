package com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.mapper;


import com.pragma.Emazon.domain.model.Brand;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.entity.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface IBrandEntityMapper {

    BrandEntity toEntity(Brand brand);

    Brand toCategory(BrandEntity brandEntity);
}
