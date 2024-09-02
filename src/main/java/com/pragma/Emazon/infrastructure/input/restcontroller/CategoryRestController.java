package com.pragma.Emazon.infrastructure.input.restcontroller;

import com.pragma.Emazon.application.dto.CategoryListResponse;
import com.pragma.Emazon.application.dto.CategoryRequest;
import com.pragma.Emazon.application.dto.CategoryPaginationRequest;
import com.pragma.Emazon.application.handler.ICategoryHandler;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryRestController {

    private final ICategoryHandler categoryHandler;

    @PostMapping("/create")
    public ResponseEntity<Void> createCategory(@RequestBody CategoryRequest categoryRequest) {
        categoryHandler.saveCategory(categoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/list")
    public ResponseEntity<CategoryListResponse> listCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "ASC") String sortDirection)
             {
        CategoryListResponse response = categoryHandler.getAllCategories(new CategoryPaginationRequest(page,size,sortDirection.toUpperCase()));
        return ResponseEntity.ok(response);
    }

}
