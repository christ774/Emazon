package com.pragma.Emazon.infrastructure.input.restcontroller;

import com.pragma.Emazon.application.dto.BrandListResponse;
import com.pragma.Emazon.application.dto.BrandRequest;
import com.pragma.Emazon.application.dto.PaginationRequest;
import com.pragma.Emazon.application.handler.IBrandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list")
    public ResponseEntity<BrandListResponse> listBrands(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "ASC") String sortDirection)
    {
        BrandListResponse response = brandHandler.getAllBrands(new PaginationRequest(page,size,sortDirection.toUpperCase()));
        return ResponseEntity.ok(response);
    }
}
