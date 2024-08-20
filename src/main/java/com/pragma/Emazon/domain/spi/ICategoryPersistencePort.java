package com.pragma.Emazon.domain.spi;

import com.pragma.Emazon.domain.model.Category;

public interface ICategoryPersistencePort {
    void saveCategory(Category category);
    boolean existsByName(String name);
}
