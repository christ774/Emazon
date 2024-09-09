package com.pragma.Emazon.domain.api;

import com.pragma.Emazon.application.dto.PaginationRequest;
import com.pragma.Emazon.domain.model.Brand;


import java.util.List;

public interface IBrandServicePort {
    void saveBrand(Brand brand);
    List<Brand> getAllBrands(PaginationRequest paginationRequest);

}
