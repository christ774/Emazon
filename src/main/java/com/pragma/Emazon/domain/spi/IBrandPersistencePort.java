package com.pragma.Emazon.domain.spi;

import com.pragma.Emazon.domain.model.Brand;

public interface IBrandPersistencePort {
    void saveBrand(Brand brand);

    boolean existsByName(String name);
}
