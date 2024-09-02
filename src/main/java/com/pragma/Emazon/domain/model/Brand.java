package com.pragma.Emazon.domain.model;

public class Brand {

    private Long id;
    private String name;
    private String description;

    public Brand(Long id, String name, String description) {
        if (name == null  || name.trim().isEmpty() || name.length() > 50) {
            throw new IllegalArgumentException("El nombre no puede ser nulo y debe tener máximo 50 caracteres.");
        }
        if (description == null || description.trim().isEmpty() || description.length() > 120) {
            throw new IllegalArgumentException("La descripción no puede ser nula y debe tener máximo 120 caracteres.");
        }
        this.id = id;
        this.name = name;
        this.description = description;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
