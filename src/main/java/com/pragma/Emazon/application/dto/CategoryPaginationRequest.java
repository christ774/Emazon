package com.pragma.Emazon.application.dto;

public record CategoryPaginationRequest(int page, int size, String sortDirection) {
}