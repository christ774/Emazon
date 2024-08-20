package com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.adapter;


import com.pragma.Emazon.domain.model.Category;
import com.pragma.Emazon.domain.spi.ICategoryPersistencePort;

import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.mapper.ICategoryEntityMapper;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository categoryRepository;
    private  final ICategoryEntityMapper categoryEntityMapper;


    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(categoryEntityMapper.toEntity(category));
    }

    @Override
    public boolean existsByName(String name) {
        return categoryRepository.existsByName(name);
    }
}
