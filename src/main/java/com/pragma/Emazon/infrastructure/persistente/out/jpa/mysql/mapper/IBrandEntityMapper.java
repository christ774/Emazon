package com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.mapper;


import com.pragma.Emazon.domain.model.Brand;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.entity.BrandEntity;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface IBrandEntityMapper {

    BrandEntity toEntity(Brand brand);

    Brand toBrand(BrandEntity brandEntity);
    List<Brand> toModelList(List<BrandEntity> brandEntities);
}
