package com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.adapter;
import com.pragma.Emazon.application.dto.CategoryPaginationRequest;
import com.pragma.Emazon.domain.model.Category;
import com.pragma.Emazon.domain.spi.ICategoryPersistencePort;

import com.pragma.Emazon.infrastructure.exception.NoDataFoundException;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.entity.CategoryEntity;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.mapper.ICategoryEntityMapper;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

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

    @Override
    public List<Category> getAllCategories(CategoryPaginationRequest categoryPaginationRequest) {
        Sort sort = Sort.by(Sort.Direction.fromString(categoryPaginationRequest.sortDirection()), "name");
        Pageable pagination = PageRequest.of(categoryPaginationRequest.page(), categoryPaginationRequest.size(),sort);

        List<CategoryEntity> category = categoryRepository.findAll( pagination).getContent();
        if (category.isEmpty()) {
            throw new NoDataFoundException();
        }
        return categoryEntityMapper.toModelList(category);
    }



}
