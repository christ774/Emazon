package com.pragma.Emazon.application.dto;

import java.util.List;

public record CategoryListResponse(
        List<CategoryResponse> categories,
        int page,
        int size

) {}
