package com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.adapter;


import com.pragma.Emazon.domain.model.Brand;
import com.pragma.Emazon.domain.spi.IBrandPersistencePort;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.mapper.IBrandEntityMapper;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.repository.IBrandRepository;
import lombok.RequiredArgsConstructor;

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
}
