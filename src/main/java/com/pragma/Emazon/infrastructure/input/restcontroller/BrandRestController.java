package com.pragma.Emazon.infrastructure.input.restcontroller;

import com.pragma.Emazon.application.dto.BrandRequest;


import com.pragma.Emazon.application.handler.IBrandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandRestController {
    private final IBrandHandler brandHandler;

    @PostMapping("/create")
    public ResponseEntity<Void> createBrand(@RequestBody BrandRequest brandRequest) {
        brandHandler.saveBrand(brandRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
