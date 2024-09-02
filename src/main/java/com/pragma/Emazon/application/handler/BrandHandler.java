package com.pragma.Emazon.application.handler;


import com.pragma.Emazon.application.dto.BrandRequest;
import com.pragma.Emazon.application.mapper.IBrandRequestMapper;
import com.pragma.Emazon.domain.api.IBrandServicePort;
import com.pragma.Emazon.domain.model.Brand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BrandHandler implements IBrandHandler{

    private final IBrandServicePort brandServicePort;
    private final IBrandRequestMapper brandRequestMapper;



    @Override
    public void saveBrand(BrandRequest brandRequest) {
        Brand brand = brandRequestMapper.toEntity(brandRequest);
        brandServicePort.saveBrand(brand);
    }
}
