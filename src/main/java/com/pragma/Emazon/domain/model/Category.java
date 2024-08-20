package com.pragma.Emazon.domain.model;

public class Category {

    private Long id;
    private String name;
    private String description;

    public Category(Long id, String name, String description) {
        if (name == null || name.isEmpty() || name.length() > 50) {
            throw new IllegalArgumentException("El nombre debe ser no nulo, no vacío y de hasta 50 caracteres.");
        }
        if (description == null || description.isEmpty() || description.length() > 90) {
            throw new IllegalArgumentException("La descripción debe ser no nula, no vacía y de hasta 90 caracteres.");
        }
        this.id = id;
        this.name = name;
        this.description =description;
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

