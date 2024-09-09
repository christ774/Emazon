package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.BrandListResponse;
import com.pragma.Emazon.application.dto.BrandRequest;

import com.pragma.Emazon.application.dto.PaginationRequest;


public interface IBrandHandler {
    void saveBrand(BrandRequest brandRequest);
    BrandListResponse getAllBrands(PaginationRequest paginationRequest);
}
