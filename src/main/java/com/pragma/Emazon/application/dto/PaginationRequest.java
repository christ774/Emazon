package com.pragma.Emazon.application.dto;

public record PaginationRequest(int page, int size, String sortDirection) {
}