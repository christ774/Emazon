package com.pragma.Emazon.domain.spi;

import com.pragma.Emazon.application.dto.PaginationRequest;
import com.pragma.Emazon.domain.model.Brand;


import java.util.List;

public interface IBrandPersistencePort {
    void saveBrand(Brand brand);
    boolean existsByName(String name);
    List<Brand> getAllBrands(PaginationRequest paginationRequest);
}
