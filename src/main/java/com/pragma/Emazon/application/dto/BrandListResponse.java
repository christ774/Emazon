package com.pragma.Emazon.application.dto;

import java.util.List;

public record BrandListResponse(List<BrandResponse> brandResponseList,
                                int page,
                                int size) {
}
