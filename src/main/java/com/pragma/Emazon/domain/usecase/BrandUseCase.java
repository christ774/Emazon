package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.api.IBrandServicePort;
import com.pragma.Emazon.domain.exception.BrandAlreadyExistsException;
import com.pragma.Emazon.domain.model.Brand;
import com.pragma.Emazon.domain.spi.IBrandPersistencePort;


public class BrandUseCase implements IBrandServicePort {
    private final IBrandPersistencePort brandPersistencePort;

    public BrandUseCase(IBrandPersistencePort brandPersistencePort) {
        this.brandPersistencePort = brandPersistencePort;
    }

    @Override
    public void saveBrand(Brand brand) {
        if (brandPersistencePort.existsByName(brand.getName())) {
            throw new BrandAlreadyExistsException("El nombre de la marca ya existe.");
        }
        brandPersistencePort.saveBrand(brand);


    }

}
