package com.pragma.Emazon.application.handler;


import com.pragma.Emazon.application.dto.*;
import com.pragma.Emazon.application.mapper.IBrandRequestMapper;
import com.pragma.Emazon.application.mapper.IBrandResponseMapper;
import com.pragma.Emazon.domain.api.IBrandServicePort;
import com.pragma.Emazon.domain.model.Brand;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BrandHandler implements IBrandHandler{

    private final IBrandServicePort brandServicePort;
    private final IBrandRequestMapper brandRequestMapper;
    private final IBrandResponseMapper brandResponseMapper;



    @Override
    public void saveBrand(BrandRequest brandRequest) {
        Brand brand = brandRequestMapper.toEntity(brandRequest);
        brandServicePort.saveBrand(brand);
    }

    @Override
    public BrandListResponse getAllBrands(PaginationRequest paginationRequest) {
        List<Brand> brandList = brandServicePort.getAllBrands(paginationRequest);
        List<BrandResponse> brandResponses = brandList.stream()
                .map(brandResponseMapper::toResponse)
                .collect(Collectors.toList());
        return new BrandListResponse(brandResponses, paginationRequest.page(), paginationRequest.size());

    }
}
