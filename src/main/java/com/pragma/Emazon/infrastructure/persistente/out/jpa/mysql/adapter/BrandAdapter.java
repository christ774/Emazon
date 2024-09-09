package com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.adapter;


import com.pragma.Emazon.application.dto.PaginationRequest;
import com.pragma.Emazon.domain.model.Brand;
import com.pragma.Emazon.domain.spi.IBrandPersistencePort;
import com.pragma.Emazon.infrastructure.exception.NoDataFoundException;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.entity.BrandEntity;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.mapper.IBrandEntityMapper;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.repository.IBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class BrandAdapter implements IBrandPersistencePort {

    private final IBrandRepository brandRepository;
    private final IBrandEntityMapper brandEntityMapper;


    @Override
    public void saveBrand(Brand brand) {

        brandRepository.save(brandEntityMapper.toEntity(brand));

    }

    @Override
    public boolean existsByName(String name) {
        return brandRepository.existsByName(name);
    }

    @Override
    public List<Brand> getAllBrands(PaginationRequest paginationRequest) {
        Sort sort = Sort.by(Sort.Direction.fromString(paginationRequest.sortDirection()), "name");
        Pageable pagination = PageRequest.of(paginationRequest.page(), paginationRequest.size(),sort);

        List<BrandEntity> brand = brandRepository.findAll( pagination).getContent();
        if (brand.isEmpty()) {
            throw new NoDataFoundException("No se encontraron marcas disponibles con los criterios proporcionados.");
        }
        return brandEntityMapper.toModelList(brand);
    }
}
